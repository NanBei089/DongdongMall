package com.nanbei.exception;

import com.nanbei.controller.BrandController;
import com.nanbei.controller.SpecificationController;
import com.nanbei.mapper.SpecificationMapper;
import com.nanbei.mapper.SpecificationOptionMapper;
import com.nanbei.pojo.Specification;
import com.nanbei.pojo.SpecificationOption;
import com.nanbei.service.BrandService;
import com.nanbei.service.ipml.SpecificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class GlobalExceptionHandlerTest {
    private MockMvc mvc;
    private SpecificationMapper specificationMapper;
    private SpecificationOptionMapper optionMapper;
    private BrandService brandService;

    @BeforeEach
    void setUp() {
        specificationMapper = mock(SpecificationMapper.class);
        optionMapper = mock(SpecificationOptionMapper.class);
        SpecificationServiceImpl service = new SpecificationServiceImpl();
        ReflectionTestUtils.setField(service, "specificationMapper", specificationMapper);
        ReflectionTestUtils.setField(service, "specificationOptionMapper", optionMapper);
        SpecificationController specificationController = new SpecificationController();
        ReflectionTestUtils.setField(specificationController, "specificationService", service);

        brandService = mock(BrandService.class);
        BrandController brandController = new BrandController();
        ReflectionTestUtils.setField(brandController, "brandService", brandService);
        mvc = MockMvcBuilders.standaloneSetup(specificationController, brandController)
                .setControllerAdvice(new GlobalExceptionHandler()).build();
    }

    @Test
    void missingSpecificationReturnsBusinessMessage() throws Exception {
        mvc.perform(get("/specification/detail/99"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(-1003))
                .andExpect(jsonPath("$.message").value("规格不存在"));
        verifyNoInteractions(optionMapper);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "0", "-1"})
    void invalidIdReturnsParameterError(String id) throws Exception {
        mvc.perform(get("/specification/detail/" + id))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(-1002));
        verifyNoInteractions(specificationMapper, optionMapper);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "{}",
            "{\"specification\":{}}",
            "{\"specification\":{\"specName\":\"  \"},\"specificationOption\":[]}",
            "{\"specification\":{\"specName\":\"颜色\"}}",
            "{\"specification\":{\"specName\":\"颜色\"},\"specificationOption\":[null]}",
            "{\"specification\":{\"specName\":\"颜色\"},\"specificationOption\":[{\"optionName\":\" \"}]}"
    })
    void invalidFormIsRejectedBeforeDatabaseAccess(String body) throws Exception {
        mvc.perform(post("/specification/add").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(-1002));
        verifyNoInteractions(specificationMapper, optionMapper);
    }

    @Test
    void updateRequiresId() throws Exception {
        mvc.perform(post("/specification/update").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"specification\":{\"specName\":\"颜色\"},\"specificationOption\":[]}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("规格 ID 必须为正整数"));
        verifyNoInteractions(specificationMapper, optionMapper);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "[{\"id\":20,\"optionName\":\"红色\"}]",
            "[{\"id\":10,\"optionName\":\"红色\"},{\"id\":10,\"optionName\":\"蓝色\"}]"
    })
    void foreignOrDuplicateOptionReturnsBusinessError(String options) throws Exception {
        when(specificationMapper.selectByPrimaryKey(1L)).thenReturn(new Specification(1L, "颜色"));
        when(optionMapper.selectBySpecId(1L))
                .thenReturn(List.of(new SpecificationOption(10L, "红色", 1L, 1)));
        mvc.perform(post("/specification/update").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"specification\":{\"id\":1,\"specName\":\"颜色\"},\"specificationOption\":" + options + "}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(-1003))
                .andExpect(jsonPath("$.message").value("选项不存在、重复或不属于当前规格"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "{broken"})
    void missingOrMalformedBodyReturnsParameterError(String body) throws Exception {
        mvc.perform(post("/brand/add").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(-1002))
                .andExpect(jsonPath("$.message").value("请求体缺失或 JSON 格式错误"));
        verifyNoInteractions(brandService);
    }

    @Test
    void emptyOptionsRemainAValidSuccessfulRequest() throws Exception {
        mvc.perform(post("/specification/add").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"specification\":{\"specName\":\"颜色\"},\"specificationOption\":[]}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        verify(specificationMapper).insertSpecification(any(Specification.class));
        verifyNoInteractions(optionMapper);
    }

    @Test
    void unexpectedFailureIsHiddenFromClient() throws Exception {
        when(brandService.queryAll()).thenThrow(new IllegalStateException("internal database details"));
        mvc.perform(get("/brand/queryAll"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.code").value(-1004))
                .andExpect(jsonPath("$.message").value("系统异常"));
    }

    @Test
    void explicitHttpStatusIsPreserved() throws Exception {
        when(brandService.queryAll()).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "资源不存在"));
        mvc.perform(get("/brand/queryAll"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("资源不存在"));
    }

    @Test
    void unsupportedMethodPreservesStatusAndAllowHeader() throws Exception {
        mvc.perform(get("/specification/add"))
                .andExpect(status().isMethodNotAllowed())
                .andExpect(header().string("Allow", containsString("POST")))
                .andExpect(jsonPath("$.code").value(-1002));
    }

    @Test
    void unsupportedContentTypePreservesStatus() throws Exception {
        mvc.perform(post("/specification/add").contentType(MediaType.TEXT_PLAIN).content("text"))
                .andExpect(status().isUnsupportedMediaType())
                .andExpect(jsonPath("$.code").value(-1002));
    }
}

package com.nanbei.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("东东商城商品服务 API 文档")
                        .version("1.0-SNAPSHOT")
                        .description("商品服务接口文档"))
                .servers(List.of(new Server().url("/").description("商城网关")));
    }
}

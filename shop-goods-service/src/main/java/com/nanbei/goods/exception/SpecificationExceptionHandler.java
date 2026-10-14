package com.nanbei.goods.exception;

import com.nanbei.goods.controller.SpecificationController;
import com.nanbei.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice(assignableTypes = SpecificationController.class)
public class SpecificationExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(SpecificationExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> handleArgument(IllegalArgumentException exception) {
        return Result.error(400, exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> handleRequestBody(HttpMessageNotReadableException exception) {
        return Result.error(400, "请求体缺失或 JSON 格式错误");
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Result<Void>> handleStatus(ResponseStatusException exception) {
        return ResponseEntity.status(exception.getStatusCode())
                .body(Result.error(exception.getStatusCode().value(), exception.getReason()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Void> handleException(Exception exception) {
        log.error("规格接口处理失败", exception);
        return Result.error(500, "操作失败，请查看服务日志");
    }
}

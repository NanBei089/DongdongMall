package com.nanbei.exception;

import com.nanbei.enums.ExceptionEnum;
import com.nanbei.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice  // 全局异常处理
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> businessException(BusinessException e) {
        log.warn("业务异常：{}", e.getMessage());
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> requestBodyException(HttpMessageNotReadableException e) {
        return Result.error(ExceptionEnum.PARAM_ERROR.getCode(), "请求体缺失或 JSON 格式错误");
    }

    @ExceptionHandler({TypeMismatchException.class, BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> parameterException(Exception e) {
        return Result.error(ExceptionEnum.PARAM_ERROR);
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<Void>> exception(Exception e) {
        // 保留框架异常的 HTTP 状态和响应头，例如 404、405、415。
        if (e instanceof ErrorResponse errorResponse) {
            boolean serverError = errorResponse.getStatusCode().is5xxServerError();
            if (serverError) {
                log.error("系统异常", e);
            }
            ExceptionEnum error = serverError ? ExceptionEnum.SYSTEM_ERROR : ExceptionEnum.PARAM_ERROR;
            String message = error.getMessage();
            if (!serverError && e instanceof ResponseStatusException statusException
                    && statusException.getReason() != null) {
                message = statusException.getReason();
            }
            return ResponseEntity.status(errorResponse.getStatusCode())
                    .headers(errorResponse.getHeaders())
                    .body(Result.error(error.getCode(), message));
        }
        log.error("系统异常", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Result.error(ExceptionEnum.SYSTEM_ERROR));
    }
}

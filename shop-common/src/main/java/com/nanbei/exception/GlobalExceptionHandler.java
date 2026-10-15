package com.nanbei.exception;

import com.nanbei.enums.ExceptionEnum;
import com.nanbei.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // 全局异常处理
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Void> businessException(BusinessException e) {
        log.error("业务异常：{}", e.getMessage());
        return Result.error(e.getCode(), e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> exception(Exception e) {
        log.error("系统异常", e);
        return Result.error(ExceptionEnum.SYSTEM_ERROR);
    }
}

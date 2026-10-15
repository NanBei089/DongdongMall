package com.nanbei.result;

import com.nanbei.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 各服务通用的响应体，code 表示业务状态码。
 *
 * @param <T> 返回数据的类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success() {
        return new Result<>(200, "操作成功",null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    public static <T> Result<T> success(ExceptionEnum exceptionEnum) {
        return new Result<>(exceptionEnum.getCode(), exceptionEnum.getMessage(), null);
    }


    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> error(ExceptionEnum exceptionEnum) {
        return new Result<>(exceptionEnum.getCode(), exceptionEnum.getMessage(), null);
    }
}

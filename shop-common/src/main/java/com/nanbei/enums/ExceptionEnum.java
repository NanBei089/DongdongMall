package com.nanbei.enums;

public enum ExceptionEnum {
    NETWORK_ERROR(-1001, "网络异常"),
    PARAM_ERROR(-1002, "参数异常"),
    BUSINESS_ERROR(-1003, "业务异常"),
    SYSTEM_ERROR(-1004, "系统异常"),
    ;
    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private final Integer code;
    private final String message;

    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}

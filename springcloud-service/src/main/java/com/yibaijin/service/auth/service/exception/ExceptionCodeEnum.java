package com.yibaijin.service.auth.service.exception;

public enum ExceptionCodeEnum {
    ;

    private final int value;

    private final String reasonPhrase;

    ExceptionCodeEnum(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }
}

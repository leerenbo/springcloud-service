package com.yibaijin.service.auth.service.exception;

public class AlertException extends RuntimeException {
    private ExceptionCodeEnum exceptionCodeEnum;
    private Boolean alertRD;
    private Boolean alertPM;

    public ExceptionCodeEnum getExceptionCodeEnum() {
        return exceptionCodeEnum;
    }

    public void setExceptionCodeEnum(ExceptionCodeEnum exceptionCodeEnum) {
        this.exceptionCodeEnum = exceptionCodeEnum;
    }

    public Boolean getAlertRD() {
        return alertRD;
    }

    public void setAlertRD(Boolean alertRD) {
        this.alertRD = alertRD;
    }

    public Boolean getAlertPM() {
        return alertPM;
    }

    public void setAlertPM(Boolean alertPM) {
        this.alertPM = alertPM;
    }
}

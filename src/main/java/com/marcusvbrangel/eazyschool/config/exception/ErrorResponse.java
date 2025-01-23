package com.marcusvbrangel.eazyschool.config.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class ErrorResponse {

    private HttpStatus httpStatusCode;
    private String friendlyErrorMessage;
    private String exceptionErrorMessage;
    private LocalDateTime dataHoraDoErro = LocalDateTime.now();
    private String codigoLog = UUID.randomUUID().toString();
    private String requestMethod;
    private String requestUrl;

    public ErrorResponse(HttpStatus httpStatusCode,
                         String friendlyErrorMessage,
                         String exceptionErrorMessage,
                         String requestMethod,
                         String requestUrl) {
        this.httpStatusCode = httpStatusCode;
        this.friendlyErrorMessage = friendlyErrorMessage;
        this.exceptionErrorMessage = exceptionErrorMessage;
        this.requestMethod = requestMethod;
        this.requestUrl = requestUrl;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getFriendlyErrorMessage() {
        return friendlyErrorMessage;
    }

    public String getExceptionErrorMessage() {
        return exceptionErrorMessage;
    }

    public LocalDateTime getDataHoraDoErro() {
        return dataHoraDoErro;
    }

    public String getCodigoLog() {
        return codigoLog;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }
}

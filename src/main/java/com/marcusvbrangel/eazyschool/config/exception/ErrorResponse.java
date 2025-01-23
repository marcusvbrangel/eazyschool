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

    public ErrorResponse(HttpStatus httpStatusCode,
                         String friendlyErrorMessage,
                         String exceptionErrorMessage) {
        this.httpStatusCode = httpStatusCode;
        this.friendlyErrorMessage = friendlyErrorMessage;
        this.exceptionErrorMessage = exceptionErrorMessage;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(HttpStatus httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getFriendlyErrorMessage() {
        return friendlyErrorMessage;
    }

    public void setFriendlyErrorMessage(String friendlyErrorMessage) {
        this.friendlyErrorMessage = friendlyErrorMessage;
    }

    public String getExceptionErrorMessage() {
        return exceptionErrorMessage;
    }

    public void setExceptionErrorMessage(String exceptionErrorMessage) {
        this.exceptionErrorMessage = exceptionErrorMessage;
    }

    public LocalDateTime getDataHoraDoErro() {
        return dataHoraDoErro;
    }

    public String getCodigoLog() {
        return codigoLog;
    }

}

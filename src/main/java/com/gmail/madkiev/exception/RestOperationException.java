package com.gmail.madkiev.exception;

import org.springframework.http.HttpStatus;

public class RestOperationException extends RuntimeException {

    private static final long serialVersionUID = 722280942302639255L;

    private final HttpStatus statusCode;
    private final String errorCode;

    public RestOperationException(String errorMessage, HttpStatus statusCode) {
        super(errorMessage);
        this.statusCode = statusCode;
        this.errorCode = null;
    }

    public RestOperationException(String errorMessage, HttpStatus statusCode, String errorCode) {
        super(errorMessage);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public RestOperationException(String errorMessage, HttpStatus statusCode, String errorCode,
                                   Throwable cause) {
        super(errorMessage, cause);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

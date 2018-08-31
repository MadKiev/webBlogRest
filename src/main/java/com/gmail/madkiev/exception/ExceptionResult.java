package com.gmail.madkiev.exception;

class ExceptionResult {
    private boolean result;
    private String message;
    
    public ExceptionResult(String message) {
        this.message = message;
        this.result = false;
    }

    public ExceptionResult(Exception e) {
        this.message = e.getMessage();
        this.result = false;
    }
    
    public boolean isResult() {
        return result;
    }
    public String getMessage() {
        return message;
    }
}
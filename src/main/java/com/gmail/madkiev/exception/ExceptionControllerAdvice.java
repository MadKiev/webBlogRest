package com.gmail.madkiev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ExceptionResult> exception(Exception e) {
        return new ResponseEntity<ExceptionResult>(prepareExceptionResult(e),
            HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResult> accessDeniedException(AccessDeniedException e) {
        return new ResponseEntity<ExceptionResult>(prepareExceptionResult(e), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(RestOperationException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResult> restOperationException(RestOperationException e) {
        return new ResponseEntity<ExceptionResult>(prepareExceptionResult(e), e.getStatusCode());
    }
    
    private ExceptionResult prepareExceptionResult(Exception e) {
        if (e.getMessage() == null) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            return new ExceptionResult(errors.toString());
        } else {
            return new ExceptionResult(e);
        }
    }
}

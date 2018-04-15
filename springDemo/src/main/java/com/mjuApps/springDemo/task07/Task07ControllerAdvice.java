package com.mjuApps.springDemo.task07;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author marek_j on 2018-04-15
 */
@RestControllerAdvice
public class Task07ControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorResponse handle(CustomException e, ServletWebRequest request) {
        return ErrorResponse.of(HttpStatus.I_AM_A_TEAPOT, request.getRequest().getRequestURI(), "my custom exception");
    }
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ValidatorError handleValidatorErrors(CustomException e, ServletWebRequest request) {
//
//
//        return null;
//    }
}

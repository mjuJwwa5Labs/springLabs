package com.mjuApps.springDemo.homework.errorHandling;


import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marek_j on 2018-04-18
 */
@RestControllerAdvice
public class HotelControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HotelAppErrorResponse handleMethodArgumentException(MethodArgumentTypeMismatchException ex, ServletWebRequest request) {
        return HotelAppErrorResponse.of(HttpStatus.BAD_REQUEST, "method argument not valid (check if given numbers are not string)", request.getRequest().getRequestURI(),null);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public HotelAppErrorResponse handleFieldValidationException(MethodArgumentNotValidException ex, ServletWebRequest request) {
        List<HotelAppErrorResponse.ValidationError> resultErrorsList = new ArrayList<>();
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        for (ObjectError objectError : errors) {
            Object rejectedValue = ((FieldError) objectError).getRejectedValue();
            resultErrorsList.add(new HotelAppErrorResponse.ValidationError(objectError.getObjectName(),objectError.getDefaultMessage(),rejectedValue));
        }
        return HotelAppErrorResponse.of(HttpStatus.UNPROCESSABLE_ENTITY, "fields validation problem", request.getRequest().getRequestURI(),resultErrorsList);
    }

}

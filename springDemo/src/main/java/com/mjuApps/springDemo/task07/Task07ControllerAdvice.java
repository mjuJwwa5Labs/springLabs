package com.mjuApps.springDemo.task07;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marek_j on 2018-04-15
 */
@RestControllerAdvice
public class Task07ControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorResponse handle(CustomException e, ServletWebRequest request) {
        return ErrorResponse.of(HttpStatus.I_AM_A_TEAPOT, "Method Exeception not valid", request.getRequest().getRequestURI());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidatorErrors(MethodArgumentNotValidException e, ServletWebRequest request) {
        List<ErrorResponse.ValidationError> resultErrorsList = new ArrayList<>();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        for (ObjectError objectError : errors) {
            Object rejectedValue = ((FieldError) objectError).getRejectedValue();
            resultErrorsList.add(new ErrorResponse.ValidationError(objectError.getObjectName(),objectError.getDefaultMessage(),rejectedValue));
        }
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, "method argument not valid", request.getRequest().getRequestURI(),resultErrorsList);
    }

    /*
           @ExceptionHandler
        public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException e, ServletWebRequest request) {
            List<ValidationError> validationErrors = buildValidationErrors(e);

            return ErrorResponse.of(
                    UNPROCESSABLE_ENTITY,
                    "Validation failed",
                    request.getRequest().getRequestURI(),
                    validationErrors
            ).toResponseEntity();
        }

        private List<ValidationError> buildValidationErrors(MethodArgumentNotValidException e) {
            return Optional.of(e)
                    .map(MethodArgumentNotValidException::getBindingResult)
                    .map(Errors::getAllErrors)
                    .map(Collection::stream)
                    .orElse(empty())
                    .map(this::asErrorDescription)
                    .collect(toList());
        }

        private ValidationError asErrorDescription(ObjectError objectError) {
            FieldError fieldError = (FieldError) objectError;

            return new ValidationError(
                    fieldError.getField(),
                    fieldError.getDefaultMessage(),
                    fieldError.getRejectedValue()
            );
    }
     */
}

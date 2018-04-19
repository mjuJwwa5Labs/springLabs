package com.mjuApps.springDemo.homework.errorHandling;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author marek_j on 2018-04-15
 */
public class HotelAppErrorResponse {    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private List<ValidationError> validationErrors;

    public HotelAppErrorResponse() {
    }

    public HotelAppErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path, List<ValidationError> validationErrors) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.validationErrors = validationErrors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    static HotelAppErrorResponse of(HttpStatus status, String message, String path){
        return of(status, message, path, new ArrayList<>());
    }

    static HotelAppErrorResponse of(HttpStatus status, String message, String path, List<ValidationError> validationErrors){
        return new HotelAppErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                path,
                validationErrors
        );
    }

    static class ValidationError {
        private String fieldName;
        private String message;
        private Object rejectedValue;

        public ValidationError(String fieldName, String message, Object rejectedValue) {
            this.fieldName = fieldName;
            this.message = message;
            this.rejectedValue = rejectedValue;
        }

        public ValidationError() {
        }

        public String getFieldName() {
            return fieldName;
        }

        public String getMessage() {
            return message;
        }

        public Object getRejectedValue() {
            return rejectedValue;
        }
    }
}
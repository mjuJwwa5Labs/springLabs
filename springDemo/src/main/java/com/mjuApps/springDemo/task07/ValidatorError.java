package com.mjuApps.springDemo.task07;

/**
 * @author marek_j on 2018-04-15
 */
public class ValidatorError {

    private String field;
    private String message;

    public ValidatorError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}

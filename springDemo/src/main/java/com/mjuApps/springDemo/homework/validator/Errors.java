package com.mjuApps.springDemo.homework.validator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Errors {

    private Map<String,List<String>> errors;

    public void addError(String errorReason, String errorMessage) {
        if (errors==null) {
            this.errors = new HashMap<>();
        }

        List<String> errorMessagesList = errors.get(errorReason);

        if (errorMessagesList==null) {
            errorMessagesList = new ArrayList<>();
        }

        errorMessagesList.add(errorMessage);
        errors.put(errorReason,errorMessagesList);
    }

    public List<String> getErrorMessages(String fieldName) {
        return this.errors.get(fieldName);
    }

    public boolean hasErrors() {
        return errors!=null && errors.size()>0;
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }

}

package edu.andrew.errors;

import java.util.ArrayList;
import java.util.List;

public class UserValidationError {
    private List<String> errorList = new ArrayList<>();

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
    
    public void addError(String error) {
        errorList.add(error);
    }
    
    public void removeError(String error) {
        errorList.remove(error);
    }

    public static UserValidationError getUserErrors(UserValidationError error) {
        return error != null ? error : null;
    }
}

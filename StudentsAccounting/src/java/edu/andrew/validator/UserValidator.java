package edu.andrew.validator;

import edu.andrew.errors.UserValidationError;
import edu.andrew.model.User;

public class UserValidator {
    public static void validate(String login, String password, UserValidationError error) {
        if (login.trim().length() == 0 ||
                login.chars().anyMatch(c -> !Character.isLetter(c))) {
            error.addError("user.name.error");
        }
        
        if (login.trim().length() == 0 ||
                login.chars().anyMatch(c -> !Character.isLetterOrDigit(c))) {
            error.addError("user.login.error");            
        }
        
        if (password.trim().length() == 0) {
            error.addError("user.pass.error");
        }
    }
}

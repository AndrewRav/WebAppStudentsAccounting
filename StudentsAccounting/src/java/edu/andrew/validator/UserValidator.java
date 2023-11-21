package edu.andrew.validator;

import edu.andrew.errors.UserValidationError;
import edu.andrew.model.User;

public class UserValidator {
    public static void validate(User user, UserValidationError error) {
        if (user.getFirstName().trim().length() == 0 ||
                user.getFirstName().chars().anyMatch(c -> !Character.isLetter(c))) {
            error.addError("user.name.error");
        }
        
        if (user.getLogin().trim().length() == 0 ||
                user.getLogin().chars().anyMatch(c -> !Character.isLetterOrDigit(c))) {
            error.addError("user.login.error");            
        }
        
        if (user.getPassword().trim().length() == 0) {
            error.addError("user.pass.error");
        }
    }
}

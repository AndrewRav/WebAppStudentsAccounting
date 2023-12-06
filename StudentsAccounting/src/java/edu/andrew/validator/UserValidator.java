package edu.andrew.validator;

import edu.andrew.errors.UserValidationError;

public class UserValidator {
    public static void validate(String login, String password, UserValidationError error) {
        // Проверка, что пароль содержит хотя бы одну заглавную букву
        if (!password.chars().anyMatch(Character::isUpperCase)) {
            error.addError("user.pass.uppercase.error");
        }

        // Проверка, что пароль содержит хотя бы одну цифру
        if (!password.chars().anyMatch(Character::isDigit)) {
            error.addError("user.pass.digit.error");
        }
    }
}

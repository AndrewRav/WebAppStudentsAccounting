package edu.andrew.errors;

public class UserNotExistException extends Exception {

    public UserNotExistException(String message) {
        super(message);
    }    
}

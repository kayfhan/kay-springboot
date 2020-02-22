package me.kay.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("用户走丢了");
    }
}

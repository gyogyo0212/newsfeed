package com.example.newsfeed.exception.login;

public class LoginFailException extends  RuntimeException {
    public LoginFailException(String message) {
        super(message);
    }
}


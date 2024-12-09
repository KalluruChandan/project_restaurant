package com.project.resto.app.exception;

public class PasswordMissMatchException extends RuntimeException {
    public PasswordMissMatchException(String msg) {
        super(msg);
    }
}

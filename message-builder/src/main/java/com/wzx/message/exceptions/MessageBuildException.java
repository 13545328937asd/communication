package com.wzx.message.exceptions;

public class MessageBuildException extends RuntimeException {
    public MessageBuildException(String message) {
        super(message);
    }

    public MessageBuildException(String message, Throwable cause) {
        super(message, cause);
    }
}

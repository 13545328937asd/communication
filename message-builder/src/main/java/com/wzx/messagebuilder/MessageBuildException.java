package com.wzx.messagebuilder;

public class MessageBuildException extends RuntimeException {
    public MessageBuildException(String message) {
        super(message);
    }

    public MessageBuildException(String message, Throwable cause) {
        super(message, cause);
    }
}

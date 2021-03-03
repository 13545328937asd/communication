package com.wzx.message.exceptions;

public class MessageResolveException  extends MessageBuildException {
    public MessageResolveException(String message) {
        super(message);
    }

    public MessageResolveException(String message, Throwable cause) {
        super(message, cause);
    }
}

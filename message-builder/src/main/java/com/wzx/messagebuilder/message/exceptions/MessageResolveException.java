package com.wzx.messagebuilder.message.exceptions;

import com.wzx.messagebuilder.MessageBuildException;

public class MessageResolveException  extends MessageBuildException {
    public MessageResolveException(String message) {
        super(message);
    }

    public MessageResolveException(String message, Throwable cause) {
        super(message, cause);
    }
}

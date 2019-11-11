package com.wzx.message.exceptions;

import com.wzx.common.exceptions.CommunicationException;

public class CanNotDisposeException extends CommunicationException {
    public CanNotDisposeException(String message) {
        super(message);
    }

    public CanNotDisposeException(String message, Throwable cause) {
        super(message, cause);
    }
}

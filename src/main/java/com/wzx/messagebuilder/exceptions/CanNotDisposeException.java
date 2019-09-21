package com.wzx.messagebuilder.exceptions;

public class CanNotDisposeException extends  CommunicationException{
    public CanNotDisposeException(String message) {
        super(message);
    }

    public CanNotDisposeException(String message, Throwable cause) {
        super(message, cause);
    }
}

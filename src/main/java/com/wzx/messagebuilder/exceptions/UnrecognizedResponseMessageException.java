package com.wzx.messagebuilder.exceptions;

public class UnrecognizedResponseMessageException extends RemoteCommunicationException{
    public UnrecognizedResponseMessageException(String message) {
        super(message);
    }

    public UnrecognizedResponseMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}

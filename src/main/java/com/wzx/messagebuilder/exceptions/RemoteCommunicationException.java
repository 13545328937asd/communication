package com.wzx.messagebuilder.exceptions;

public class RemoteCommunicationException extends CommunicationException {
    public RemoteCommunicationException(String message) {
        super(message);
    }

    public RemoteCommunicationException(String message, Throwable cause) {
        super(message, cause);
    }
}

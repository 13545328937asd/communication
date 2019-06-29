package com.wzx.exceptions;

public class RemoteObjectNotFoundException extends CommunicationException{
    public RemoteObjectNotFoundException(String message) {
        super(message);
    }

    public RemoteObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

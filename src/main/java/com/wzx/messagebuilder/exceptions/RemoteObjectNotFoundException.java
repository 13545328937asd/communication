package com.wzx.messagebuilder.exceptions;

public class RemoteObjectNotFoundException extends RemoteCommunicationException{
    public RemoteObjectNotFoundException(String message) {
        super(message);
    }
    public RemoteObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.wzx.exceptions;

public class CommunicationTimeOutException extends CommunicationException {
    public CommunicationTimeOutException(String message) {
        super(message);
    }

    public CommunicationTimeOutException(String message, Throwable cause) {
        super(message, cause);
    }
}

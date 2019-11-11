package com.wzx.message.exceptions;

import com.wzx.common.exceptions.CommunicationException;

public class CommunicationTimeOutException extends CommunicationException {
    public CommunicationTimeOutException(String message) {
        super(message);
    }

    public CommunicationTimeOutException(String message, Throwable cause) {
        super(message, cause);
    }
}

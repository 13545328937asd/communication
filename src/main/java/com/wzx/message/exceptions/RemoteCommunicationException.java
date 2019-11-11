package com.wzx.message.exceptions;

import com.wzx.common.exceptions.CommunicationException;

public class RemoteCommunicationException extends CommunicationException {
    public RemoteCommunicationException(String message) {
        super(message);
    }

    public RemoteCommunicationException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.wzx.message.exceptions;

import com.wzx.common.exceptions.CommunicationException;

public class NotUnderstandingException extends CommunicationException {
    public NotUnderstandingException(String message) {
        super(message);
    }
    public NotUnderstandingException(String message,Throwable cause) {
        super(message,cause);
    }
}

package com.wzx.message.exceptions;

import com.wzx.common.exceptions.CommunicationException;

public class AnswerTimeOutException extends CommunicationException {
    public AnswerTimeOutException(String message) {
        super(message);
    }
}

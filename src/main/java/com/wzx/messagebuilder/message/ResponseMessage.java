package com.wzx.messagebuilder.message;

public class ResponseMessage {
    private String messageId;
    private Object response;

    public ResponseMessage(String messageId, Object response) {
        this.messageId = messageId;
        this.response = response;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}

package com.wzx.messagebuilder.message;

import com.wzx.messagebuilder.message.builder.CommunicationMessageBuilder;

public class ResponseMessage extends CommunicationMessage{
    private String requestMessageId;
    public ResponseMessage(CommunicationMessageBuilder messageBuilder) {
        super(messageBuilder);
        this.requestMessageId=messageBuilder.getResponseMessageId();
    }

    public String getRequestMessageId() {
        return requestMessageId;
    }

    public void setRequestMessageId(String requestMessageId) {
        this.requestMessageId = requestMessageId;
    }
}

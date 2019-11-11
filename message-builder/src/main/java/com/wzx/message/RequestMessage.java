package com.wzx.message;

import com.wzx.message.builder.CommunicationMessageBuilder;

public class RequestMessage extends CommunicationMessage{
    public RequestMessage(String fromAppName, String toAppName, MessageType messageType, String sourceObjName, String toObjName, MessageContent messageContent) {
        super(fromAppName, toAppName, messageType, sourceObjName, toObjName, messageContent);
    }
    public RequestMessage(CommunicationMessageBuilder builder){
        super(builder);
    }
}

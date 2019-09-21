package com.wzx.messagebuilder.message.builder;

import com.wzx.messagebuilder.message.*;

public class CommunicationMessageBuilder {
    private String fromAppName;
    private String toAppName;
    private String messageId;
    private MessageType messageType;
    private String fromObjName;
    private String toObjName;
    private String responseMessageId;
    private MessageContent messageContent;

    public CommunicationMessageBuilder toAppName(String toAppName){
        this.toAppName=toAppName;
        return this;
    }
    public CommunicationMessageBuilder fromAppName(String fromAppName){
        this.fromAppName=fromAppName;
        return this;
    }
    public CommunicationMessageBuilder responseMessageId(String responseMessageId){
        this.responseMessageId=responseMessageId;
        return this;
    }
    public CommunicationMessageBuilder toObjName(String toObjName){
        this.toObjName=toObjName;
        return this;
    }
    public CommunicationMessageBuilder fromObjName(String fromObjName){
        this.fromObjName=fromObjName;
        return this;
    }
    public CommunicationMessageBuilder messageType(MessageType messageType){
        this.messageType=messageType;
        return this;
    }
    public CommunicationMessageBuilder messageContent(MessageContent messageContent){
        this.messageContent=messageContent;
        return this;
    }
    public CommunicationMessage build(){
        switch (messageType){
            case REQUEST:
                return new RequestMessage(this);
            case RESPONSE:
                return new ResponseMessage(this);
            default:
                throw new IllegalArgumentException(messageType+" 消息类型无法解析");
        }
    }

    public String getFromAppName() {
        return fromAppName;
    }

    public String getToAppName() {
        return toAppName;
    }

    public String getMessageId() {
        return messageId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getFromObjName() {
        return fromObjName;
    }

    public String getToObjName() {
        return toObjName;
    }

    public MessageContent getMessageContent() {
        return messageContent;
    }

    public String getResponseMessageId() {
        return responseMessageId;
    }
}

package com.wzx.message;

import com.wzx.message.builder.CommunicationMessageBuilder;
import com.wzx.common.tools.FastJsonUtil;
import com.wzx.message.messageanswer.Answer;
import org.springframework.messaging.support.GenericMessage;

public  class CommunicationMessage extends GenericMessage<MessageContent> {
    private Answer messageAnswer;
    private String fromAppName;
    private String toAppName;
    private String messageId;
    private MessageType messageType;
    private String fromObjName;
    private String toObjName;
    private MessageContent messageContent;
    public CommunicationMessage(String fromAppName, String toAppName, MessageType messageType, String sourceObjName, String toObjName, MessageContent messageContent) {
        this.fromAppName = fromAppName;
        this.toAppName = toAppName;
        this.messageId = messageId;
        this.messageType = messageType;
        this.fromObjName = sourceObjName;
        this.toObjName = toObjName;
        this.messageContent = messageContent;
    }

    public CommunicationMessage(CommunicationMessageBuilder messageBuilder) {
        this.fromAppName = messageBuilder.getFromAppName();
        this.toAppName = messageBuilder.getToAppName();
        this.messageId = messageBuilder.getMessageId();
        this.messageType = messageBuilder.getMessageType();
        this.fromObjName = messageBuilder.getFromObjName();
        this.toObjName = messageBuilder.getToObjName();
        this.messageContent = messageBuilder.getMessageContent();
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getFromAppName() {
        return fromAppName;
    }

    public void setFromAppName(String fromAppName) {
        this.fromAppName = fromAppName;
    }

    public String getToAppName() {
        return toAppName;
    }

    public void setToAppName(String toAppName) {
        this.toAppName = toAppName;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getFromObjName() {
        return fromObjName;
    }

    public void setFromObjName(String fromObjName) {
        this.fromObjName = fromObjName;
    }

    public String getToObjName() {
        return toObjName;
    }

    public void setToObjName(String toObjName) {
        this.toObjName = toObjName;
    }

    public MessageContent getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(MessageContent messageContent) {
        this.messageContent = messageContent;
    }
    @Override
    public String toString(){
        return FastJsonUtil.toJson(this);
    }

    public Answer getMessageAnswer() {
        return messageAnswer;
    }

    public void setMessageAnswer(Answer messageAnswer) {
        this.messageAnswer = messageAnswer;
    }
}

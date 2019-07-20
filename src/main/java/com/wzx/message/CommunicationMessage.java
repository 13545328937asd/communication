package com.wzx.message;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.UUID;

public class CommunicationMessage {
    private String messageId;
    private  FutureAnswer futureAnswer;
    private MessageType messageType;
    private boolean internalCommu=true;
    private boolean sync=true;
    private String fromObjName;
    @JSONField(serialize = false,deserialize = false)
    private Object fromObj ;
    @JSONField(serialize = false,deserialize = false)
    private Object toObj;
    private Class toClazz;
    private String toObjName;
    private MessageDetail messageDetail;
    public FutureAnswer getFutureAnswer() {
        return futureAnswer;
    }
    public void setFutureAnswer(FutureAnswer futureAnswer) {
        this.futureAnswer = futureAnswer;
    }
    public CommunicationMessage(){
        messageId= UUID.randomUUID().toString().replace("-","");
        futureAnswer=new FutureAnswer();
    }
    public MessageType getMessageType() {
        return messageType;
    }
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Object getFromObj() {
        return fromObj;
    }

    public void setFromObj(Object fromObj) {
        this.fromObj = fromObj;
    }

    public Object getToObj() {
        return toObj;
    }

    public void setToObj(Object toObj) {
        this.toObj = toObj;
    }

    public Class getToClazz() {
        return toClazz;
    }

    public void setToClazz(Class toClazz) {
        this.toClazz = toClazz;
    }

    public MessageDetail getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(MessageDetail messageDetail) {
        this.messageDetail = messageDetail;
    }

    public String getToObjName() {
        return toObjName;
    }

    public void setToObjName(String toObjName) {
        this.toObjName = toObjName;
    }

    public boolean isInternalCommu() {
        return internalCommu;//default is true
    }

    public void setInternalCommu(boolean internalCommu) {
        this.internalCommu = internalCommu;
    }
    public boolean isSync() {
        return sync;
    }
    public void setSync(boolean sync) {
        this.sync = sync;
    }
    public String getMessageId() {
        return messageId;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    public String getFromObjName() {
        return fromObjName;
    }
    public void setFromObjName(String fromObjName) {
        this.fromObjName = fromObjName;
    }
}

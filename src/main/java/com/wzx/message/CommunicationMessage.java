package com.wzx.message;

public class CommunicationMessage {
    private  FutureAnswer futureAnswer;
    private MessageType messageType;
    private boolean internalCommu=true;
    private boolean sync=true;
    private Object fromObj ;
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

}

package com.wzx.messagebuilder.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.wzx.messagebuilder.Config.CommunicationConf;
import com.wzx.messagebuilder.ObjNameManager;

import java.util.UUID;

public class CommunicationMessage {
    private String fromAppName;
    private String toAppName;
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
        fromObjName=CommunicationConf.get("application-name");
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

    public String getFullToObjName(){
        return ObjNameManager.getObjFullName(toAppName,toObjName);
    }
    public String getFullFromObjName(){
        return ObjNameManager.getCurrentAppObjFullName(fromObjName);
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
        return CommunicationConf.get("application-name").equals(toAppName);//default is true
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

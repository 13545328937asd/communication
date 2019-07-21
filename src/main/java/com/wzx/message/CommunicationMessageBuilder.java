package com.wzx.message;

public class CommunicationMessageBuilder {
    private CommunicationMessage cm=new CommunicationMessage();
    public CommunicationMessageBuilder buildObjInfo(Object from,Object to){
        cm.setFromObj(from);
        cm.setFromObjName(from.getClass().getName());
        if(to instanceof Class){
            cm.setToClazz((Class)to);
            cm.setToObjName(((Class) to).getName());
        }else if(to instanceof String){
            cm.setToObjName(toString());
        }else{
            cm.setToObj(to);
        }
        return this;
    };
    public CommunicationMessageBuilder buildToAppName(String toAppName){
        cm.setToAppName(toAppName);
        return this;
    }
    public CommunicationMessageBuilder buildFromAppName(String fromAppName){
        cm.setFromAppName(fromAppName);
        return this;
    }
    public CommunicationMessageBuilder buildToObjName(String toObjName){
        cm.setToObjName(toObjName);
        return this;
    }
    public CommunicationMessageBuilder buildFromObjName(String fromObjName){
        cm.setFromObjName(fromObjName);
        return this;
    }
    public CommunicationMessageBuilder buildMessageType(MessageType type){
        cm.setMessageType(type);
        return this;
    }
    public CommunicationMessageBuilder buildMessageDetail(MessageDetail detail){
        cm.setMessageDetail(detail);
        return this;
    }
    public CommunicationMessageBuilder buildMessageDetail(String hint,Object[] args){
        cm.setMessageDetail(new MessageDetail(hint,args));
        return this;
    }
    public CommunicationMessageBuilder buildInternalCommu(boolean internalCommu){
        cm.setInternalCommu(internalCommu);
        return this;
    }
    public CommunicationMessageBuilder buildSyncCommu(boolean sync){
        cm.setSync(sync);
        return this;
    }
    public CommunicationMessage getCm(){
        if(cm.getFromObj()==null||cm.getToClazz()==null){
            throw new RuntimeException("communication objects must be initialized");
        }
        return cm;
    }
    public static CommunicationMessageBuilder getInstance(){
        return new CommunicationMessageBuilder();
    }

}

package com.wzx.common.object;


import com.wzx.common.object.action.ObjectAction;

import java.util.List;

public class ObjectInfo {
    private String  fullName;
    private Class   clazz;
    private String  nickName;
    private List<ObjectAction> objectActions;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<ObjectAction> getObjectActions() {
        return objectActions;
    }

    public void setObjectActions(List<ObjectAction> objectActions) {
        this.objectActions = objectActions;
    }
}

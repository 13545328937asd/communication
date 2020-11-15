package com.wzx.objectinfo.ability;

import com.wzx.message.CommunicationMessage;
import com.wzx.objectinfo.ObjectInfo;
import com.wzx.objectinfo.action.Action;
import com.wzx.objectinfo.manager.ObjectInfoManager;

import java.util.ArrayList;
import java.util.List;

public interface Comprehend<T> {
    default List<Action> comprehend(T message){
        ObjectInfoManager instance = ObjectInfoManager.getInstance();
        ObjectInfo objectInfo = instance.getObjectInfo(this.getClass());
        return new ArrayList<>();
    }
}

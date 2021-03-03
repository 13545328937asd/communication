package com.wzx.common.object.manager;

import com.wzx.common.container.IntelligentObjectContainer;
import com.wzx.common.object.ObjectInfo;
import com.wzx.common.object.parser.ObjectInfoParser;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ObjectInfoManager {
    private static ObjectInfoManager objectInfoManager;
    private Map<Class, ObjectInfo> classObjectInfoMap=new ConcurrentHashMap<>();
    private Map<String,Class> nameTypeMap=new ConcurrentHashMap<>();
    public  ObjectInfo getObjectInfo(Class clazz){
        ObjectInfo objectInfo = classObjectInfoMap.get(clazz);
        if(objectInfo==null){
            objectInfo = ObjectInfoParser.getInstance().parseObject(clazz);
        }
        return objectInfo;
    }

    public synchronized static ObjectInfoManager getInstance(){
        if(objectInfoManager==null){
            //get from the container first,if null,then create the default
            ObjectInfoManager infoManager= IntelligentObjectContainer.getInstance().getObject(ObjectInfoManager.class);
            if(infoManager==null){
                objectInfoManager= new DefaultObjectInfoManager();
            }else{
                objectInfoManager=infoManager;
            }
        }
        return objectInfoManager;
    }

}

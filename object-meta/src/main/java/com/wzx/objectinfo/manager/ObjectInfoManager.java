package com.wzx.objectinfo.manager;

import com.wzx.objectinfo.ObjectInfo;
import com.wzx.objectinfo.parser.BaseObjectParser;
import com.wzx.objectinfo.parser.IntelligentObjectParser;
import com.wzx.objectinfo.parser.ObjectParser;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ObjectInfoManager {
    private volatile static ObjectInfoManager objectInfoManager;
    private Map<Class, ObjectInfo> classObjectInfoMap=new ConcurrentHashMap<>();
    private Map<String,Class> nameTypeMap=new ConcurrentHashMap<>();
    public  ObjectInfo getObjectInfo(Class clazz){
        ObjectInfo objectInfo = classObjectInfoMap.get(clazz);
        if(objectInfo==null){

            objectInfo = IntelligentObjectParser.getInstance().parseObject(clazz);
        }
        return objectInfo;
    }

    public  static ObjectInfoManager getInstance(){
        if(objectInfoManager==null){
            synchronized (ObjectInfoManager.class){
                //get from the container first,if null,then create the default
                if(objectInfoManager!=null){
                    objectInfoManager=new DefaultObjectInfoManager();
                }
            }
        }
        return objectInfoManager;
    }

}

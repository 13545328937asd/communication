package com.wzx.objectinfo;

import com.wzx.objectinfo.ability.*;
import com.wzx.objectinfo.manager.ObjectInfoManager;

import java.util.List;

public class ObjectHelper {
    public static ObjectInfoManager objectInfoManager=ObjectInfoManager.getInstance();
    public static Analyse getObjectAnalyzer(String name,Class clazz){
        ObjectInfo objectInfo = objectInfoManager.getObjectInfo(clazz);
        return objectInfo.getAnalyzer(name);
    };
    public static List<Comprehend> getComprehenders(Class clazz){
        ObjectInfo objectInfo = objectInfoManager.getObjectInfo(clazz);
        return objectInfo.getComprehenders();
    }
    public static ReadeAndWrite getReaderAndWriter(Class clazz){
        ObjectInfo objectInfo = objectInfoManager.getObjectInfo(clazz);
        return objectInfo.getReadeAndWrite();
    }
    public static Coordinate getCoordinator(Class clazz){
        ObjectInfo objectInfo = objectInfoManager.getObjectInfo(clazz);
        return objectInfo.getCoordinator();
    }
    public static Memory getMemorizer(Class clazz){
        ObjectInfo objectInfo = objectInfoManager.getObjectInfo(clazz);
        return objectInfo.getMemorizer();
    }
    public static Social getSocialer(Class clazz){
        ObjectInfo objectInfo = objectInfoManager.getObjectInfo(clazz);
        return objectInfo.getSocialer();
    }
}

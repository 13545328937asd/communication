package com.wzx.common.tools;

import com.wzx.common.object.ObjectInfo;

public class ObjectInfoChecker {
    public static boolean isNameOfClass(String name,Class clazz){
        boolean matched=false;
        ObjectInfo objectInfo = SingletonObjUtil.getObjectInfoManager().getObjectInfo(clazz);
        if(StringTools.equalsIgnoreCase(name,objectInfo.getFullName())){
            matched=true;
        }
        if(StringTools.equalsIgnoreCase(name,objectInfo.getNickName())){
            matched=true;
        }
        return matched;
    }
}

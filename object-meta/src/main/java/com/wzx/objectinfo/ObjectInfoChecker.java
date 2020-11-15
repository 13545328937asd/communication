package com.wzx.objectinfo;

import com.wzx.common.tools.StringTools;
import com.wzx.objectinfo.manager.ObjectInfoManager;

public class ObjectInfoChecker {
    public static boolean isNameOfClass(String name,Class clazz){
        boolean matched=false;
        ObjectInfo objectInfo = ObjectInfoManager.getInstance().getObjectInfo(clazz);
        if(StringTools.equalsIgnoreCase(name,objectInfo.getFullName())){
            matched=true;
        }
        if(StringTools.equalsIgnoreCase(name,objectInfo.getNickName())){
            matched=true;
        }
        return matched;
    }
}

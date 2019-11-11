package com.wzx.common.tools;

import com.wzx.common.object.manager.ObjectInfoManager;

public class SingletonObjUtil {
    public static ObjectInfoManager getObjectInfoManager(){
       return  ObjectInfoManager.getInstance();
    }
}

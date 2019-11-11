package com.wzx;

import com.wzx.Config.CommunicationConf;

public class ObjNameManager {
    public static String getObjFullName(String applicationName,String beanName){
        return applicationName+":"+beanName;
    }
    public static String getCurrentAppObjFullName(String beanName){
        return CommunicationConf.get("application-name") +":"+beanName;
    }
}

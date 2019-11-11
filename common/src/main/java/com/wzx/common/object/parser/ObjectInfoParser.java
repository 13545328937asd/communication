package com.wzx.common.object.parser;

import com.wzx.common.object.ObjectInfo;

public  class ObjectInfoParser {
    private static ObjectInfoParser objectInfoParser=new ObjectInfoParser();
    public ObjectInfo parseObject(Class clazz){
        return null;
    }
    public static ObjectInfoParser getInstance(){
        return objectInfoParser;
    }
}

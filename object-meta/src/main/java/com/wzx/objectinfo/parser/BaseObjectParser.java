package com.wzx.objectinfo.parser;


import com.wzx.objectinfo.ObjectInfo;

public  class BaseObjectParser implements ObjectParser{
    private static BaseObjectParser objectInfoParser=new BaseObjectParser();
    public ObjectInfo parseObject(Class clazz){
        return null;
    }
    public static BaseObjectParser getInstance(){
        return objectInfoParser;
    }
}

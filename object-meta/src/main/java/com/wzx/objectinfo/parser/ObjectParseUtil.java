package com.wzx.objectinfo.parser;

import com.wzx.objectinfo.action.NativeMethodAction;
import com.wzx.objectinfo.action.ObjectAction;
import com.wzx.objectinfo.annotation.ObjInfo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ObjectParseUtil {
    public static String parseObjectName(Class<?> clazz){
        String objName="";
        ObjInfo objInfo =  clazz.getDeclaredAnnotation(ObjInfo.class);
        if(objInfo !=null){
            objName= objInfo.name();
        }else{
            objName=clazz.getSimpleName();
        }
        return objName;
    }
    public static List<ObjectAction> parseObejctActions(Class<?> clazz){
        List<ObjectAction> objectActions=new ArrayList<>();
        Method[] methods = clazz.getMethods();
        for(int i=0;i<methods.length;i++){
            Method method=methods[i];
            //只添加默认
            // 方法和公共方法
            if(method.isDefault()|| Modifier.isPublic(method.getModifiers())){
                objectActions.add(new NativeMethodAction(method,clazz));
            }
        }
        ObjInfo objInfo = clazz.getAnnotation(ObjInfo.class);
        if(objInfo!=null){

        }
    }
}

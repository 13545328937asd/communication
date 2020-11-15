package com.wzx.message.resolvers;
import com.wzx.objectinfo.annotation.*;
import com.wzx.message.builder.CommunicationMessageBuilder;
import com.wzx.message.builder.MessageContentBuilder;
import com.wzx.common.tools.StringTools;
import com.wzx.message.exceptions.MessageResolveException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class DefaultMessageResolver implements MessageResolver {

    @Override
    public void resolveObjInfo(Class<?> clazz, CommunicationMessageBuilder messageBuilder) {
        AppInfo applicationInfo = clazz.getAnnotation(AppInfo.class);
        ObjInfo objInfo = clazz.getAnnotation(ObjInfo.class);
        if(applicationInfo==null){//if not found ,find in the ObjInfo Annotation
            applicationInfo = objInfo.application();
        }
        String applicationName=getApplicationName(applicationInfo);
        if(StringTools.isEmpty(getApplicationName(applicationInfo))){
            throw new MessageResolveException("can not find the application info");
        }
        messageBuilder.toAppName(applicationName);
        messageBuilder.toObjName(getObjName(objInfo));
    }

    private String getObjName(ObjInfo objInfo) {
        String objName= objInfo.value();
        if(StringTools.isEmpty(objName)){
            objName= objInfo.name();
        }
        return objName;
    }

    private String getApplicationName(AppInfo applicationInfo) {
        String applicationName = applicationInfo.value();
        if(StringTools.isEmpty(applicationName)){
            applicationName=applicationInfo.appName();

        }
        return applicationName;
    }

    @Override
    public void resolveParamInfo(Method method, Object[] args, MessageContentBuilder contentBuilder) {
        ObjAction objectAction = method.getAnnotation(ObjAction.class);
        contentBuilder.words(method.getName());
        String action = getObjectAction(objectAction);
        if(StringTools.isNotEmpty(action)){
            contentBuilder.words(action);
        }
        contentBuilder.wordsDesc(objectAction.actionDesc());
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Parameter[] parameters = method.getParameters();
        if(parameters!=null&&parameters.length>0){
            for(int i=0;i<parameters.length;i++){
                String paramName=parameters[i].getName();
                String paramDesc=null;
                ActParam messageParam = parameters[i].getAnnotation(ActParam.class);
                if(messageParam!=null){
                    paramDesc=messageParam.paramDesc();
                    String annotatedName= StringTools.isEmpty(messageParam.value())?messageParam.name():messageParam.value();
                    if(StringTools.isNotEmpty(annotatedName)){
                        paramName=annotatedName;
                    }
                }
                contentBuilder.buildParam(paramName,args[i],paramDesc);
            }
        }

    }


    private String getObjectAction(ObjAction objectAction) {
        String action = objectAction.value();
        if(StringTools.isEmpty(action)){
            action=objectAction.action();
        }
        return action;

    }

}

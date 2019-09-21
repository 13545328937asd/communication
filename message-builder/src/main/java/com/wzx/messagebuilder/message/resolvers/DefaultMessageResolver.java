package com.wzx.messagebuilder.message.resolvers;

import com.wzx.messagebuilder.annotation.ApplicationInfo;
import com.wzx.messagebuilder.annotation.MessageParam;
import com.wzx.messagebuilder.annotation.ObjectAction;
import com.wzx.messagebuilder.annotation.ObjectInfo;
import com.wzx.messagebuilder.message.builder.CommunicationMessageBuilder;
import com.wzx.messagebuilder.message.builder.MessageContentBuilder;
import com.wzx.messagebuilder.message.exceptions.MessageResolveException;
import com.wzx.messagebuilder.tools.StringTools;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class DefaultMessageResolver implements MessageResolver {

    @Override
    public void resolveObjInfo(Class<?> clazz, CommunicationMessageBuilder messageBuilder) {
        ApplicationInfo applicationInfo = clazz.getAnnotation(ApplicationInfo.class);
        ObjectInfo objectInfo = clazz.getAnnotation(ObjectInfo.class);
        if(applicationInfo==null){//if not found ,find in the ObjectInfo Annotation
            applicationInfo = objectInfo.application();
        }
        String applicationName=getApplicationName(applicationInfo);
        if(StringTools.isEmpty(getApplicationName(applicationInfo))){
            throw new MessageResolveException("can not find the application info");
        }
        messageBuilder.toAppName(applicationName);
        messageBuilder.toObjName(getObjName(objectInfo));
    }

    private String getObjName(ObjectInfo objectInfo) {
        String objName=objectInfo.value();
        if(StringTools.isEmpty(objName)){
            objName= objectInfo.name();
        }
        return objName;
    }

    private String getApplicationName(ApplicationInfo applicationInfo) {
        String applicationName = applicationInfo.value();
        if(StringTools.isEmpty(applicationName)){
            applicationName=applicationInfo.appName();

        }
        return applicationName;
    }

    @Override
    public void resolveParamInfo(Method method, Object[] args, MessageContentBuilder contentBuilder) {
        ObjectAction objectAction = method.getAnnotation(ObjectAction.class);
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
                MessageParam messageParam = parameters[i].getAnnotation(MessageParam.class);
                if(messageParam!=null){
                    paramDesc=messageParam.paramDesc();
                    String annotatedName=StringTools.isEmpty(messageParam.value())?messageParam.name():messageParam.value();
                    if(StringTools.isNotEmpty(annotatedName)){
                        paramName=annotatedName;
                    }
                }
                contentBuilder.buildParam(paramName,args[i],paramDesc);
            }
        }

    }


    private String getObjectAction(ObjectAction objectAction) {
        String action = objectAction.value();
        if(StringTools.isEmpty(action)){
            action=objectAction.action();
        }
        return action;

    }

}

package com.wzx.messagebuilder.words;

import com.wzx.messagebuilder.Voluble;
import com.wzx.messagebuilder.exceptions.CanNotDisposeException;
import com.wzx.messagebuilder.exceptions.CommunicationException;
import com.wzx.messagebuilder.exceptions.NotUnderstandingException;
import com.wzx.messagebuilder.message.MessageDetail;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DefaultWordsParser implements WordsParser {
    @Override
    public Object parseWords(Voluble voluble, MessageDetail detail) throws CommunicationException {
        String words=detail.getWords();
        Object[] args=detail.getExtraInfo();
        Method   method =getTargetMethod(voluble.getClass(),words,args);
        method.setAccessible(true);
        try {
           return  method.invoke(voluble,args);
        } catch (Exception e) {
           throw new CanNotDisposeException("the object can not dispose the message",e);
        }
    }

    private Method getTargetMethod(Class clazz, String name, Object[] args) {
        /*try {
            return clazz.getDeclaredMethod(name,getClassesOfObjects(args));
        } catch (NoSuchMethodException e) {
            throw  new NotUnderstandingException("the message detail may be wrong ,because clazz："+clazz.toString()+" do not understand",e);
        }*/
        Method[] methods=clazz.getDeclaredMethods();
        List<Method> targetMethods= filterMehtodsByArgs(filterMehtodsByName(methods, name), args);
        if(targetMethods.size()==0){
            throw  new NotUnderstandingException("the message detail may be wrong ,because clazz："+clazz.toString()+" do not understand");
        }
        return targetMethods.get(0);
    }

    private Class[] getClassesOfObjects(Object... args) {
        List<Class> classes=new ArrayList<>();
        if(args==null||args.length==0){
            return null;
        }
        for(Object obj:args){
            if(obj==null){
                classes.add(null);
            }else{
                classes.add(obj.getClass());
            }
        }
        return classes.toArray(new Class[0]);
    }

    private List<Method> filterMehtodsByArgs(List<Method> methods,Object[] args) {
        List<Method> filteredMethods=new ArrayList<>();
        if(methods==null||methods.size()==0){
            return filteredMethods;
        }
        for(Method method:methods){
            Class[] classes=method.getParameterTypes();
            if(smartMatch(classes,args)){
                filteredMethods.add(method);
            }
        }
        return filteredMethods;

    }

    private boolean smartMatch(Class[] classes, Object[] args) {
        boolean matched=false;
        if(classes==null&&(null==args||args.length==0)){
            return  true;
        }
        if(classes.length==args.length&&typeMatched(classes,args)){
            matched=true;
        }
       return  matched;
    }

    private boolean typeMatched(Class[] classes, Object[] args) {
        boolean typeMatched=true;
        for(int i=0;i<classes.length;i++){
            if(args[i]==null){
                continue;
            }
            if(!args[i].getClass().isAssignableFrom(classes[i])){
                typeMatched=false;
            }
        }
        return typeMatched;
    }

    private List<Method> filterMehtodsByName(Method[] methods, String name) {
        List<Method> filteredMethods=new ArrayList<>();
        if(methods==null||methods.length==0){
            return filteredMethods;
        }
        for(Method method:methods){
            if(method.getName().equals(name)){
                filteredMethods.add(method);
            }
        }
        return filteredMethods;
    }
}

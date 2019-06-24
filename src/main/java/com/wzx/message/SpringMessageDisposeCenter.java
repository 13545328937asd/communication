package com.wzx.message;

import com.wzx.Voluble;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SpringMessageDisposeCenter implements BeanFactoryAware,MessageDisposeCenter {
    private static BeanFactory beanFactory;
    public void messageDispose(CommunicationMessage message){
        if(message.isInternalCommu()){
            disposeMessageInternally(message);
        };
        if(!message.isInternalCommu()){//remote communication

        }
    }

    private void disposeMessageInternally(CommunicationMessage message) {
        Object obj=findInternalObjectByName(message.getToObjName());
        if(obj==null){
            obj=findInternalObjectByClazz(message.getToClazz());
        }
        if(obj==null){
            throw  new RuntimeException("internal communication failed,can not find the toObj");
        }
        if(!(obj instanceof Voluble)){
            throw  new RuntimeException("the object you communicate is not voluble");
        }
        message.setToObj(obj);
        ((Voluble) obj).listen(message);
    }

    private Object findInternalObjectByClazz(Class toClazz) {
        if(toClazz==null){
            return null;
        }
        return beanFactory.getBean(toClazz);
    }

    private Object findInternalObjectByName(String name) {
        if(StringUtils.isEmpty(name)){
            return null;
        }
        Object targetObj=beanFactory.getBean(name);
        return targetObj;
    }

    ;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }
    /**\
     * check whether the message is communicated on the internal net
     * @param message
     * @return
     */
    private boolean isInnerNetCommu(CommunicationMessage message) throws ClassNotFoundException {
        boolean innerNetCommu=true;
        String toObjName=message.getToObjName();
        if(!StringUtils.isEmpty(toObjName)){
            Class clazz=Class.forName(toObjName);
            message.setToClazz(clazz);
        }
        return innerNetCommu;
    }
}

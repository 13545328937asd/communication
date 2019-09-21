package com.wzx.messagebuilder.message;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanAccessor implements BeanFactoryAware {
    public static BeanFactory beanFactory;
    public static  <T> T getBean(Class<T> clazz){
       return beanFactory.getBean(clazz);
    }
    public static  <T> T getBean(String name ,Class<T> clazz){
        return beanFactory.getBean(name ,clazz);
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }
}

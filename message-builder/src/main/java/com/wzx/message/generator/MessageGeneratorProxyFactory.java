package com.wzx.message.generator;

import java.lang.reflect.Proxy;

public class MessageGeneratorProxyFactory<T> {
    private Class<T> messageGenerator;
    public MessageGeneratorProxyFactory(Class<T> clazz) {
        this.messageGenerator=clazz;
    }

    public  T  getProxy(MessageGeneratorProxy generatorProxy){
        return (T) Proxy.newProxyInstance(messageGenerator.getClassLoader(),new Class[]{messageGenerator},generatorProxy  );
    };
}

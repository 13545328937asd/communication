package com.wzx.messagebuilder.message.generator;

import com.wzx.messagebuilder.message.CommunicationMessage;
import com.wzx.messagebuilder.message.MessageContent;
import com.wzx.messagebuilder.message.MessageType;
import com.wzx.messagebuilder.message.builder.CommunicationMessageBuilder;
import com.wzx.messagebuilder.message.builder.MessageContentBuilder;
import com.wzx.messagebuilder.message.resolvers.DefaultMessageResolver;
import com.wzx.messagebuilder.message.resolvers.MessageResolver;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MessageGeneratorProxy implements InvocationHandler {
    private Class<?> clazz;

    public MessageGeneratorProxy(Class<?> clazz) {
        this.clazz = clazz;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else if (isDefaultMethod(method)) {
            return invokeDefaultMethod(proxy, method, args);
        }
        MessageResolver messageResolver = getMessageResolver();
        Class<?> returnType = method.getReturnType();
        checkRetrunType(returnType);
        if(returnType.isAssignableFrom(MessageContent.class)){
            MessageContentBuilder contentBuilder=new MessageContentBuilder();
            messageResolver.resolveParamInfo(method,args,contentBuilder);
            return contentBuilder.build();
        }
        CommunicationMessageBuilder messageBuilder=new CommunicationMessageBuilder();
        messageResolver.resolveObjInfo(clazz,messageBuilder);
        MessageContentBuilder contentBuilder=new MessageContentBuilder();
        messageResolver.resolveParamInfo(method,args,contentBuilder);
        messageBuilder.messageContent(contentBuilder.build());
        messageBuilder.messageType(MessageType.REQUEST);
        return messageBuilder.build();
    }

    private void checkRetrunType(Class<?> returnType) {
        if(!(returnType.isAssignableFrom(CommunicationMessage.class)||returnType.isAssignableFrom(MessageContent.class))){
            throw new IllegalArgumentException("the method return type must be"+CommunicationMessage.class+"or"+MessageContent.class);
        }
    }

    private MessageResolver getMessageResolver() {
        return new DefaultMessageResolver();
    }

    private Object invokeDefaultMethod(Object proxy, Method method, Object[] args)
            throws Throwable {
        final Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class
                .getDeclaredConstructor(Class.class, int.class);
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        final Class<?> declaringClass = method.getDeclaringClass();
        return constructor
                .newInstance(declaringClass,
                        MethodHandles.Lookup.PRIVATE | MethodHandles.Lookup.PROTECTED
                                | MethodHandles.Lookup.PACKAGE | MethodHandles.Lookup.PUBLIC)
                .unreflectSpecial(method, declaringClass).bindTo(proxy).invokeWithArguments(args);
    }


    private boolean isDefaultMethod(Method method) {
        return (method.getModifiers()
                & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC
                && method.getDeclaringClass().isInterface();
    }
}

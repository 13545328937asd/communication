package com.wzx.messagebuilder.message.resolvers;

import com.wzx.messagebuilder.message.builder.CommunicationMessageBuilder;
import com.wzx.messagebuilder.message.builder.MessageContentBuilder;

import java.lang.reflect.Method;

public interface MessageResolver {
    void resolveObjInfo(Class<?> clazz, CommunicationMessageBuilder messageBuilder);
    void resolveParamInfo(Method method, Object[] args, MessageContentBuilder contentBuilder);
}

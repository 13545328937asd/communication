package com.wzx.common.object.action;

import java.lang.reflect.Method;

public class NativeMethodObjectAction extends ObjectAction {
    private Method method;
    private Class clazz;

    @Override
    public Object execute( ActionContext actionContext) {


        return null;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}

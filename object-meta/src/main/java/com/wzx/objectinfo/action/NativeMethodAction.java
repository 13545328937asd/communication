package com.wzx.objectinfo.action;


import com.wzx.objectinfo.action.context.ActionContext;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 类的每个公共方法，都可以封装成一个action。
 * @param <R>
 */
public class NativeMethodAction<R> extends ObjectAction<R> {
    private Method method;
    private Class clazz;

    public NativeMethodAction(Method method, Class clazz) {
        this.method = method;
        this.clazz = clazz;
    }

    @Override
    protected R doExecute(ActionContext actionContext) {
        return null;
    }

    @Override
    public String getActionName() {
        return null;
    }

    @Override
    public List<ActionParam> getActionParams() {
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

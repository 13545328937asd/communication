package com.wzx.common.container;

/**
 * 此容器负责装 智能对象，实现了 Intelligent
 */
public class SpringContainer extends IntelligentObjectContainer {
    @Override
    public <T> T getObject(Class<T> clazz) {
        return null;
    }

    @Override
    public Object getObjectByName(String name) {
        return null;
    }

    @Override
    public <T> T getObject(String name, Class<T> clazz) {
        return null;
    }
}

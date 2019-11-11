package com.wzx.common.container;

/**
 * 容器接口，
 */
public interface Container {
    /**
     * 根据类型获取对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T  getObject(Class<T> clazz);

    /**
     * 根据名字获取对象
     * @param name
     * @return
     */
    public Object getObjectByName(String name);

    /**
     * 根据名字和类型获取对象
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T  getObject(String name,Class<T> clazz);
}

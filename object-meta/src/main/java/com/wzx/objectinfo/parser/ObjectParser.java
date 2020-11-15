package com.wzx.objectinfo.parser;

import com.wzx.objectinfo.ObjectInfo;

/**
 *
 */
public interface ObjectParser<T> {
    public T parseObject(Class clazz);
}

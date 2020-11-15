package com.wzx.objectintellegence.memory;

import com.wzx.objectinfo.ability.Memory;

import java.util.concurrent.ConcurrentHashMap;

public class LocalMemory implements Memory {
    private static final ConcurrentHashMap<String,Object> OBJECT_MEMORY=new ConcurrentHashMap<>(128);
    @Override
    public int keepInMemory(String key, Object value) {
        OBJECT_MEMORY.put(key,value);
        return 0;
    }

    @Override
    public int removeFromMemory(String key) {
        OBJECT_MEMORY.remove(key);
        return 0;
    }

    @Override
    public Object readFromMemory(String key) {
        return  OBJECT_MEMORY.get(key);
    }

}

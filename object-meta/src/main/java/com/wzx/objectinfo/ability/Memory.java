package com.wzx.objectinfo.ability;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     this interface enable the object the power to remember things.
 *     note that the difference between the read ,write interface is that
 *     the memory can only be accessed by the object itself.
 * </p>
 */
public interface Memory {
    /**
     * 对象默认的记忆存储
     */
     Map<String,Map<String,Object>> memorizer=new HashMap<>();
    default int keepInMemory(String key, Object value){
        return 0;
    }
    default int removeFromMemory(String key){
        return 0;
    }
    default Object readFromMemory(String key){
        return null;
    }
}

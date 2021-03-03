package com.wzx.objectintellegence.memory;

/**
 * <p>
 *     this interface enable the object the power to remember things.
 *     note that the difference between the read ,write interface is that
 *     the memory can only be accessed by the object itself.
 * </p>
 */
public interface Memory {
    default int keepInMemory(String key,String value){
        return 0;
    }
    default int removeFromMemory(String key){
        return 0;
    }
    default Object readFromMemory(String key){
        return null;
    }
    default int updateMemory(String key ,String value){
        return 0;
    }
}

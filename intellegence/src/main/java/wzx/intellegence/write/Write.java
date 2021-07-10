package com.wzx.objectintellegence.write;

/**
 * <p>
 *     this interface help the object to store some information.
 * </p>
 */
public interface Write<K,V> {
    default int write(K key,V value){
        return 0;
    }
}

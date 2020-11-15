package com.wzx.objectinfo.ability;

/**
 * <p>
 *     this interface help the object to store some information.
 * </p>
 */
public interface Write<T> {
    default int write(T entity){
        return 0;
    }
}

package com.wzx.objectintellegence.write;

/**
 * <p>
 *     this interface help the object to store some information.
 * </p>
 */
public interface Write {
    default int write(String key,Object value){
        return 0;
    }
}

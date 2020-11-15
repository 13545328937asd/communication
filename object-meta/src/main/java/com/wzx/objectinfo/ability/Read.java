package com.wzx.objectinfo.ability;

/**
 *  <p>
 *      this interface help object read some information from somewhere,
 *      for example, from the disk,file or redis.
 *  </p>
 */
public interface Read<T> {
    /**
     * read some information by a key
     * @param key
     * @return
     */
    default T read(String key){
        return null;
    }
    default T readByCondition(T param){
        return null;
    }
}

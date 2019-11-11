package com.wzx.objectintellegence.read;

/**
 *  <p>
 *      this interface help object read some information from somewhere,
 *      for example, from the disk,file or redis.
 *  </p>
 */
public interface Read {
    /**
     * read some information by a key
     * @param key
     * @return
     */
    default Object read(String key){
        return null;
    }
}

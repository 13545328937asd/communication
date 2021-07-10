package java.wzx.intellegence.read;

/**
 *  <p>
 *      this interface help object read some information from somewhere,
 *      for example, from the disk,file .
 *  </p>
 */
public interface Read<K,V> {
    /**r
     * read some information by a key
     * @param key
     * @return
     */
    default V read(K key){
        return null;
    }
}

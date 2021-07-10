package java.wzx.intellegence.memory;

/**
 * <p>
 *     this interface enable the object the power to remember things.
 *     note that the difference between the read ,write interface is that
 *     the memory can only be accessed by the object itself.
 * </p>
 */
public interface Memory<K,V> {
    default int remember(K key,V value){
        return 0;
    }
    default int forget(K key){
        return 0;
    }
    default Object readFromMemory(K key){
        return null;
    }
    default int updateMemory(K key ,V value){
        return 0;
    }
}

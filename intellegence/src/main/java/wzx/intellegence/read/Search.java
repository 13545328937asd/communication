package java.wzx.intellegence.read;

import java.util.List;

/**
 * @Author 24521
 */
public interface Search<T,V> {
    default List<V>  search(T params){
        return null;
    }
}

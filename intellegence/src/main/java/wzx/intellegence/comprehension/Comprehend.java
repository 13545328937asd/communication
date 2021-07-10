package java.wzx.intellegence.comprehension;

/**
 * comprehend something to get a result
 * @param <T>
 * @param <K>
 */
public interface Comprehend<T,K> {
    default K comprehend(T message){

        return null;
    }
}

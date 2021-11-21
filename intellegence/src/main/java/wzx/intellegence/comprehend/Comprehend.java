package java.wzx.intellegence.comprehend;

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

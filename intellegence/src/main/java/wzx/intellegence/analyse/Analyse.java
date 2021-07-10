package java.wzx.intellegence.analyse;

/**
 * analyse ability. analyse something to draw a conclusion
 * @param <T>
 * @param <K>
 */
public interface Analyse<T,K> {
    default K analyse(T thing){
        return null;
    }
}

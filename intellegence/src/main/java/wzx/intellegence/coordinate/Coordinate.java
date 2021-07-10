package java.wzx.intellegence.coordinate;

/**
 *
 * @Author 24521
 */
public interface Coordinate<T> {
    default T startCoodinate(){
        return null;
    }
    default void endCoordinate(T coordinator){

    }
}

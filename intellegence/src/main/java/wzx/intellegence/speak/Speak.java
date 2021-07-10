package java.wzx.intellegence.speak;

/**
 * <p>
 *    this interface help the object say something to convey information.
 * </p>
 */
public interface Speak<M,S> {
    default S speak(M message){
        return speak(message,true);
    }
    default S speak(M message,boolean waitForRespose){
        return null;
    }
}

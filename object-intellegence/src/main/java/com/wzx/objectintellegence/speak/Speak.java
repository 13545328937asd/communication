package com.wzx.objectintellegence.speak;

import com.wzx.message.CommunicationMessage;
import com.wzx.message.messageanswer.Answer;

/**
 * <p>
 *    this interface help the object say something to convey information.
 * </p>
 */
public interface Speak {
    default Answer speak(CommunicationMessage message){
        return speak(message,true);
    }
    default Answer speak(CommunicationMessage message,boolean waitForRespose){
        return null;
    }
}

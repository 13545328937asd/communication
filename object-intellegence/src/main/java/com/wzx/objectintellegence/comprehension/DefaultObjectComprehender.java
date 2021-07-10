package com.wzx.objectintellegence.comprehension;

import com.wzx.common.object.action.Action;
import com.wzx.common.object.action.NativeMethodObjectAction;
import com.wzx.message.CommunicationMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * comprehend the message to execute the native method(the actions defined in the class)
 */
public interface DefaultObjectComprehender extends Comprehend<CommunicationMessage,List<Action>>{

    default List<Action> comprehendMessage(CommunicationMessage message) {
        List<Action> actions= new ArrayList<>();
        actions.add(new NativeMethodObjectAction());
        return actions;
    }

    @Override
    default List<Action> comprehend(CommunicationMessage message) {
        return null;
    }

    public static Comprehend getInstance(){
        return new DefaultObjectComprehender();
    }
}

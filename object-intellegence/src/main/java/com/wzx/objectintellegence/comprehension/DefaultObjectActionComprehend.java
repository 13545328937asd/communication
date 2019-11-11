package com.wzx.objectintellegence.comprehension;

import com.wzx.common.object.action.Action;
import com.wzx.common.object.action.ExecuteNativeMethodAction;
import com.wzx.message.CommunicationMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * comprehend the message to execute the native method(the actions defined in the class)
 */
public class DefaultObjectActionComprehend implements Comprehend{
    @Override
    public List<Action> comprehendMessage(CommunicationMessage message) {
        List<Action> actions= new ArrayList<>();
        actions.add(new ExecuteNativeMethodAction());
        return actions;
    }
    public static Comprehend getInstance(){
        return new DefaultObjectActionComprehend();
    }
}

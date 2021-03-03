package com.wzx.objectintellegence.comprehension;

import com.wzx.common.object.action.Action;
import com.wzx.message.CommunicationMessage;

import java.util.ArrayList;
import java.util.List;

public interface Comprehend {
    default List<Action> comprehendMessage(CommunicationMessage message){

        return new ArrayList<>();
    }
}

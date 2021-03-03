package com.wzx.objectintellegence.Listen;

import com.wzx.common.exceptions.CommunicationException;
import com.wzx.common.object.action.Action;
import com.wzx.common.object.action.ActionContext;
import com.wzx.common.object.action.ActionExecutor;
import com.wzx.common.tools.CollectionUtil;
import com.wzx.common.tools.ObjectInfoChecker;
import com.wzx.message.CommunicationMessage;
import com.wzx.objectintellegence.comprehension.Comprehend;
import com.wzx.objectintellegence.comprehension.DefaultObjectComprehender;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *    enable the object listening ability,which will
 *    help the object receive messages from outer worlds such as some other objects or
 *    systems,making it easier for objects to communicate
 * </p>
 */
public interface Listen {
    /**
     * ①找到这个消息真正的消费者，getTargetObject。
     * ②解析当前消息，即理解当前消息。comprehend the message
     * ③根据自己的理解，做相应的事情。do the corresponding thing
     */
    default void listen(CommunicationMessage message){
        Object targetObject = getTargetObject(message.getToObjName());
        List<Action> actions = resolveObjectActions(message);
        ActionExecutor.excuteActions(actions,getActionContext(message));
    }

    default ActionContext getActionContext(CommunicationMessage message){
        return null;
    };

    default List<Action> resolveObjectActions(CommunicationMessage message){
        List<Action> actions=null;
        if(this instanceof Comprehend){
            actions = ((Comprehend) this).comprehendMessage(message);
        }
        if(CollectionUtil.isEmpty(actions)){
            actions=new ArrayList<>();
        }

        actions.addAll(DefaultObjectComprehender.getInstance().comprehendMessage(message));
        return actions;
    };


    default Object getTargetObject(String toObjName){
        if(ObjectInfoChecker.isNameOfClass(toObjName, this.getClass())){
            return this;
        }else{
            throw new CommunicationException("the class "+this.getClass()+" do not have a name called "+toObjName);
        }
    }
}

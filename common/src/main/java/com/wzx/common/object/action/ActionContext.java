package com.wzx.common.object.action;

import com.wzx.message.CommunicationMessage;
import com.wzx.message.messageanswer.Answer;

import java.util.List;

public class ActionContext {
    private Answer answer;
    private CommunicationMessage message;
    private List<Action> actions;
    private Object actionObj;
    private int index=-1;
}

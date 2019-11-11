package com.wzx.common.object.action;

import com.wzx.message.CommunicationMessage;

import java.util.List;

public class ActionContext {
    private CommunicationMessage message;
    private List<Action> actions;
    private Object actionObj;
    private Object[] actionParams;
    private int index=-1;

}

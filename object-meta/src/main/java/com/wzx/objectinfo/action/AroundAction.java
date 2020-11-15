package com.wzx.objectinfo.action;

import com.wzx.objectinfo.action.context.ActionContext;

import java.util.List;


/**
 * the action will be executed around a specific action
 */
public class AroundAction extends ObjectAction {

    private Action action;

    public AroundAction(Action action) {
        this.action = action;
    }

    @Override
    public Object doExecute(ActionContext actionContext) {
        //before

        action.execute(actionContext);

        //after

        return null;
    }

    @Override
    public String getActionName() {
        return null;
    }

    @Override
    public List<ActionParam> getActionParams() {
        return null;
    }
}

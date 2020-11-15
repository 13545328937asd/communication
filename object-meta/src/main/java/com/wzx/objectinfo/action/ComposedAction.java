package com.wzx.objectinfo.action;

import com.wzx.objectinfo.action.context.ActionContext;

import java.util.List;

/**
 * the action is made up of several other actions,these actions will execute
 *  in the specific order.
 *
 */
public class ComposedAction  extends ObjectAction{
    private List<Action> actions;

    @Override
    protected Object doExecute(ActionContext actionContext) {
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

package com.wzx.common.object.action;

import java.util.List;

public class ObjectAction implements Action
{
    private String actionName;

    private List<ActionParam> actionParams;

    @Override
    public Object act(Object actionObject,ActionContext actionContext, Object... params) {
        return null;
    }
    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }


    public List<ActionParam> getActionParams() {
        return actionParams;
    }

    public void setActionParams(List<ActionParam> actionParams) {
        this.actionParams = actionParams;
    }


}

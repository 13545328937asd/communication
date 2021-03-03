package com.wzx.common.object.action;

import java.util.List;

public abstract class ObjectAction implements Action
{

    private String actionName;
    private List<ActionParam> actionParams;

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

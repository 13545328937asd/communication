package com.wzx.objectinfo.action;


import com.wzx.objectinfo.action.context.ActionContext;

import java.util.List;

public abstract class ObjectAction<R> implements Action<R>
{
    /**
     * 执行当前行为的对象
     */
    protected Object actionObject;
    protected String actionName;
    protected List<ActionParam> actionParams;

    @Override
    public R execute(ActionContext actionContext) {
        initActionBaseInfo(actionContext);
        return doExecute(actionContext);
    }

    protected void initActionBaseInfo(ActionContext actionContext) {
        setActionObject(actionContext.getActionObj());
        setActionName(getActionName());
        setActionParams(getActionParams());
        Object actionParam = actionContext.getActionParam();
    }

    protected abstract R doExecute(ActionContext actionContext);
    protected abstract String getActionName();
    protected abstract List<ActionParam> getActionParams();
    protected  ActionType getActionType(){
        return ActionType.COMMON;//默认正常行为
    }
    public void setActionObject(Object actionObject) {
        this.actionObject = actionObject;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public void setActionParams(List<ActionParam> params) {
        this.actionParams = params;
    }
}

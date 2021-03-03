package com.wzx.common.object.action;

/**
 *   something the object can do
 */
public interface Action {

    /**
     *  do sth defined in the action
     * @param actionContext  the context of the action
     * @return
     */
    public Object execute(ActionContext actionContext);
}

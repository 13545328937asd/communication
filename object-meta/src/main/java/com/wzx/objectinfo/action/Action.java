package com.wzx.objectinfo.action;


import com.wzx.objectinfo.action.context.ActionContext;

/**
 *   something the object can do.
 */
public interface Action<R> {

    /**
     *  do sth defined in the action
     * @param actionContext  the context of the action
     * @return
     */
    public R execute(ActionContext actionContext);

}

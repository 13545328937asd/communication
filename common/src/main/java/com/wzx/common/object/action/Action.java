package com.wzx.common.object.action;

/**
 *   something the object can do
 */
public interface Action {

    /**
     *
     * @param actionObject the obj who do the particular thing
     * @param params the params of the action
     * @return
     */
    public Object act(Object actionObject,ActionContext actionContext,Object... params);
}

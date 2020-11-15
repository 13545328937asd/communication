package com.wzx.objectinfo.action;

import com.wzx.objectinfo.action.context.ActionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *   ---  anlyse action of objects,which will help object anlyse sth
 *   ---对象的某个具体分析行为，帮助对象分析某件事情
 * <p/>
 *
 */
public  class AnalyseAction<R> extends ObjectAction<R> {

    @Override
    protected R doExecute(ActionContext actionContext) {
        return null;
    }

    @Override
    protected String getActionName() {
        return actionName;
    }

    @Override
    protected List<ActionParam> getActionParams() {
        return null;
    }
}

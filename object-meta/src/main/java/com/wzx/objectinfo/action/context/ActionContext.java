package com.wzx.objectinfo.action.context;

/**
 * the context of the concrete action
 */
public interface ActionContext<P> {
    /**
     * 获取执行此行为需要的参数
     * @return
     */
    public P getActionParam();
    /**
     * 获取执行此行为的对象
     * @return
     */
    public Object getActionObj();

}

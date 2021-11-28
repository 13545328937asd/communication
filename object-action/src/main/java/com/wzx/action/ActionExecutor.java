package com.wzx.action;

import com.wzx.common.tools.CollectionUtil;

import java.util.List;

/**
 * 行为执行器
 *  主要用于管控行为的执行，真正管控的是执行这个行为的对象本身（对象负责管理自己的所有行为）。
 *      举例如下：①是否记住本次行为是谁让执行的。
 *                ②是否记住本次行为的返回结果。
 *                .......等
 *
 *  行为和拦截器的理解，行为是自己做的事情，拦截器是别人做的操作。
 *  自己分内的事情，尽量不要让别人拦截去处理。比如 打印日志 更偏向于拦截处理，因为
 *  拿到日志是管理员做日志分析和排查问题的。
 */
public class ActionExecutor {

    public static void excuteActions(List<Action> actions,ActionContext actionContext){
        if(CollectionUtil.isEmpty(actions)){
            return;
        }
        for(Action action:actions){
            try{
                //do something before the action execute

                Object actionResult = action.execute(actionContext);

                //do something after the action execute

            }catch (Exception e){
                //执行action报错之后的行为
            }finally {
                //no matter whether the action executes successfully
            }
        }
    }
}

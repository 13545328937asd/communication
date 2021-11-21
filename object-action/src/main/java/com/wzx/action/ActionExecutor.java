package com.wzx.action;

import com.wzx.common.tools.CollectionUtil;

import java.util.List;

/**
 * 行为执行器
 *  主要用于管控行为的执行，真正管控的是执行这个行为的对象本身（对象负责管理自己的所有行为）。
 *      举例如下：①是否记住本次行为是谁让执行的。
 *                ②是否记住本次行为的返回结果。
 *                .......等
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

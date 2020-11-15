package com.wzx.objectinfo.ability;

/**
 * object who implements this interface will has the coordination ability,which can
 * be used to solve the distribute transaction problem
 */
public interface Coordinate {
    /**
     *  开始协调后面做的事情
     * @param  failDisposeStrategy  ,失败之后的处理策略
     * @return
     */
    default boolean startCoordinate(String failDisposeStrategy){


        return true;
    }

    /**
     * 结束协调，就是对象后面做什么事情，都不在特意关注了
     * @return
     */
    default boolean endCoordinate(){

        return false;
    }
}

package com.wzx.objectinfo.ability;


/**
 * analyse ability of object
 *
 */
public interface Analyse<T> {

    default Object analyse(T thing){
        return null;
    }

    /**
     *
     * @param thing
     * @param obj
     * @return
     */
    default Object analyseObject(T thing,Object obj){
        return null;
    };
}

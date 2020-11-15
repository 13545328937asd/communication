package com.wzx.objectinfo.ability;

import lombok.Builder;

import java.util.List;

/**
 * <p>
 *
 * </p>
 */
public interface Social {
    /**
     * children of the object,sometimes need to ask his children to do something。
     * @return
     */
    default List<Class> children(){
        return null;
    }

    /**
     * known friends ,sometimes need to communicate with his friends
     * @return
     */
    default List<String> knownFriends(){
        return null;
    }

    

}

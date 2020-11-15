package com.wzx.objectintellegence.comprehension;


import com.wzx.objectinfo.ability.Comprehend;
import com.wzx.objectinfo.action.Action;
import com.wzx.objectinfo.action.NativeMethodAction;

import java.util.ArrayList;
import java.util.List;

/**
 * comprehend the message to execute the native method(the actions defined in the class)
 */
public interface DefaultObjectComprehender<T> extends Comprehend<T> {
    @Override
    default List<Action> comprehend(T message) {
        List<Action> actions= new ArrayList<>();
        actions.add(new NativeMethodAction());
        test();
        return actions;
    }
    public void test();

}

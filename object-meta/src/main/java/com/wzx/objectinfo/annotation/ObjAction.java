package com.wzx.objectinfo.annotation;

import com.wzx.objectinfo.action.ObjectAction;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ObjAction {
    /**
     * the obj action,usually a method name.
     * @return
     */
    String value() default "";

    String actionName() default "";

    String actionDesc() default "";

    Class<? extends ObjectAction> actionClass();

    ActParam[] actionParams();

}

package com.wzx.message.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ObjectAction {
    /**
     * the obj action,usually a method name.
     * @return
     */
    String value() default "";

    String action() default "";

    String actionDesc() default "";
}

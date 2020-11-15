package com.wzx.objectinfo.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ActParam {
    /**
     * if a obj type,config a json str
     * @return
     */
    String value() default "";

    String name() default "";

    Class paramType() default String.class;

    String paramDesc() default "";
}

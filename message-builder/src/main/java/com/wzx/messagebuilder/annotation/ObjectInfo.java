package com.wzx.messagebuilder.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ObjectInfo {
    /**
     * the obj name
     * @return
     */
    String name() default "";


    String value() default "";
    /**
     * the application info
     * @return
     */
    ApplicationInfo application() default @ApplicationInfo;
}

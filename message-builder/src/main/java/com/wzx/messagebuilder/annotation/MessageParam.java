package com.wzx.messagebuilder.annotation;


import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MessageParam {
    String value() default "";

    String name() default "";

    String paramDesc() default "";
}

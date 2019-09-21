package com.wzx.messagebuilder.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ExposeToOuterNet {
    String name() default "";
}

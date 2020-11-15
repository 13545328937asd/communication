package com.wzx.objectinfo.annotation.intelligence;

import com.wzx.objectinfo.ability.Write;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Writer {
    Class<? extends Write> writer();
    /**
     * the name of the writer
     * @return
     */
    String name();
}

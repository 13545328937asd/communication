package com.wzx.objectinfo.annotation.intelligence;

import com.wzx.objectinfo.ability.Read;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Reader {
    Class<? extends Read> reader();

    /**
     * the name of the reader
     * @return
     */
    String name();
}

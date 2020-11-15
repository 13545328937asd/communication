package com.wzx.objectinfo.annotation.intelligence;

import com.wzx.objectinfo.ability.Memory;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Memorizer {
    Class<? extends Memory> memoryer();
    /**
     * name of memoryer
     * @return
     */
    String name();
}

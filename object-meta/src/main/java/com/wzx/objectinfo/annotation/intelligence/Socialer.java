package com.wzx.objectinfo.annotation.intelligence;


import com.wzx.objectinfo.ability.Social;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Socialer {
    Class<? extends Social> socialer();

    /**
     * name of the socialer
     * @return
     */
    String name();
}

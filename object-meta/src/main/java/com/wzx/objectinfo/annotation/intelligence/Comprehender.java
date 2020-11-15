package com.wzx.objectinfo.annotation.intelligence;

import com.wzx.objectinfo.ability.Comprehend;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Comprehender {
    /**
     * the concrete comprehender class
     * @return
     */
    Class<? extends Comprehend> comprhender();

    /**
     * the name of the comprehender
     * @return
     */
    String name();
}

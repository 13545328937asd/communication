package com.wzx.objectinfo.annotation.intelligence;

import com.wzx.objectinfo.ability.Coordinate;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Coordinator {
    Class<? extends Coordinate> coordinator();

    String name();
}

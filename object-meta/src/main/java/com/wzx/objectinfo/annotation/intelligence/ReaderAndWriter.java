package com.wzx.objectinfo.annotation.intelligence;

import com.wzx.objectinfo.ability.ReadeAndWrite;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ReaderAndWriter {
    Class<? extends ReadeAndWrite>  readerAndWriter();
    String name();
}

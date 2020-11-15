package com.wzx.objectinfo.annotation.intelligence;

import com.wzx.objectinfo.ability.Analyse;
import com.wzx.objectinfo.action.AnalyseAction;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Analyzer {
    /**
     * the concrete analyse class
     * @return
     */
    Class<? extends Analyse> analyzer();

    /**
     * the name of the analyzer
     * @return
     */
    String name();
}

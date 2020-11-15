package com.wzx.objectinfo.annotation;


import com.wzx.objectinfo.annotation.intelligence.Analyzer;
import com.wzx.objectinfo.annotation.intelligence.Comprehender;
import com.wzx.objectinfo.annotation.intelligence.Memorizer;
import com.wzx.objectinfo.annotation.intelligence.ReaderAndWriter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ObjInfo {
    /**
     * the obj name
     * @return
     */
    String name() default "";
    Analyzer[] analyseActions() default {};
    Comprehender[] comprehendActions() default {};
    Memorizer memorizer();
    ReaderAndWriter readerAndWriter();
    /**
     * the application info
     * @return
     */
    AppInfo application() default @AppInfo;
}

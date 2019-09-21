package com.wzx.messagebuilder.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApplicationInfo {
    /**
     * the application name
     * @return
     */
    String appName() default "";

    @AliasFor("appName")
    String value() default "";
    /**
     * the application locations,the ip address and the port。like 127.0.0.1:80
     * @return
     */
    String[] localtions() default {};
}

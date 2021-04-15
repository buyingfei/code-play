package com.buyf.deploy.user.center;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamProperty {
    ParamPropertyTypeEnum type() default ParamPropertyTypeEnum.RECURSION;


    String paramsName() default "";

    String dataType() default "";

    String defaultValue() default "";

    int index() default 0;

    boolean isShow() default true;// 当前递归节点是否启动
}
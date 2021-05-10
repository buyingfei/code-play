package com.buyf.deploy.user.center;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamPropertyList {
    String paramsName() default "";
    String dataType() default "";
    String defaultValue() default "";
    int index() default 0;
    String showField() default "";
    ParamProperty[] paramProperty();

}

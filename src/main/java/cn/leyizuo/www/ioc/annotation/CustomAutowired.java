package cn.leyizuo.www.ioc.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface CustomAutowired {
    String value() default"";
}

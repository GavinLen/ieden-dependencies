package xyz.ieden.core.gson.annotation;

import java.lang.annotation.*;

/**
 * Gson 排除注解
 *
 * @author lianghongwei01
 * @version 1.0.1
 * @date 2019/11/20 20:04
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Exclude {
    /**
     * 开启
     *
     * @return
     */
    boolean enable() default true;
}

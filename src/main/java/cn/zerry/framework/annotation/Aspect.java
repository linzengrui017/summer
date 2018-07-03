package cn.zerry.framework.annotation;

import java.lang.annotation.*;

/**
 * @author linzengrui
 * @Description 切面注解
 * @date 2018年07月03日 21:07
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}

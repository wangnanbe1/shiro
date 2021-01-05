package com.exception.test.annotation;


import java.lang.annotation.*;

/**
 *
 * @author wc
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopAnnotation {
}

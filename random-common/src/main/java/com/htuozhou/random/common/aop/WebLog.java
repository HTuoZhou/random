package com.htuozhou.random.common.aop;

import java.lang.annotation.*;

/**
 * @author hanzai
 * @date 2023/2/2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
}

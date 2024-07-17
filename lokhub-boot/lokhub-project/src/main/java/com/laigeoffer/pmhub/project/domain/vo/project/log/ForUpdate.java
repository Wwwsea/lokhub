package com.laigeoffer.lokhub.project.domain.vo.project.log;

import java.lang.annotation.*;

/**
 * @author fish
 * @date 2022-12-22 14:57
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ForUpdate {
    String fieldName() default "";
}

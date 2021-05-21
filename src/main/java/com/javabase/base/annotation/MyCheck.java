package com.javabase.base.annotation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = ParamConstraintValidated.class)
public @interface MyCheck {
    /**
     * 合法的参数值
     **/
    String[] paramValues();

    /**
     * 提示信息
     **/
    String message() default "参数不为指定值";

    Class<?>[] groups() default {};

   // Class<? extends Payload>[] payload() default {};
}

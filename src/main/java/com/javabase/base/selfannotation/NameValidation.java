package com.javabase.base.selfannotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD})
//只允许用在类的字段上
@Retention(RetentionPolicy.RUNTIME)
//注解保留在程序运行期间，此时可以通过反射获得定义在某个类上的所有注解
@Constraint(validatedBy = PersonValidator.class)
public @interface NameValidation {
    String message() default "不是合法的名字";
    /**
     * 合法的参数值
     **/
    String[] paramValues();
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        NameValidation[] value();
    }


}

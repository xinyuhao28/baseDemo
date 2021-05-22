package com.javabase.base.selfannotation;

import com.javabase.base.pojo.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

//PersonValidator类只实现了对密码判断是否为空,为空则注册这一错误信息,也就是”password is null”
public class PersonValidator implements ConstraintValidator<NameValidation, String> {
    /**
     * 合法的参数值，从注解中获取
     * */
    private List<String> paramValues;

    @Override
    public void initialize(NameValidation constraintAnnotation) {
        //初始化时获取注解上的值
        paramValues = Arrays.asList(constraintAnnotation.paramValues());
        for (String a:paramValues) {
            System.out.println("PersonValidator.initialize"+a);

        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       /* if ("steven".equalsIgnoreCase(value)) {
            return true;
        }
        String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
        System.out.println("default message :" + defaultConstraintMessageTemplate);
        //禁用默认提示信息
        //context.disableDefaultConstraintViolation();
        //设置提示语
        //context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
        return false;*/

        //判断传入的参数是否在给定的参数范围内
        if (paramValues.contains(value)) {
            System.out.println("validation succeed");
            return true;
        }
        System.out.println("PersonValidator.isValid");
        System.out.println(value);

        //不在指定的参数列表中
        return false;
    }


}

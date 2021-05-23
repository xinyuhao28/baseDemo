package com.javabase.base.pojo;

import com.javabase.base.annotation.MyAnno;
//import org.hibernate.validator.constraints.NotBlank;
//import org.hibernate.validator.constraints.Range;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.lang.annotation.Retention;


public class User implements Serializable {

    private static final long serialVersionUID = 5205149701434065261L;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Min(value = 5,message = "age must lessthan 5")
  //  @Range(min = 10, max = 25, message = "年龄必须在10~25之间 ")
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnno
    public String showName()
    {
        name = "123";
        age = 22;
        return "sfa";
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

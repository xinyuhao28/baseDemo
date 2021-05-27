package com.javabase.mystream.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Objects;

@Slf4j
@Data

public class Pestu implements Serializable {
    private static final long serialVersionUID = 6293526914670404296L;
    private String name;
    private int salary;
    private int age;
    private String sex;
    private String area;

    public Pestu() {

    }

    /**
     * @param name
     * @param salary
     * @param age
     * @param sex
     * @param area
     */
    public Pestu(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pestu pestu = (Pestu) o;
        return salary == pestu.salary && age == pestu.age && name.equals(pestu.name) && sex.equals(pestu.sex) && area.equals(pestu.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, age, sex, area);
    }



}

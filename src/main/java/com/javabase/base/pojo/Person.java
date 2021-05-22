package com.javabase.base.pojo;

import com.javabase.base.selfannotation.NameValidation;
import lombok.Data;

@Data
public class Person {
    @NameValidation(paramValues = {"man", "woman"})
    private String username;
    @NameValidation(paramValues = {"123", "567"})
    private String password;

    private String nickname;
}

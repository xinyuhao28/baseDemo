package com.javabase.base.pojo;

import com.javabase.base.selfannotation.NameValidation;
import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 4722663965464415426L;
    @NameValidation(paramValues = {"man", "woman"})
    private String username;
    @NameValidation(paramValues = {"123", "567"})
    private String password;

    private String nickname;
}

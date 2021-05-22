package com.javabase.base.controler;

import com.javabase.base.pojo.Person;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class SelfAnnotation {

    @PostMapping("/login")
    public String login(@RequestBody @Validated Person user, BindingResult br) {

        System.out.println("SelfAnnotation.login:" + user);

        if (br.hasErrors()) {
            return "user/login";

        }

        return "ok";

    }
}

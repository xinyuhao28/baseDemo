package com.javabase.base.controler;

import com.javabase.base.interceptor.PermissionCheck;
import com.javabase.base.myexception.UserDefinedException;

import com.javabase.base.service.PerService;
import com.javabase.base.service.impl.PerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class YanController {


    // @Autowired
    @Resource(name = "perServiceImpl")

    private PerService perService;

    @RequestMapping("/s1")
  //  @PermissionCheck(resourceKey = "test1")
    public String s1()  {

    //    PerService ps= new PerServiceImpl();
        //    throw new UserDefinedException(CodeAndMsg.TESTERRPARAME);
        perService.showPersons();
        log.info("http s1");
        return "ok";
    }
}
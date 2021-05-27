package com.javabase.base.controler;

import com.javabase.base.aspect.CustomCache;
import com.javabase.base.interceptor.PermissionCheck;
import com.javabase.base.logic.DemoThread;
import com.javabase.base.myexception.*;
import com.javabase.base.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

//@Controller
@RestController
public class ValidControl {
    //   @Autowired
    DemoThread demoThread;

    @PostMapping("/hello")
    public String hello(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError);
            }
            return "fail";
        }

        System.out.println("Hello.hello" + user);

        show(user);
        return "ok";
    }

    /**
     * 异常统一处理
     *
     * @param user
     * @return
     */
    @PostMapping("/h1")
    @PermissionCheck(resourceKey = "test1")
    public CallResultMsg h1(@RequestBody @Valid User user) {

        System.out.println("Hello.hello" + user);
        //  show(user);
        //  return "ok";
        Map<String, Integer> map = new HashMap();
        map.put("qingfen", 16);
        map.put("lantian", 17);
        map.put("baiyun", 18);
        return new UniformReponseHandler<Map>().sendSuccessResponse(map);
    }

    @PostMapping("/h2")
    @CustomCache(key = "testKey")
    public CallResultMsg h2(@RequestBody @Valid User user) {

        System.out.println("Hello.hello" + user);
        //  show(user);
        //  return "ok";
        Map<String, Integer> map = new HashMap();
        map.put("qingfen", 16);
        map.put("lantian", 17);
        map.put("baiyun", 18);
        return new UniformReponseHandler<Map>().sendSuccessResponse(map);
    }

    @RequestMapping("/index")
    public String sayHello() throws UserDefinedException {
/*

        ArrayList<User> list;
        Map<Integer, User> map ;
        ThreadPoolExecutor
        Collection

        Condition
        System.out.println("test start");
        demoThread = new DemoThread();
        demoThread.start();
        try {
            demoThread.start();
        }catch (Exception e ){
            System.out.println("e = " + e);

        }
*/
        //    throw new UserDefinedException(CodeAndMsg.TESTERRPARAME);
        User user = new User("", 0);
        show(user);
        return "ok";
    }

    public void show(@Valid User info) {
        System.out.println(info);
        throw new MyTestException("my test errrrrr");


    }
}

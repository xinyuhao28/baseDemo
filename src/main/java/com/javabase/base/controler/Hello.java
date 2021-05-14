package com.javabase.base.controler;

import com.javabase.base.logic.DemoThread;
import com.javabase.base.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

@Controller
public class Hello {
    @Autowired
    DemoThread demoThread;

    @RequestMapping("/index")
    public String sayHello() {
/*

        ArrayList<User> list;
        Map<Integer, User> map ;
        ThreadPoolExecutor
        Collection
*/
        System.out.println("test start");
       // dt = new DemoThread();
        demoThread.start();
        /*try {
            Thread.sleep(1000);
        }catch (InterruptedException e ){
            System.out.println("e = " + e);

        }*/

        return "index";
    }

}

package com.javabase.base.logic;

import org.springframework.stereotype.Component;

@Component
public class DemoThread extends Thread {
    private String name = "123";


    public DemoThread(/*String name*/) {
       // this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("DemoThread.run");
            System.out.println("i = " + i);
            System.out.println();
            System.out.println("DemoThread.run");
            System.out.println(name + i);
            
        }

    }

}

package com.javabase.mystream;

import com.javabase.mystream.pojo.MyStreamConfig;
import com.javabase.mystream.pojo.Pestus;
import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.Assert.*;
@ComponentScan({"com.javabase.mystream"})
public class StreamCallTest {
    static private StreamCall call;
    static private Pestus ent;

    @org.junit.BeforeClass
    static public void BefClass() throws  Exception {
        System.out.println("StreamCallTest.voidBefClass");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyStreamConfig.class);
        ctx.refresh();
        ent = (Pestus)ctx.getBean("pestus");
        System.out.println("StreamCallTest.BefClass:"+ent);
        call = new StreamCall(ent);
    }




    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("StreamCallTest.setUp");

    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("StreamCallTest.tearDown");
    }

    @org.junit.Test
    public void showPersons() {
        System.out.println("StreamCallTest.showPersons");
        call.ShowPersons();
    }
    @org.junit.Test
    public void show1() {
        System.out.println("StreamCallTest.showPersons");
        call.show3();

    }

}
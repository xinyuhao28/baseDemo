package com.javabase.mystream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamCallTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("StreamCallTest.beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("StreamCallTest.afterAll");
    }

    @Test
    void showPersons() {
        System.out.println("StreamCallTest.showPersons");
        new StreamCall().ShowPersons();
    }
}
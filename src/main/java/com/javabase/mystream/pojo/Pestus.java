package com.javabase.mystream.pojo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class Pestus {
    public List<Pestu> getPestuList() {
        return pestuList;
    }

    private List<Pestu> pestuList;

    public Pestus() {
        pestuList = new ArrayList<Pestu>();
        pestuList.add(new Pestu("zhangsan", 222, 22, "male", "chaina"));
        pestuList.add(new Pestu("Tom", 8900, 32, "male", "New York"));
        pestuList.add(new Pestu("Jack", 7000, 31, "male", "Washington"));
        pestuList.add(new Pestu("Lily", 7800, 30, "female", "Washington"));
        pestuList.add(new Pestu("Anni", 8200, 29, "female", "New York"));
        pestuList.add(new Pestu("Owen", 9500, 28, "male", "New York"));
        pestuList.add(new Pestu("Alisa", 7900, 27, "female", "New York"));

        log.info("Persons start"+this);
    }

    @Override
    public String toString() {
        return "Persons{" +
                "personList=" + pestuList +
                '}';
    }
}

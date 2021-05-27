package com.javabase.mystream;

import com.javabase.mystream.pojo.Pestus;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Data
public class StreamCall {
    @Autowired
    private Pestus ps;

    public StreamCall() {
    }

    public void ShowPersons() {
        System.out.println(ps);
    }
}

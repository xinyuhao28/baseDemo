package com.javabase.base.service.impl;

import com.javabase.base.service.PerService;
import com.javabase.mystream.pojo.Pestus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PerServiceImpl implements PerService {
    @Autowired
    private Pestus pestus;
    @Override
    public int count(){
        return 1;
    }
    @Override
    public  void showPersons(){
        log.info("show Pestus:"+pestus);

    }

}

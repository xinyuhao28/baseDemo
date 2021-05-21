package com.javabase.base.myexception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CallResultMsg<T> {
    private boolean result;
    private int code;
    private String message;
    private T data;
}

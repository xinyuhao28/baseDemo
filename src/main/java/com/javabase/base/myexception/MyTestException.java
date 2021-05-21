package com.javabase.base.myexception;

public class MyTestException extends RuntimeException{
    private String exception;

    public MyTestException(String exception ){
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}

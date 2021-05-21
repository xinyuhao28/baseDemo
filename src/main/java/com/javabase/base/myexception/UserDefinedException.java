package com.javabase.base.myexception;

public class UserDefinedException extends RuntimeException {
    private CodeAndMsg exception;

    public UserDefinedException(CodeAndMsg exception){
        this.exception = exception;
    }

    public CodeAndMsg getException() {
        return exception;
    }

    public void setException(CodeAndMsg exception) {
        this.exception = exception;
    }
}

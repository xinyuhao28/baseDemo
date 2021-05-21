package com.javabase.base.myexception;


public enum CodeAndMsg {
    SUCCESS(1000, "SUCCESS"),
    METHODFAIL(2000, "ENCOUNTER AN ERROR WHEN EXECUTE METHOD"),
    UNKNOWEXCEPTION(3000, "THIS IS AN UNKNOW EXCEPTION"),
    ERRPARAME(5000, "THE PARAME ERR"),
    TESTERRPARAME(6000, "THE TEST ERR");

    private int code;
    private String msg;

    private CodeAndMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

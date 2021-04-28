package com.example.demo.base;


import java.io.Serializable;

/**
 * @author:author
 * @date: 2020-11-05
 * @description:  ResultVO统一返回结果集
 */
public class ResultVO<T> implements Serializable {
    private int code;
    private String msg;
    private T result;
    private String applicationName = "saas-gateway-web";
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}


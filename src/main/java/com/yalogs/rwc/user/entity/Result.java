package com.yalogs.rwc.user.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Result implements Serializable {

    private int code;

    private String message;

    private Object data;

    // 成功
    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 失败
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 成功
    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

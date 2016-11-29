package com.github.example.core.model;

import com.google.gson.annotations.SerializedName;

/**
 * 类描述:    描述该类的功能
 * 创建人:    wzg
 * 创建时间:  16/9/20
 * 创建人:    wzg
 * 修改时间:  16/9/20 16:58
 * 修改备注:  说明本次修改内容
 */
public class BaseModel<T> {
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private T data;
    @SerializedName("code")
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
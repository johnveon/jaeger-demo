package com.example.jaegerdemo.common;

/**
 * @description: 通用返回
 * @author: zhoufengen
 * @create at: 2019-04-10 15:33
 **/
public class Baseresult<T> {

    private Integer code;
    private String desc;
    private T data;

    public Baseresult() {
    }

    public Baseresult(int code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;

    }


    public static <T> Baseresult<T> success(T data) {
        return new Baseresult(200, "成功", data);
    }

    public static <T> Baseresult<T> fail(String desc) {
        return new Baseresult(400, desc, null);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

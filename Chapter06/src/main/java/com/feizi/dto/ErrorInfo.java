/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.dto;

import java.io.Serializable;

/**
 * @Desc 异常信息基类
 * @Author feizi
 * @Date 2016/10/19 19:12
 * @Package_name com.feizi.dto
 */
public class ErrorInfo<T> implements Serializable{

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    private static final long serialVersionUID = -4125227064116888631L;

    private Integer code;
    private String message;
    private String url;
    private T data;

    public static Integer getOK() {
        return OK;
    }

    public static Integer getERROR() {
        return ERROR;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

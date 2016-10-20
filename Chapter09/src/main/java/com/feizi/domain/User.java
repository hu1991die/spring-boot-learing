/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.domain;

import java.io.Serializable;

/**
 * @Desc User实体
 * @Author feizi
 * @Date 2016/10/20 13:58
 * @Package_name com.feizi.domain
 */
public class User implements Serializable {
    private static final long serialVersionUID = -8674644621309538698L;

    private String username;
    private Integer age;

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

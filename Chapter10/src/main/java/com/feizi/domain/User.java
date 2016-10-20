/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @Desc User实体对象
 * @Author feizi
 * @Date 2016/10/20 16:17
 * @Package_name com.feizi
 */
public class User implements Serializable{
    private static final long serialVersionUID = 8586371759832670573L;

    @Id
    private Long id;

    private String username;

    private Integer age;

    public User() {
    }

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

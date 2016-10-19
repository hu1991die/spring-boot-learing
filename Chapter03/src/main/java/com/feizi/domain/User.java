/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.domain;

import java.io.Serializable;

/**
 * @Desc User的Model实体
 * @Author feizi
 * @Date 2016/10/19 14:07
 * @Package_name com.feizi.domain
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2222121387919425538L;
    private Long id;
    private String name;
    private Integer age;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

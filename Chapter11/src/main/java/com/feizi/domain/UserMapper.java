/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Desc UserMapper映射类
 * @Author feizi
 * @Date 2016/10/20 17:42
 * @Package_name com.feizi.domain
 */
@Mapper
public interface UserMapper {

    @Select("select * from USER where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into USER(name, age) values(#{name}, #{age})")
    int insert( @Param("name") String name, @Param("age") Integer age);
}
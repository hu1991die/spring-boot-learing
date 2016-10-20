/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.domain;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Desc UserMapper实体映射类
 * @Author feizi
 * @Date 2016/10/20 18:35
 * @Package_name com.feizi.domain
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();

    @Insert("insert into user (name, age) values (#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE user SET age=#{age} where name = #{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void delete(Long id);

    @Insert("INSERT INTO user (name, age) VALUES (#{name}, #{age})")
    int insertByUser(User user);

    @Insert("INSERT INTO user (name, age) VALUES (#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);
}

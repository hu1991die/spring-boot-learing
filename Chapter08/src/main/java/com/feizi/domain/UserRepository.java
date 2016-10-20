/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Desc UserRepository操作数据库接口
 * @Author feizi
 * @Date 2016/10/20 11:12
 * @Package_name com.feizi.domain
 */
public interface UserRepository extends JpaRepository<User, Long>{

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query(" from User u where u.name=:name")
    User findUser(@Param("name") String name);
}

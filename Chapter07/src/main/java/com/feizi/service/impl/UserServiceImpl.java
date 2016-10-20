/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.service.impl;

import com.feizi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Desc UserService接口实现类
 * @Author feizi
 * @Date 2016/10/20 10:12
 * @Package_name com.feizi.service.impl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @Desc 新增一个用户
     * @Author feizi
     * @Date 2016/10/20 10:10
     * @param name
     * @param age
     * @return
     */
    @Override
    public void create(Long id, String name, Integer age) {
        jdbcTemplate.update("insert into USER (ID, NAME, AGE) VALUES (?, ?, ?)",id, name, age);
    }

    /**
     * @Desc 根据name删除一个用户
     * @Author feizi
     * @Date 2016/10/20 10:11
     * @param id
     * @return
     */
    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from USER where id = ?", id);
    }

    /**
     * @Desc 获取用户总数
     * @Author feizi
     * @Date 2016/10/20 10:11
     * @return
     */
    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    /**
     * @Desc 删除所有用户
     * @Author feizi
     * @Date 2016/10/20 10:11
     * @return
     */
    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER ");
    }
}

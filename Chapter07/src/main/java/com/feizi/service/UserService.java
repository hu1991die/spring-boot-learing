/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.service;

/**
 * @Desc UserService接口
 * @Author feizi
 * @Date 2016/10/20 10:09
 * @Package_name com.feizi.service
 */
public interface UserService {

    /**
     * @Desc 新增一个用户
     * @Author feizi
     * @Date 2016/10/20 10:10
     * @param
     * @return
     */
    void create(Long id, String name, Integer age);

    /**
     * @Desc 根据name删除一个用户
     * @Author feizi
     * @Date 2016/10/20 10:11
     * @param
     * @return
     */
    void deleteById(Long id);

    /**
     * @Desc 获取用户总数
     * @Author feizi
     * @Date 2016/10/20 10:11
     * @param
     * @return
     */
    Integer getAllUsers();

    /**
     * @Desc 删除所有用户
     * @Author feizi
     * @Date 2016/10/20 10:11
     * @param
     * @return
     */
    void deleteAllUsers();
}
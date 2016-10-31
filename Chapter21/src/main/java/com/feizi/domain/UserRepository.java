/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Desc UserRepository数据库持久操作
 * @Author feizi
 * @Date 2016/10/29 9:15
 * @Package_name com.feizi.domain
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long>{

    @Cacheable(key = "#p0", condition = "#p0.length() < 10")
    User findByName(String name);
}

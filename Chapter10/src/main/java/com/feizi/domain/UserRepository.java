/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Desc 操作MongoDB数据库
 * @Author feizi
 * @Date 2016/10/20 16:19
 * @Package_name com.feizi.domain
 */
public interface UserRepository extends MongoRepository<User, Long>{

    User findByUsername(String username);
}

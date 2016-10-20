/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @Desc 实现对象的序列化接口,对传入的对象进行序列化和反序列化
 * @Author feizi
 * @Date 2016/10/20 14:00
 * @Package_name com.feizi.domain
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    //序列化对象
    private Converter<Object, byte[]> serializer = new SerializingConverter();
    //反序列化对象
    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    static final byte[] EMPTY_ARRAY = new byte[0];

    /**
     * @Desc 序列化操作
     * @Author feizi
     * @Date 2016/10/20 14:06
     * @param
     * @return
     */
    @Override
    public byte[] serialize(Object obj) throws SerializationException {
        if(null == obj){
            return EMPTY_ARRAY;
        }

        try {
            return serializer.convert(obj);
        } catch (Exception e) {
            return EMPTY_ARRAY;
        }
    }

    /**
     * @Desc 反序列化操作
     * @Author feizi
     * @Date 2016/10/20 14:06
     * @param
     * @return
     */
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if(isEmpty(bytes)){
            return null;
        }

        try {
            return deserializer.convert(bytes);
        } catch (Exception e) {
            throw new SerializationException("Can not deserializer.", e);
        }
    }

    /**
     * @Desc 判空方法
     * @Author feizi
     * @Date 2016/10/20 14:11
     * @param
     * @return
     */
    private boolean isEmpty(byte[] data){
        return (null == data || data.length == 0);
    }
}

/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.exception;

/**
 * @Desc 自定义异常类
 * @Author feizi
 * @Date 2016/10/19 19:15
 * @Package_name com.feizi.exception
 */
public class MyException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MyException(String message) {
        super(message);
    }
}

/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.exception;

import com.feizi.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Desc 全局异常处理Handler
 * @Author feizi
 * @Date 2016/10/19 19:16
 * @Package_name com.feizi.exception
 */
@ControllerAdvice //通过使用@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义。
public class GlobalExceptionHandler {

    //@ExceptionHandler用来定义函数针对的异常类型
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody //处理返回json格式
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception{
        ErrorInfo<String> errorInfo = new ErrorInfo<String>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData("Some Data");
        errorInfo.setUrl(req.getRequestURL().toString());
        return errorInfo;
    }
}

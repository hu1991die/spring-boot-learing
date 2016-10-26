/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.aspect;

import com.mongodb.BasicDBObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc controller层日志切面
 * @Author feizi
 * @Date 2016/10/26 13:42
 * @Package_name com.feizi.aspect
 */
@Aspect
@Order(1)
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger("mongodb");

    @Pointcut("execution(public * com.feizi.controller..*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        //获取HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //获取要记录的日志内容
        BasicDBObject logInfo = getBasicDBObject(request, joinPoint);
        logger.info(logInfo);
    }

    private BasicDBObject getBasicDBObject(HttpServletRequest request, JoinPoint joinPoint){
        //基本信息
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.append("resuestURL", request.getRequestURL().toString());
        dbObject.append("requestURI", request.getRequestURI());
        dbObject.append("queryString", request.getQueryString());
        dbObject.append("remoteAddr", request.getRemoteAddr());
        dbObject.append("remoteHost", request.getRemoteHost());
        dbObject.append("remotePort", request.getRemotePort());
        dbObject.append("localAddr", request.getLocalAddr());
        dbObject.append("localName", request.getLocalName());
        dbObject.append("method", request.getMethod());
        dbObject.append("headers", getHeadersInfo(request));
        dbObject.append("parameters", request.getParameterMap());
        dbObject.append("classMethod", joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());
        dbObject.append("args", Arrays.toString(joinPoint.getArgs()));
        return dbObject;
    }

    private Map<String, Object> getHeadersInfo(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}

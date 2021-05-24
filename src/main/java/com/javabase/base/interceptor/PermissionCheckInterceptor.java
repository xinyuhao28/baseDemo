package com.javabase.base.interceptor;

import lombok.extern.slf4j.Slf4j;


import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class PermissionCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("execute LoginCheckHandlerInterceptor's preHandle method");

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        PermissionCheck permission = findPermissionCheck(handlerMethod);

        //如果没有添加权限注解则直接跳过允许访问
        if (permission == null) {
            return true;
        }

        //获取注解中的值
        String resourceKey = permission.resourceKey();

        //TODO 权限校验一般需要获取用户信息，通过查询数据库进行权限校验
        //TODO 这里只进行简单演示，如果resourceKey为testKey则校验通过，否则不通过
        if ("testKey".equals(resourceKey)) {
            return true;
        }

        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("execute LoginCheckHandlerInterceptor's postHandle method");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("execute LoginCheckHandlerInterceptor's afterCompletion method");
    }
    /**
     * 根据handlerMethod返回注解信息
     *
     * @param handlerMethod 方法对象
     * @return PermissionCheck注解
     */
    private PermissionCheck findPermissionCheck(HandlerMethod handlerMethod) {
        //在方法上寻找注解
        log.info("--------"+handlerMethod);
        PermissionCheck permission = handlerMethod.getMethodAnnotation(PermissionCheck.class);
        if (permission == null) {
            //在类上寻找注解
            permission = handlerMethod.getBeanType().getAnnotation(PermissionCheck.class);
        }

        return permission;
    }
}

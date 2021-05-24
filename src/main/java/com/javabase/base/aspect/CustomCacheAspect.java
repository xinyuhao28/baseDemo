package com.javabase.base.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CustomCacheAspect {
    //com.javabase.base.controler 包中所有的类的所有方法切面
//@Pointcut("execution(public * com.javabase.base.controler.*.*(..))")

//只针对 MessageController 类切面
//@Pointcut("execution(public * com.javabase.base.controler.ValidControl.*(..))")

 /*   //统一切点,对com.javabase.base.controler.ValidControl及其子包中所有的类的所有方法切面
    @Pointcut("execution(public * com.javabase.base.controler.ValidControl.h2(..))")
    public void Pointcut() {
    }

    //前置通知
    @Before("Pointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        log.info("调用了前置通知");

    }

    //@After: 后置通知
    @After("Pointcut()")
    public void afterMethod(JoinPoint joinPoint) {
        log.info("调用了后置通知");
    }

    //@AfterRunning: 返回通知 rsult为返回内容
    @AfterReturning(value = "Pointcut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        log.info("调用了返回通知");
    }

    //@AfterThrowing: 异常通知
    @AfterThrowing(value = "Pointcut()", throwing = "e")
    public void afterReturningMethod(JoinPoint joinPoint, Exception e) {
        log.info("调用了异常通知");
    }*/

    //@Around：环绕通知
    //@Around("Pointcut()")
    @Around("@annotation(com.javabase.base.aspect.CustomCache) && @annotation(customCache)")
    public Object Around(ProceedingJoinPoint pjp, CustomCache customCache) throws Throwable {
        Object result = null;
        if (customCache.key() == null) {
            //TODO throw error
        }
        if ("testKey".equals(customCache.key())) {
            log.info("around：" + customCache.key());
        }

        log.info("around执行方法之前");

        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("around执行方法之后--返回值：" + result);

        return result;
    }
}

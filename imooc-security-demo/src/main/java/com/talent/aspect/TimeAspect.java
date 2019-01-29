package com.talent.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author guobing
 * @Title: TimeAspect
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/1/29下午2:05
 */
@Aspect
@Component
public class TimeAspect {

    /**
     * aop 环绕模式
     * @param pjp
     * @return
     */
    @Around("execution(* com.talent.controller.*.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        System.out.println("time aspect start...");
        try {
            Object proceed = pjp.proceed();
            Object[] args = pjp.getArgs();
            for (Object arg : args) {
                System.out.println("arg is " + arg);
            }
            System.out.println("---------" + pjp.getKind());
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("time aspect finish...");
        return null;
    }
}

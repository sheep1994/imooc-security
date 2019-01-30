package com.talent.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author guobing
 * @Title: TimeAspect
 * @ProjectName spring-security
 * @Description: Spring aop 切片
 * @date 2019/1/29下午2:05
 */
@Aspect
@Component
public class TimeAspect {

    private static final Logger logger = LoggerFactory.getLogger(TimeAspect.class);

    /**
     * aop 环绕模式
     * @param pjp
     * @return
     */
    @Around("execution(* com.talent.controller.*.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        logger.info("time aspect start...");
        try {
            Object proceed = pjp.proceed();
            Object[] args = pjp.getArgs();
            for (Object arg : args) {
                logger.info("arg is 【{}】", arg);
            }
            logger.info("pjp is kind : 【{}】", pjp.getKind());
            return proceed;
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage());
        }
        logger.info("time aspect finish...");
        return null;
    }
}

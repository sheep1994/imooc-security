package com.talent.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guobing
 * @Title: TimeInterceptor
 * @ProjectName spring-security
 * @Description: 拦截器
 * @date 2019/1/29上午11:44
 */
public class TimeInterceptor implements HandlerInterceptor {

    private static final Logger looger = LoggerFactory.getLogger(TimeInterceptor.class);
    /**
     * 控制器方法调用前被调用
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        looger.info("preHandle...");
        looger.info("类名称为 【{}】", ((HandlerMethod)o).getBean().getClass().getName());
        looger.info("方法名为 【{}】", ((HandlerMethod) o).getMethod().getName());
        httpServletRequest.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    /**
     * 控制器方法被调用之后被调用，如果控制器方法抛出异常，则该刚发不被执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        looger.info("postHandle...");
    }

    /**
     * 控制器方法被调用之后被调用
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        looger.info("afterCompletion...");
    }
}

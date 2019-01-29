package com.talent.interceptor;

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
        System.out.println("preHandle...");
        System.out.println(((HandlerMethod)o).getBean().getClass().getName());
        System.out.println(((HandlerMethod) o).getMethod().getName());
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
        System.out.println("postHandle...");
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
        System.out.println("afterCompletion...");
    }
}

package com.talent.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author guobing
 * @Title: TimeFilter
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/1/29上午11:28
 */
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("time filter start");
        Long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("time fileter time is " + (System.currentTimeMillis() - start));
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}

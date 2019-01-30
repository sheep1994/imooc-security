package com.talent.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author guobing
 * @Title: TimeFilter
 * @ProjectName spring-security
 * @Description: 过滤器
 * @date 2019/1/29上午11:28
 */
public class TimeFilter implements Filter {

    private static final Logger looger = LoggerFactory.getLogger(TimeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        looger.info("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        looger.info("time filter start...");
        Long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        looger.info("time filter time is 【{}】", (System.currentTimeMillis() - start));
        looger.info("time filter finish...");
    }

    @Override
    public void destroy() {
        looger.info("time filter destroy");
    }
}

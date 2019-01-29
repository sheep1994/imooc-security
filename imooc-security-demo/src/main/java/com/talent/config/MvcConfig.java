package com.talent.config;

import com.talent.interceptor.TimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author guobing
 * @Title: MvcConfig
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/1/29上午11:34
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeInterceptor()).addPathPatterns("/user");
    }
}

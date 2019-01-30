package com.talent.config;

import com.talent.interceptor.TimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author guobing
 * @Title: MvcConfig
 * @ProjectName spring-security
 * @Description: Spring MVC 配置类
 * @date 2019/1/29上午11:34
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 同步注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeInterceptor()).addPathPatterns("/user");
    }

    /**
     * 异步注册拦截器
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        super.configureAsyncSupport(configurer);
    }
}

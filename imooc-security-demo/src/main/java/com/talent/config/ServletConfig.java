package com.talent.config;

import com.talent.filter.TimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author guobing
 * @Title: ServletConfig
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/1/29上午11:36
 */
@Configuration
public class ServletConfig {

    /**
     * 配置过滤器
     */
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new TimeFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/user"));
        return registrationBean;
    }
}

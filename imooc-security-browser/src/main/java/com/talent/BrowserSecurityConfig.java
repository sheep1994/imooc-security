package com.talent;

import com.talent.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author guobing
 * @Title: BrowserSecurityConfig
 * @ProjectName spring-security
 * @Description: 覆盖security里面的配置
 * @date 2019/1/31上午10:43
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler imoocAuthenticationFailureHandler;

    /**
     * 使用表单登录配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 基于表单登录
        http.formLogin()
            // 配置登录页面,跳转到自定义的controller方法中
            .loginPage("/authentication/require")
            // form表单中action路径的配置，因为Spring Security中的UsernamePasswordAuthenticationFilter中默认处理的是/login登录请求
            .loginProcessingUrl("/authentication/form")
            // 自定义登录成功后逻辑处理
            .successHandler(imoocAuthenticationSuccessHandler)
            // 自定义登录失败后逻辑处理
            .failureHandler(imoocAuthenticationFailureHandler)
        // 使用默认方式登录
        //http.httpBasic()
            .and()
            // 对请求的授权
            .authorizeRequests()
            // 当访问登录页面时不需要身份验证
            .antMatchers("/authentication/require",
                    securityProperties.getBrowser().getLoginPage()).permitAll()
            // 对任何请求
            .anyRequest()
            // 都需要身份认证
            .authenticated()
            .and()
            // 禁止csrf攻击起作用
            .csrf().disable();
    }

    /**
     * 密码加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

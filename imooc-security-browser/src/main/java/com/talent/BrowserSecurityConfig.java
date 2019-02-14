package com.talent;

import com.talent.properties.SecurityProperties;
import com.talent.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService myUserDetailsService;

    /**
     * 使用表单登录配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        // 调初始化bean的方法
        validateCodeFilter.afterPropertiesSet();

        // 基于表单登录，在UsernamePasswordAuthenticationFilter过滤器之前添加自定义的过滤器
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
            .formLogin()
            // 配置登录页面,跳转到自定义的controller方法中
            .loginPage("/authentication/require")
            // form表单中action路径的配置，因为Spring Security中的UsernamePasswordAuthenticationFilter中默认处理的是/login登录请求
            .loginProcessingUrl("/authentication/form")
            // 自定义登录成功后逻辑处理
            .successHandler(imoocAuthenticationSuccessHandler)
            // 自定义登录失败后逻辑处理
            .failureHandler(imoocAuthenticationFailureHandler)
            .and()
            .rememberMe()
                // tokenRepository配置
                .tokenRepository(persistentTokenRepository())
                // 记住我过期时间
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(myUserDetailsService)
        // 使用默认方式登录
        //http.httpBasic()
            .and()
            // 对请求的授权
            .authorizeRequests()
            // 当访问登录页面时不需要身份验证
            .antMatchers("/authentication/require",
                    securityProperties.getBrowser().getLoginPage(),
                    "/code/image").permitAll()
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

    /**
     * 配置记住我功能
     * @return
     *
     * 在系统启动的时候，会自动创建这张表，只需要写一次
     *  tokenRepository.setCreateTableOnStartup(true);
     *
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

}

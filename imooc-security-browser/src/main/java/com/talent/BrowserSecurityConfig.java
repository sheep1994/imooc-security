package com.talent;

import com.talent.authentication.AbstractChannelSecurityConfig;
import com.talent.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.talent.properties.SecurityConstants;
import com.talent.properties.SecurityProperties;
import com.talent.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
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
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler imoocAuthenticationFailureHandler;

    /**
     * 图片验证码过滤器配置
     */
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    /**
     * 短信过滤器配置
     */
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 使用表单登录配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 在外部实现密码认证登录
        applyPasswordAuthenticationConfig(http);

        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
            .and()
            .rememberMe()
                // tokenRepository配置
                .tokenRepository(persistentTokenRepository())
                // 记住我过期时间
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
        // 使用默认方式登录
        //http.httpBasic()
            .and()
            // 对请求的授权
            .authorizeRequests()
            // 当访问登录页面时不需要身份验证
            .antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                    SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                    securityProperties.getBrowser().getLoginPage(),
                    SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*").permitAll()
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

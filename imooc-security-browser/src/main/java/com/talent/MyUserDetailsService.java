package com.talent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author guobing
 * @Title: MyUserDetailService
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/13上午10:49
 */
@Component("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger looger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        looger.info("username : 【{}】", username);
        // Spring Security提供的User对象实现了UserDetails接口，根据查找到的用户信息判断用户是否被冻结
        String password = passwordEncoder.encode("123456");
        looger.info("password : 【{}】", password);
        return new User(username, passwordEncoder.encode("123456"), true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}

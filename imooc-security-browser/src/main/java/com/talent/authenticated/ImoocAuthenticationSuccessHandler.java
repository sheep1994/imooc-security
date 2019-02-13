package com.talent.authenticated;

import com.alibaba.fastjson.JSON;
import com.talent.properties.LoginType;
import com.talent.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author guobing
 * @Title: ImoocAuthenticationSuccessHandler
 * @ProjectName spring-security
 * @Description: 自定义登录成功页面处理逻辑
 * @date 2019/2/13下午4:00
 */
@Component
public class ImoocAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(ImoocAuthenticationSuccessHandler.class);

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
              Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功");
        // 如果是JSON，使用我们自己的方式
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(authentication));
        } else {
            // 不是JSON，调用父类的默认方式，返回html
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}

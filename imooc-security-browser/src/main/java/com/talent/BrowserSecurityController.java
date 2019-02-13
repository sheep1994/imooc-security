package com.talent;

import com.talent.properties.SecurityProperties;
import com.talent.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author guobing
 * @Title: BrowserSecurityController
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/13下午2:42
 */
@RestController
public class BrowserSecurityController {

    private static final Logger logger = LoggerFactory.getLogger(BrowserSecurityController.class);
    /**
     * 是否需要身份认证，是Spring Security自己做的判断，需要认证，就会跳到登录页面，在此之前会将信息缓存到session中
     */
    private RequestCache requestCache = new HttpSessionRequestCache();

    /**
     * 重定向工具
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当需要身份认证时，跳转到这个方法中
     * @param request
     * @param response
     * @return
     * HttpStatus.UNAUTHORIZED：返回401状态码错误
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取到之前缓存的请求
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (Objects.nonNull(savedRequest)) {
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是 【{}】", targetUrl);
            // 引发跳转的请求是不是以.html结尾的
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                logger.info("登录页名为 ：【{}】", securityProperties.getBrowser().getLoginPage());
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页面");
    }
}

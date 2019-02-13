package com.talent.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author guobing
 * @Title: SecurityProperties
 * @ProjectName spring-security
 * @Description: 配置类
 * @date 2019/2/13下午3:07
 */
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}

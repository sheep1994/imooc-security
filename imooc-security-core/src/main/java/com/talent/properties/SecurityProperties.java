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

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}

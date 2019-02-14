package com.talent.properties;

/**
 * @author guobing
 * @Title: BrowserProperties
 * @ProjectName spring-security
 * @Description: 浏览器配置类
 * @date 2019/2/13下午3:08
 */
public class BrowserProperties {

    /**
     * 注意一下! 需要加/
     */
    private String loginPage = "/imooc-signIn.html";

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}

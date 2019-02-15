package com.talent.properties;

/**
 * @author guobing
 * @Title: SmsCodeProperties
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/14下午6:08
 */
public class SmsCodeProperties {

    /**
     * 验证码个数
     */
    private int length = 6;

    /**
     * 过期时间
     */
    private int expireIn = 60;

    /**
     * 过滤器可以过滤多个url
     */
    private String url;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

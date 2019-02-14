package com.talent.properties;

/**
 * @author guobing
 * @Title: ImageCodeProperties
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/14下午2:03
 */
public class ImageCodeProperties {

    /**
     * 验证码的宽度
     */
    private int width = 67;

    /**
     * 验证码的高度
     */
    private int height = 23;

    /**
     * 验证码的个数
     */
    private int length = 4;

    /**
     * 验证码的失效时间
     */
    private int expireIn = 60;

    /**
     * 过滤器可以过滤多个url
     */
    private String url;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

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

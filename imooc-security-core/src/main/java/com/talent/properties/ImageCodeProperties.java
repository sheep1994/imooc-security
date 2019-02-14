package com.talent.properties;

/**
 * @author guobing
 * @Title: ImageCodeProperties
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/14下午2:03
 */
public class ImageCodeProperties extends SmsCodeProperties {

    /**
     * 验证码的宽度
     */
    private int width = 67;

    /**
     * 验证码的高度
     */
    private int height = 23;

    /**
     * 过滤器可以过滤多个url
     */
    private String url;

    public ImageCodeProperties() {
        setLength(4);
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.talent.properties;

/**
 * @author guobing
 * @Title: ValidateCodeProperties
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/14下午2:05
 */
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}

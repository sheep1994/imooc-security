package com.talent.validate.code;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author guobing
 * @Title: SmsCode
 * @ProjectName spring-security
 * @Description: 短信验证码类
 * @date 2019/2/14下午5:44
 */
public class ValidateCode implements Serializable {

    /**
     * 短信：短信验证码
     * 图片：图片随机数
     * 随机数，需要存储到session中的
     */
    private String code;

    /**
     * 失效时间
     */
    private LocalDateTime expireTime;

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}

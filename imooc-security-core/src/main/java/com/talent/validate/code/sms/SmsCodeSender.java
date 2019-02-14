package com.talent.validate.code.sms;

/**
 * @author guobing
 * @Title: SmsCodeSender
 * @ProjectName spring-security
 * @Description: 短信验证码发送器
 * @date 2019/2/14下午5:56
 */
public interface SmsCodeSender {

    /**
     * 短信发送接口
     * @param mobile
     * @param code
     */
    void send(String mobile, String code);

}

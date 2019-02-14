package com.talent.validate.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author guobing
 * @Title: DefaultSmsCodeSender
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/14下午5:57
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    private static final Logger logger = LoggerFactory.getLogger(DefaultSmsCodeSender.class);

    @Override
    public void send(String mobile, String code) {
        logger.info("向手机【{}】发送验证码【{}】", mobile, code);
    }
}

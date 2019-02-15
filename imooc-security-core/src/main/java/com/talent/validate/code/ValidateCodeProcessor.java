package com.talent.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author guobing
 * @Title: ValidateCodeProcessor
 * @ProjectName spring-security
 * @Description: 校验码处理器，封装不同校验码的处理器
 * @date 2019/2/15上午11:50
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建验证码
     * @param request: ServletWebRequest是Spring提供的一个工具类
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     * @param request
     * @throws Exception
     */
    void validate(ServletWebRequest request);
}

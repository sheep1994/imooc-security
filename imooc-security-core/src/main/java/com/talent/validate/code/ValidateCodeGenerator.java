package com.talent.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author guobing
 * @Title: ValidateCodeGenerator
 * @ProjectName spring-security
 * @Description: 校验码的生成器
 * @date 2019/2/14下午2:49
 */
public interface ValidateCodeGenerator {

    /**
     * 验证码的生成逻辑
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);
}

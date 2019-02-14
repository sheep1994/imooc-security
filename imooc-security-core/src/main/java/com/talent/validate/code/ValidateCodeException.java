package com.talent.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author guobing
 * @Title: ValidateCodeException
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/14上午11:30
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}

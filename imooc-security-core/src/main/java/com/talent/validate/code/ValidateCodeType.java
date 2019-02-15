package com.talent.validate.code;

import com.talent.properties.SecurityConstants;

/**
 * @author guobing
 * @Title: ValidateCodeType
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/15下午12:52
 */
public enum ValidateCodeType {

    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNamOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },

    /**
     * 图形验证码
     */
    IMAGE {
        @Override
        public String getParamNamOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取参数的名字
     * @return
     */
    public abstract String getParamNamOnValidate();
}

package com.talent.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author guobing
 * @Title: ValidateCodeProcessorHolder
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/15下午5:25
 */
@Component
public class ValidateCodeProcessorHolder {

    /**
     * Spring 依赖查找，在系统启动的时候，收集系统中所有 {@link ValidateCodeProcessor} 接口的实现
     */
    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (Objects.isNull(processor)) {
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }
}

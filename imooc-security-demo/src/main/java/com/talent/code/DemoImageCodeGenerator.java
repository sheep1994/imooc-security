package com.talent.code;

import com.talent.validate.code.image.ImageCode;
import com.talent.validate.code.ValidateCodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author guobing
 * @Title: DemoImageCodeGenerator
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/14下午3:18
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    private static final Logger logger = LoggerFactory.getLogger(DemoImageCodeGenerator.class);

    @Override
    public ImageCode generate(ServletWebRequest request) {
        logger.info("更高级的验证码");
        return null;
    }
}

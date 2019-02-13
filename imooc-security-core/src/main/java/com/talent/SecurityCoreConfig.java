package com.talent;

import com.talent.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author guobing
 * @Title: SecurityCoreConfig
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/13下午3:11
 * @EnableConfigurationProperties(SecurityProperties.class): 启动指定类的配置功能
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}

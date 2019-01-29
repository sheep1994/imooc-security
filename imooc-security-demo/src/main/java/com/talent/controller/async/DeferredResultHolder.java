package com.talent.controller.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guobing
 * @Title: DeferredResultHolder
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/1/29下午5:25
 */
@Component
public class DeferredResultHolder {

    /**
     * DeferredResult<String>存放的是处理结果
     */
    private Map<String, DeferredResult<String>> map = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}

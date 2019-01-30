package com.talent.controller.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author guobing
 * @Title: MockQueue
 * @ProjectName spring-security
 * @Description: 模拟消息队列
 * @date 2019/1/29下午5:21
 */
@Component
public class MockQueue {

    private static final Logger logger = LoggerFactory.getLogger(MockQueue.class);

    /**
     * 下单消息
     */
    private String placeOrder;

    /**
     * 下单完成消息
     */
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) {
        new Thread(() -> {
            logger.info("接到下单请求");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完毕, placeOrder : []", placeOrder);
        }).start();
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}

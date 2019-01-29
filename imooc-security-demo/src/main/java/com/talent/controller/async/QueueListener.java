package com.talent.controller.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author guobing
 * @Title: QueueListener
 * @ProjectName spring-security
 * @Description: 队列监听器
 * @date 2019/1/29下午5:35
 * ApplicationListener<ContextRefreshedEvent>: Spring容器初始化完毕的一个事件
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        new Thread(() -> {
            while (true) {
                // 当completeOrder字段有值了，就表明订单处理完成
                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {
                    String orderId = mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果" + orderId);
                    deferredResultHolder.getMap().get(orderId).setResult("place order success");
                    mockQueue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

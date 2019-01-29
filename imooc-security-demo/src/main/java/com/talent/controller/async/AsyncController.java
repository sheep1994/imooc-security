package com.talent.controller.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @author guobing
 * @Title: AsyncController
 * @ProjectName spring-security
 * @Description: 异步处理
 * @date 2019/1/29下午4:47
 */
@RestController
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    /**
     * 使用Callable<V>来进行异步处理
     * @return
     */
    @GetMapping("/order")
    public Callable<String> order() {
        logger.info("主线程开始");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程返回");
                return "success";
            }
        };
        logger.info("主线程返回");
        return result;
    }

    /**
     * 使用DeferredResult进行异步处理
     */
    @GetMapping("/order1")
    public DeferredResult<String> order1() {
        logger.info("主线程开始");
        // 生成订单号
        String orderId = UUID.randomUUID().toString();
        // 放到消息队列中
        mockQueue.setPlaceOrder(orderId);

        // 存放处理结果
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderId, result);

        logger.info("主线程返回");
        return result;
    }
}

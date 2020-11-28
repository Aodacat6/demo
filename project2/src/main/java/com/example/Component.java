package com.example;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：songdalin
 * @date ：2020-11-05 下午 02:56
 * @description：
 * @modified By：
 * @version: 1.0
 */

@org.springframework.stereotype.Component
@EnableAsync
public class Component {

    @EventListener(condition = "#s != null")
    @Async
    public synchronized void handleEvnet(String s) throws InterruptedException {
        //Thread.sleep(10000);
        wait(1000);
        System.out.println("============收到消息："+s+"=========");
    }


}

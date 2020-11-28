package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author ：songdalin
 * @date ：2020-11-05 下午 02:47
 * @description：
 * @modified By：
 * @version: 1.0
 */
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void register() {
        String a = "==============aaaaaaaaaaaaaaaaaaaa===========";
        try {
            publisher.publishEvent(a);

        }catch (Exception e){

        }
        System.out.println("发布完成");
    }
}

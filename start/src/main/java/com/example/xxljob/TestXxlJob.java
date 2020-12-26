package com.example.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ：songdalin
 * @date ：2020-12-26 下午 04:20
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
@Slf4j
public class TestXxlJob {

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @XxlJob(value = "helloXxlJob", init = "init", destroy = "destroy")
    public ReturnT<String> execute(String param) {
        System.out.println("======执行xxljob===,输入：" + param);
        System.out.println("threadlocal:" + threadLocal.get());
        return ReturnT.SUCCESS;
    }

    public void init() {
        threadLocal.set("hello");
        System.out.println("======执行init方法=====");
    }

    public void destroy() {
        threadLocal.remove();
        System.out.println("======执行destroy方法=====");
    }
}

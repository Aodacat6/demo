package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：songdalin
 * @date ：2020-12-30 下午 02:52
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/scan/{key}")
    public String scantest (@PathVariable("key") String key) {
        return redisUtils.keys(key).toString();
    }
}

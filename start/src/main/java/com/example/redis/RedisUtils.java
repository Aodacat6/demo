package com.example.redis;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ：damiaokuaipao
 * @date ：Created in 2020-02-12 下午 09:57
 * @description：redis测试
 * @modified By：
 * @version: $
 */
@Component
@Slf4j
public class RedisUtils {

    /*
    private RedisUtils(){

    }
   */
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public boolean set(String key, Object value){
        boolean b = false;
        try {
            redisTemplate.opsForValue().set(key,value);
            b = true;
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return b;
    }

    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public boolean setExpire(String key, long time){
        if (time > 0){
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
        return true;
    }

    public boolean hasKey(String key){
        boolean hasKey = false;
        if (redisTemplate != null){
            try {
                hasKey = redisTemplate.hasKey(key);
            }catch (Exception e){
            }
        }
        return hasKey;
    }

    /**
     * 设置有过期时间的key
     * @param key
     * @param value
     * @return
     */
    public boolean setandExpire(String key, Object value, long time){
        boolean b = false;
        try {
            redisTemplate.opsForValue().set(key,value);
            b = setExpire(key, time);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return b;
    }

}

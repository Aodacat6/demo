package com.example.redis;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
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

    /**
     *  获取指定前缀的一系列key
     *  使用scan命令代替keys, Redis是单线程处理，keys命令在KEY数量较多时，
     *  操作效率极低【时间复杂度为O(N)】，该命令一旦执行会严重阻塞线上其它命令的正常请求
     * @param keyPrefix
     * @return
     */
    public Set<String> keys(String keyPrefix) {
        String realKey = "*" + keyPrefix + "*";
        try {
            return redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
                Set<String> binaryKeys = new HashSet<>();
                Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match(realKey).count(Integer.MAX_VALUE).build());
                while (cursor.hasNext()) {
                    binaryKeys.add(new String(cursor.next()));
                }
                return binaryKeys;
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

}

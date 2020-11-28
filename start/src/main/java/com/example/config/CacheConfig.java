package com.example.config;

import com.example.entity.Student;
import com.example.springcache.CacheService;
import com.example.springcache.ReloadMethods;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author ：songdalin
 * @date ：2020-11-18 下午 09:53
 * @description：caffenine缓存配置
 *                代替了配置文件中的配置
 * @modified By：
 * @version: 1.0*/
@Slf4j
@Configuration
public class CacheConfig {

    @Autowired
    private CacheService cacheService;

    @Bean("caffeineCacheManager")
    public CacheManager cacheManager (CacheLoader<Object, Object> cacheLoader) {

        //定义caffeineCache
        LoadingCache<Object, Object> myCache = Caffeine.newBuilder()
                //请求刷新，如果到期了，新的请求会到cacheloader里刷新
                .refreshAfterWrite(10, TimeUnit.SECONDS)
                //自动过期，刷新时间要比过期时间小
                .expireAfterAccess(20, TimeUnit.MINUTES)
                .build(cacheLoader);

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(new CaffeineCache("studentByNo", myCache)));
        return simpleCacheManager;
    }


    /**
     * 必须要指定这个Bean，refreshAfterWrite=这个配置属性才生效
     *
     * @return
     */
    @Bean("cacheLoader")
    public CacheLoader<Object, Object> cacheLoader() {

        CacheLoader<Object, Object> cacheLoader = new CacheLoader<Object, Object>() {

            @Override
            public Object load(Object key) throws Exception {
                log.info("进入load方法，key:{}", key);
                return null;
            }

            // 重写这个方法将oldValue值返回回去，进而刷新缓存
            @Override
            public Object reload(Object key, Object oldValue) throws Exception {
                log.info("进入reload方法，key:{}, oddValue:{}", key, oldValue);
/*                if ("1".equals(String.valueOf(key))) {
                    Student student = (Student)oldValue;
                    student.setName("tom");
                    return student;
                }*/
                return oldValue;
            }
        };

        return cacheLoader;
    }
}

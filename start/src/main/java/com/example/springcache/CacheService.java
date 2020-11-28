package com.example.springcache;

import com.example.entity.Student;

/**
 * @author ：songdalin
 * @date ：2020-11-19 下午 02:36
 * @description：
 * @modified By：
 * @version: 1.0
 */
public interface CacheService {

    Student findByNo (Integer no);

    Student add(Integer no);

    Student update(Integer no);

    void delete(Integer no);
}

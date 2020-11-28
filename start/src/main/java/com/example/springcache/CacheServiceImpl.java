package com.example.springcache;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：songdalin
 * @date ：2020-11-17 下午 09:30
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
@CacheConfig(cacheNames = "studentByNo")
public class CacheServiceImpl implements CacheService {

    @Autowired
    private StudentRepository repository;

    @Override
    @Cacheable(key = "#no")
    @ReloadMethods(reloadMethods = {
        @ReloadMethod(methodName = "findByNo")
    })
    public Student findByNo (Integer no) {
        System.out.println("==进入查询方法了===");
        return repository.findByNo(no);
    }

    @Override
    @CachePut(key = "#result.no")
    public Student add(Integer no) {
        Student student = new Student();
        student.setNo(no);
        student.setName(String.valueOf(no));
        return repository.save(student);
    }

    @Override
    @CachePut(key = "#result.no")
    public Student update(Integer no) {
        Student student = repository.findByNo(no);
        student.setName("tom");
        return repository.save(student);
    }

    @Override
    //会将对应key对应的的缓存删除
    @CacheEvict(key = "#no")
    //下面这个会删除所有的缓存
    //@CacheEvict(value = "studentByNo", allEntries = true)
    public void delete(Integer no) {
        repository.deleteByNo(no);
    }


}

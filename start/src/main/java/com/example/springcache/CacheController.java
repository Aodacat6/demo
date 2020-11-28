package com.example.springcache;

import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：songdalin
 * @date ：2020-11-17 下午 09:30
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/{no}")
    public Student getByNo(@PathVariable("no") Integer no) {
        return cacheService.findByNo(no);
    }

    @GetMapping("/add/{no}")
    public void add(@PathVariable("no") Integer no) {
        cacheService.add(no);
    }

    @GetMapping("/update/{id}")
    public void update(@PathVariable("id") Integer id) {
        cacheService.update(id);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        cacheService.delete(id);
    }


}

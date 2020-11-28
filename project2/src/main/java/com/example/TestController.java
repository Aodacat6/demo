package com.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：songdalin
 * @date ：2020-11-05 下午 01:34
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "ok";
    }
}

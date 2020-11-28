package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：songdalin
 * @date ：2020-11-05 下午 02:46
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/event")
    public String test () {
        service.register();
        return "ok";
    }


}

package com.example.twoInterfaceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：songdalin
 * @date ：2020-11-20 下午 04:35
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/two")
public class GetController {

    //@Resource(name = "twoImplOne")
    @Autowired
    @Qualifier(value = "twoImplTwo")
    private TwoImplInterface implInterface;

    @GetMapping
    public String gettest () {
        return implInterface.twoImpl();
    }
}

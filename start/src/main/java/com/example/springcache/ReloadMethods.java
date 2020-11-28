package com.example.springcache;

import java.lang.annotation.*;

/**
 * @author ：songdalin
 * @date ：2020-11-24 上午 10:24
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReloadMethods {

    ReloadMethod[] reloadMethods();
}

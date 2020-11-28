package com.example.twoInterfaceImpl;

import org.springframework.stereotype.Service;

/**
 * @author ：songdalin
 * @date ：2020-11-20 下午 04:37
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service("twoImplTwo")
public class TwoImplSecond implements TwoImplInterface {
    @Override
    public String twoImpl() {
        return "2";
    }
}

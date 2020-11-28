package com.example.twoInterfaceImpl;

import org.springframework.stereotype.Service;

/**
 * @author ：songdalin
 * @date ：2020-11-20 下午 04:36
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service("twoImplOne")
public class TwoImpl implements TwoImplInterface {
    @Override
    public String twoImpl() {
        return "1";
    }
}

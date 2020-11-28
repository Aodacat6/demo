package com.example.testDUMP;

import com.example.entity.Student;
import com.example.twoInterfaceImpl.TwoImplInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：songdalin
 * @date ：2020-11-20 下午 04:35
 * @description：
 * @modified By：
 * @version: 1.0
 */
class OOM {
    static final int SIZE=2*1024*1024;
    public static void main(String[] a) {
        int[] i = new int[SIZE];
    }
}

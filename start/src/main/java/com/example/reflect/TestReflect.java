package com.example.reflect;

import com.example.entity.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author ：songdalin
 * @date ：2020-11-24 上午 09:47
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class TestReflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("com.example.entity.Student");
        Student stuendt = (Student) clazz.newInstance();
        stuendt.setId(1);
        stuendt.setName("tom");
        System.out.println(stuendt);
        Method[] methods = clazz.getDeclaredMethods();
        for (Method me : methods) {
            if (Objects.equals(me.getName(), "outName")) {
                testMethod(me, stuendt);
            }

        }
    }

    public static void testMethod(Method method, Student obj) throws InvocationTargetException, IllegalAccessException {
        String name = (String) method.invoke(obj);
        System.out.println("======getname:="+name+"=====");
    }
}

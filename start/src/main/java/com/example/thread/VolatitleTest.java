package com.example.thread;

/**
 * @author ：songdalin
 * @date ：2021-01-27 下午 02:42
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class VolatitleTest {

    static volatile int a = 0;

    public static void main(String[] args){
        Thread thread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                a++;
                System.out.println(a);
            }
        });
        thread.start();
        while (true) {
            if (a == 100){
                System.out.println("========");
                System.exit(0);
            }
        }
    }
}

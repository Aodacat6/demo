package com.example.thread;

/**
 * @author ：songdalin
 * @date ：2021-01-26 下午 06:42
 * @description：模型
 * @modified By：
 * @version: 1.0
 */
public class ProductModel {

    /**
     *
     * 多线程测试学习
     * volatile
     * synchronized
     */
    static Object ob = new Object();
    static int a = 0;


    static int adda(){

        synchronized(ob) {
            a++;
        }
        return a;
    }

    public static void main(String[] args){

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                int a = adda();
                System.out.println("1======"+a);
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                int a = adda();
                System.out.println("2======"+a);
            }
        });


        thread1.start();
        thread2.start();

    }
}

package com.example.thread;

import lombok.SneakyThrows;

import java.util.function.Predicate;

/**
 * @author ：songdalin
 * @date ：2021-01-27 下午 03:43
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class NotifyTest {

    static volatile int num = 0;

    static Object lock = new Object();


    public static void main(String[] args){

        Thread thread1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (lock){
                    if (num > 0) {
                        lock.wait();
                    }else {
                            num++;
                            System.out.println("生产了一个面包,库存："+ num);
                            lock.notify();

                    }
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (lock) {
                    if (num > 0) {
                            num--;
                            System.out.println("消费了一个面包,库存："+ num);
                            lock.wait();

                    }else {
                        lock.notify();
                    }
                }


                }

        });

        thread1.start();
        thread2.start();

    }
}

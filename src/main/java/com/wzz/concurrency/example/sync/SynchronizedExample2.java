package com.wzz.concurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SynchronizedExample1
 *
 * @author wzzfarewell
 * @date 2019/9/30
 **/
public class SynchronizedExample2 {

    /**
     * 修饰一个类
     **/
    public static void test1(int j){
        synchronized (SynchronizedExample2.class){
            for (int i = 0; i < 10; i++) {
                System.out.println(String.format("test1(%d): %d", j, i));
            }
        }
    }

    /**
     * 修饰一个静态方法
     **/
    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("test2(%d): %d", j, i));
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(() -> {
            example1.test2(1);
        });
        pool.execute(() -> {
            example2.test2(2);
        });
        pool.shutdown();
    }
}

package com.wzz.concurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SynchronizedExample1
 *
 * @author wzzfarewell
 * @date 2019/9/30
 **/
public class SynchronizedExample1 {

    /**
     * 修饰一个代码块
     **/
    public void test1(int j){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println(String.format("test1(%d): %d", j, i));
            }
        }
    }

    /**
     * 修饰一个方法
     **/
    public synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("test2(%d): %d", j, i));
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(() -> {
            example1.test1(1);
        });
        pool.execute(() -> {
            example2.test1(2);
        });
        pool.shutdown();
    }
}

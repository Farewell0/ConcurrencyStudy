package com.wzz.concurrency.example.singleton;

import com.wzz.concurrency.annotations.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingletonExample1
 * 单例模式：静态内部类
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@ThreadSafe
public class SingletonExample8 {

    private SingletonExample8(){

    }

    public static SingletonExample8 getInstance(){
        return InnerClass.instance;
    }

    private static class InnerClass{
        private static SingletonExample8 instance = new SingletonExample8();
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                System.out.println(SingletonExample8.getInstance().hashCode());
            });
        }
        pool.shutdown();
    }
}

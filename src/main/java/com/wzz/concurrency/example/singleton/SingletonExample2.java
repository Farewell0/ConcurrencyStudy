package com.wzz.concurrency.example.singleton;

import com.wzz.concurrency.annotations.ThreadSafe;

/**
 * SingletonExample1
 * 单例模式：饿汉模式
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2(){

    }

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance(){
        return instance;
    }
}

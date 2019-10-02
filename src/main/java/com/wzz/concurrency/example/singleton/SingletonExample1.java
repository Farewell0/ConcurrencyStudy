package com.wzz.concurrency.example.singleton;

import com.wzz.concurrency.annotations.NotThreadSafe;

/**
 * SingletonExample1
 * 单例模式：懒汉模式
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@NotThreadSafe
public class SingletonExample1 {

    private SingletonExample1(){

    }

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}

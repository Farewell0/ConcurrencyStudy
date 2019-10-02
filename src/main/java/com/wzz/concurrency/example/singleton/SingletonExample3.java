package com.wzz.concurrency.example.singleton;

import com.wzz.concurrency.annotations.ThreadSafe;

/**
 * SingletonExample1
 * 单例模式：synchronized版本
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@ThreadSafe
public class SingletonExample3 {

    private SingletonExample3(){

    }

    private static SingletonExample3 instance = null;

    public synchronized static SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}

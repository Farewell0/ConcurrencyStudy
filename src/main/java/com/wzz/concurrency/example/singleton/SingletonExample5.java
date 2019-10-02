package com.wzz.concurrency.example.singleton;


import com.wzz.concurrency.annotations.ThreadSafe;

/**
 * SingletonExample1
 * 单例模式：双重同步锁单例模式
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5(){

    }

    // volatile+双重检测--》禁止指令重排

    private volatile static SingletonExample5 instance = null;

    public static SingletonExample5 getInstance(){
        if(instance == null){
            synchronized (SingletonExample5.class){
                if(instance == null){
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}

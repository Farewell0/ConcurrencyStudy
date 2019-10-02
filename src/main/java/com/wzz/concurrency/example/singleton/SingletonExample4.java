package com.wzz.concurrency.example.singleton;

import com.wzz.concurrency.annotations.NotThreadSafe;

/**
 * SingletonExample1
 * 单例模式：双重同步锁单例模式
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@NotThreadSafe
public class SingletonExample4 {

    private SingletonExample4(){

    }

    private static SingletonExample4 instance = null;

    //1. 分配内存空间
    //2. 初始化对象
    //3. 设置instance指向刚分配的内存
    //JVM和CPU优化，发生指令重排：1-->3-->2

    public static SingletonExample4 getInstance(){
        if(instance == null){
            synchronized (SingletonExample4.class){
                if(instance == null){
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }

}

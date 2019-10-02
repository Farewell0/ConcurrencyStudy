package com.wzz.concurrency.example.singleton;

import com.wzz.concurrency.annotations.NotThreadSafe;

/**
 * SingletonExample1
 * 单例模式：饿汉模式
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@NotThreadSafe
public class SingletonExample6 {

    private SingletonExample6(){

    }

    //静态域的写法要注意顺序
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}

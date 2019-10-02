package com.wzz.concurrency.example.singleton;

import com.wzz.concurrency.annotations.Recommend;
import com.wzz.concurrency.annotations.ThreadSafe;

/**
 * SingletonExample1
 * 单例模式：枚举
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;
        private SingletonExample7 singleton;

        /**
         * JVM保证这个方法绝对只调用一次
         */
        Singleton(){
            singleton = new SingletonExample7();
        }
        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}

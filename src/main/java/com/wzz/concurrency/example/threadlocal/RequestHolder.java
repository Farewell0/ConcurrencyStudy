package com.wzz.concurrency.example.threadlocal;

/**
 * RequestHolder
 *
 * @author wzzfarewell
 * @date 2019/10/1
 **/
public class RequestHolder {
    private final static ThreadLocal<Long> REQUEST_HOLDER = new ThreadLocal<>();

    public static void add(Long id){
        REQUEST_HOLDER.set(id);
    }
    public static Long get(){
        return REQUEST_HOLDER.get();
    }
    public static void remove(){
        REQUEST_HOLDER.remove();
    }
}

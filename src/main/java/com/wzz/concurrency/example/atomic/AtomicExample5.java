package com.wzz.concurrency.example.atomic;

import com.wzz.concurrency.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * ConcurrencyTest
 *
 * @author wzzfarewell
 * @date 2019/9/30
 **/
@ThreadSafe
public class AtomicExample5 {
    // 请求总数
    public static int totalClient = 5000;
    // 同时执行的线程数
    public static int threadLocal = 200;


    private static AtomicBoolean isHappened = new AtomicBoolean();

    private static void test(){
        if(isHappened.compareAndSet(false, true)){
            System.out.println("test方法执行！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadLocal);
        final CountDownLatch latch = new CountDownLatch(totalClient);
        for(int i = 0; i < totalClient; i++){
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
        }
        latch.await();
        executorService.shutdown();
        System.out.println("isHappened: " + isHappened.get());
    }

}

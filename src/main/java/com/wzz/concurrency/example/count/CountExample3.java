package com.wzz.concurrency.example.count;

import com.wzz.concurrency.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * ConcurrencyTest
 *
 * @author wzzfarewell
 * @date 2019/9/30
 **/
@ThreadSafe
public class CountExample3 {

    // 请求总数
    public static int totalClient = 5000;
    // 同时执行的线程数
    public static int threadLocal = 200;
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadLocal);
        final CountDownLatch latch = new CountDownLatch(totalClient);
        for(int i = 0; i < totalClient; i++){
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
        }
        latch.await();
        executorService.shutdown();
        System.out.println("count: " + count);
    }

    private synchronized static void add(){
        count++;
    }

}

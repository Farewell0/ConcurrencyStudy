package com.wzz.concurrency.example.atomic;

import com.wzz.concurrency.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * ConcurrencyTest
 *
 * @author wzzfarewell
 * @date 2019/9/30
 **/
@ThreadSafe
public class AtomicExample3 {

   private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 2);
        count.compareAndSet(0, 1);
        count.compareAndSet(1, 3);
        count.compareAndSet(2, 4);
        count.compareAndSet(3, 5);
        System.out.println(count.get());
    }

}

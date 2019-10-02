package com.wzz.concurrency.example.atomic;

import com.wzz.concurrency.annotations.ThreadSafe;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * ConcurrencyTest
 *
 * @author wzzfarewell
 * @date 2019/9/30
 **/
@ThreadSafe
public class AtomicExample4 {

    private static AtomicIntegerFieldUpdater<AtomicExample4> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample4.class, "count");

    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample4 example4 = new AtomicExample4();
        if(updater.compareAndSet(example4, 100, 120)){
            System.out.println(String.format("update success, %d", example4.getCount()));
        }
        if(updater.compareAndSet(example4, 100, 120)){
            System.out.println(String.format("update success, %d", example4.getCount()));
        }else {
            System.out.println(String.format("update fail, %d", example4.getCount()));
        }
    }

    public int getCount() {
        return count;
    }
}

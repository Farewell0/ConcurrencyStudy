package com.wzz.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.wzz.concurrency.annotations.NotThreadSafe;

import java.util.Map;

/**
 * ImmutableExample1
 *
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@NotThreadSafe
public class ImmutableExample1 {
    private final static int a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
//        a = 2;
//        b = "3";
//        map = Maps.newHashMap();
        map.put(1, 3);
        System.out.println(map.get(1));
    }
}

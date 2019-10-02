package com.wzz.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.wzz.concurrency.annotations.ThreadSafe;

import java.util.Collections;
import java.util.Map;

/**
 * ImmutableExample1
 *
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@ThreadSafe
public class ImmutableExample2 {
    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        System.out.println(map.get(1));
    }
}

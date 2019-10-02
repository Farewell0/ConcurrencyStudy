package com.wzz.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.wzz.concurrency.annotations.ThreadSafe;

/**
 * ImmutableExample1
 *
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@ThreadSafe
public class ImmutableExample3 {
    private final static ImmutableList<Integer> LIST = ImmutableList.of(1, 2, 3);
    private final static ImmutableSet SET = ImmutableSet.copyOf(LIST);
    private final static ImmutableMap<Integer, Integer> MAP = ImmutableMap.of(1,2, 3, 4, 5, 6);
    private final static ImmutableMap<Integer, Integer> MAP2 = ImmutableMap.<Integer, Integer>builder().put(1, 2).build();

    public static void main(String[] args) {
//        LIST.add(4);
        MAP.put(1, 3);
    }
}

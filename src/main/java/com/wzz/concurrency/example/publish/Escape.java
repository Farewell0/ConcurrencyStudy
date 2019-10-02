package com.wzz.concurrency.example.publish;

import com.wzz.concurrency.annotations.NotRecommend;
import com.wzz.concurrency.annotations.NotThreadSafe;

/**
 * Escape
 * 对象溢出
 * @author wzzfarewell
 * @date 2019/10/1
 **/
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;
    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}

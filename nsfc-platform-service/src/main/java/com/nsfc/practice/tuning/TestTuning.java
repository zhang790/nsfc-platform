package com.nsfc.practice.tuning;

/**
 * 关于JVM的调优
 *
 * -Xss  设置栈的大小
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/14
 */
public class TestTuning {

    public static void main(String[] args) {

        /**
         * 一个空对象的大小是8byte（堆）  引用大小是4byte（栈）   总共的大小是12byte
         */
        Object object = new Object();

    }
}

package com.nsfc.practice.rhread.one;

/**
 * 测试One
 *
 * 测试结果 synchronize锁住的是对象而不是代码段  所以减少粒度是最好的事情
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/11
 */
public class TestMainOne {

    public static void main(String[] args) {
        TestThreadOne one = new TestThreadOne();
        for (int i=0; i<3; i++){
            Thread thread = new MyThread(one);
            thread.start();
        }
    }
}

package com.nsfc.practice.rhread.one;

/**
 * 自建线程配合One
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/11
 */
public class MyThread extends Thread{

    private  TestThreadOne one;

    public MyThread(TestThreadOne one) {

        this.one = one;
    }

    @Override
    public void run() {
//        TestThreadOne one = new TestThreadOne(); //使用不同的对象
        one.test();     //使用同一个对象
    }
}

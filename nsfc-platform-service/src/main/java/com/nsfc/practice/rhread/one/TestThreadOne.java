package com.nsfc.practice.rhread.one;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

/**
 * 测试synchronized锁对象还是锁方法
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/11
 */
public class TestThreadOne {

    public  void test() {

        synchronized (this) {
            System.out.println("test开始。。。");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("test结束");
        }
    }

}

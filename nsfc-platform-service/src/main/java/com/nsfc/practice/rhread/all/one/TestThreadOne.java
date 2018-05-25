package com.nsfc.practice.rhread.all.one;

/**
 * 测试线程1
 *
 *  为什么要设置线程数小于处理器的数目
 *  如果超过的话  就会是时间片  否则就是并行
 *
 *  手机等小型设备可能使用的是协作式
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/14
 */
public class TestThreadOne {

    public static void main(String[] args) {

        //使用Runnable的方式创建线程
        Runnable r = () -> {System.out.println("this is a thread");};
        Thread thread = new Thread(r);
        thread.start();

        while (Thread.currentThread().isInterrupted()){
            //do something
        }

        /**
         *自定义的线程默认处理器
         */
        Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {

            /**
             * @param t 被异常终止的线程
             * @param e 未被捕获的异常
             */
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("自定义异常处理");
            }
        };

        Thread.setDefaultUncaughtExceptionHandler(handler);

    }

}

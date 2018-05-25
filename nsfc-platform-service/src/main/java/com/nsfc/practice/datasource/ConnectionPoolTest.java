package com.nsfc.practice.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试自定义数据库连接池
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/23
 */
public class ConnectionPoolTest {

    //初始线程数10
    static ConnectionPool pool = new ConnectionPool(10);

    //保证所有的ConnectRunner同时开始
    static CountDownLatch start = new CountDownLatch(1);

    //保证所有ConnectionRunner结束后才能执行
    static CountDownLatch end;

    public static void main(String[] args) {


        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection " + notGot);

    }

    static class ConnectionRunner implements Runnable{


        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {

            try {
                start.await();
                System.out.println("线程" + Thread.currentThread().getId() + "正在等待");
            }catch (Exception e){
            }

            while (count > 0){
                try {
                    // 从线程池中获取连接，如果1000ms内无法获取到，将会返回null
                    // 分别统计连接获取的数量got和未获取到的数量notGot
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        }catch (SQLException ex){
                            //SQL异常
                        } finally {
                            try {
                                connection.close();
                                got.incrementAndGet();
                            }catch (Exception ex){

                            }
                        }

                    }else {
                        notGot.incrementAndGet();
                    }

                }catch (InterruptedException ex){

                }finally {
                    count--;
                }
            }
            end.countDown();

        }
    }

}

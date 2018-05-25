package com.nsfc.practice.datasource;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 自己写的连接池
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/23
 */
public class ConnectionPool {

    /**
     * 连接池
     */
    private volatile LinkedList<Connection> linkPool = new LinkedList<>();

    /**
     * 初始化连接池
     * @param initSize
     */
    public ConnectionPool(int initSize) {

        if (initSize > 0){
            for (int i=0; i<initSize; i++){
                linkPool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    /**
     * 释放连接 放回连接池
     * @param connection
     */
    public void releaseConnection(Connection connection){

        if (null != connection){
            synchronized (linkPool){
                linkPool.addLast(connection);
                linkPool.notifyAll();
            }
        }
    }

    /**
     * 获取连接
     * @param mills 最大等待时间
     * @return
     * @throws InterruptedException
     */
    public Connection fetchConnection(long mills) throws InterruptedException{

        synchronized (linkPool) {
            if (mills < 0) {
                //时间为负数  一直等待
                while (linkPool.isEmpty()) {
                    linkPool.wait();
                }
                return linkPool.removeFirst();

            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (linkPool.isEmpty() && remaining > 0) {
                    //延时等待
                    linkPool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection connection = null;
                if (!linkPool.isEmpty()) {
                    connection = linkPool.removeFirst();
                }
                return connection;

            }
        }
    }

}

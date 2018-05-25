package com.nsfc.practice.rhread.all.three;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/15
 */
public class ReadAndWriteLock {

    public static void main(String[] args) {

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        //抽取读写锁
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();

        //加锁
        readLock.lock();
        writeLock.lock();

        //解锁
        readLock.unlock();
        writeLock.unlock();


    }
}

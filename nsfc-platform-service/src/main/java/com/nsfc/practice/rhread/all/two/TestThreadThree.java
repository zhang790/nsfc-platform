package com.nsfc.practice.rhread.all.two;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * 测试原子类
 *
 * 原子类使用乐观锁的思想
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/15
 */
public class TestThreadThree {

    public static void main(String[] args) {

        AtomicLong nextNumber = new AtomicLong();
        long id = nextNumber.incrementAndGet();  //原子操作  线程安全

        AtomicLong largest = new AtomicLong();
        long a = 121L;
        largest.set(Math.max(largest.get(), a)); //非原子操作

        largest.compareAndSet(largest.get(), a); //原子操作

        //JDK8新提供 如果可能存在大量的竞争  选择这个
        LongAdder longAdder = new LongAdder();
        //更加广义的累加
        LongAccumulator longAccumulator = new LongAccumulator(Long::sum, 0);

    }

}

package com.nsfc.practice.rhread.all.two;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 竞争相关测试
 *
 * synchroinzed和lock都是锁对象
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/14
 */
public class TestThreadTwo {

    public static void transfer(Account from, Account to, double money){

        ReentrantLock mylock = new ReentrantLock();  //使用lock锁对象

        mylock.lock();
        try {
            System.out.println("当前线程：" + Thread.currentThread());
            from.setMoney(from.getMoney() - money);
            System.out.println("账户" + from.getAccountId() + "扣钱" + money);
            to.setMoney(to.getMoney() + money);
            System.out.println("账户" + to.getAccountId() + "扣钱" + money);
        }catch (Exception ex){
            mylock.unlock();
        }

    }

    public static void main(String[] args) {



    }
}

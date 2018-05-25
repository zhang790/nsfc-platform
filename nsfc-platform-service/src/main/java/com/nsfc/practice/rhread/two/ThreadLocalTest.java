package com.nsfc.practice.rhread.two;

import java.util.HashMap;

/**
 * ThreadLocal测试
 *
 * lambda 简化匿名类  单接口函数（函数式编程） 所有循环
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/11
 */
public class ThreadLocalTest {

    static ThreadLocal<HashMap> map0 = ThreadLocal.withInitial(
            () ->
            {
                System.out.println(Thread.currentThread().getName()+"initialValue");
                return new HashMap();
            });

    static ThreadLocal<HashMap> map1 = ThreadLocal.withInitial(
            () ->new HashMap<>());

    public void run(){
        Thread[] runs = new Thread[3];
        for(int i=0;i<runs.length;i++){
            runs[i]=new Thread(new T1(i));
        }
        for(int i=0;i<runs.length;i++){
            runs[i].start();
        }
    }
    public static class T1 implements Runnable{
        int id;
        public T1(int id0){
            id = id0;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName()+":start");
            HashMap map = map0.get();
            for(int i=0;i<10;i++){
                map.put(i, i+id*100);
                try{
                    Thread.sleep(100);
                }catch(Exception ex){
                }
            }
            System.out.println(Thread.currentThread().getName()+':'+map);
        }
    }
    /**
     * Main
     * @param args
     */
    public static void main(String[] args){
        ThreadLocalTest test = new ThreadLocalTest();
        test.run();
    }

}

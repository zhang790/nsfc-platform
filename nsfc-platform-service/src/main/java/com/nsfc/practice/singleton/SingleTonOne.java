package com.nsfc.practice.singleton;

/**
 * 懒汉式
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/10
 */
public class SingleTonOne {


    private static SingleTonOne singleTonOne = null;


    private SingleTonOne() {
    }

    public static synchronized SingleTonOne getInstance(){ //加线程安全

        if (null == singleTonOne){
            singleTonOne = new SingleTonOne();
        }
        return  singleTonOne;
    }

    /**
     * 双重检查锁  需要加volatile防止指令重拍
     * @return
     */
    public static synchronized SingleTonOne getInstanceTwo(){

        if (null == singleTonOne) {
            synchronized (SingleTonOne.class) {
                if (null == singleTonOne) {
                    singleTonOne = new SingleTonOne();
                }
            }
        }
        return singleTonOne;

    }
}

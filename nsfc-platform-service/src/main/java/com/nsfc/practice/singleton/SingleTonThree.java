package com.nsfc.practice.singleton;

/**
 * 静态内部类
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/10
 */
public class SingleTonThree {

    private static class SingletonHolder{
        public static SingleTonThree singleTonThree = new SingleTonThree();
    }

    private SingleTonThree(){};

    public static  SingleTonThree getInstance(){
        return SingletonHolder.singleTonThree;
    }

}

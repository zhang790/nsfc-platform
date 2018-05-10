package com.nsfc.practice.singleton;

/**
 * 饿汉式
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/10
 */
public class SingleTonTwo {

    private static SingleTonTwo singleTonTwo = new SingleTonTwo();

    private SingleTonTwo(){}

    private static SingleTonTwo getInstance(){
        return  singleTonTwo;
    }

}

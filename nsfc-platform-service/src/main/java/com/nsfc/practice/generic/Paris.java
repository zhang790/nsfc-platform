package com.nsfc.practice.generic;

import java.util.Arrays;

/**
 * 泛型测试
 *
 * 泛型类
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/14
 */
public class Paris <E, U>{

    private E first;

    private U second;

    public Paris() {
    }

    public Paris(E first, U second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    /**
     * 泛型方法
     * @param array
     * @param <T>
     * @return
     */
    private static <T> T getMiddle(T... array){
        return array[array.length/2];
    }

    /**
     * 使用通配符
     * @param paris
     * @param <T>
     * @return
     */
    private  static <T> T getValue(Paris<? extends Object, ? super Object> paris){
        return null;
    }

    public static void main(String[] args) {

        //调用泛型方法 两种方法都行
//        Paris.<String>getMiddle(new String[]{"1","2"});
        Paris.getMiddle(new String[]{"1","2"});

    }

}

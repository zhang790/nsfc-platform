package com.nsfc.practice.rhread.all;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFromate修改  相同的  随机数生成器
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/15
 */
public class ModifyDateTime {

    //线程不安全
    public static final SimpleDateFormat dateFromate = new SimpleDateFormat("yyyy-MM-dd");

    //线程安全
    public static final ThreadLocal<SimpleDateFormat> newDateFormat = ThreadLocal.withInitial(
            () ->new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {

        //多线程同时调用会造成内部的数据结果混乱
        String dateTime = dateFromate.format(new Date());



    }

}

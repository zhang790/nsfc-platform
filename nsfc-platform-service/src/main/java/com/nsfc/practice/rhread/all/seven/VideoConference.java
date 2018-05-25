package com.nsfc.practice.rhread.all.seven;

import java.util.concurrent.CountDownLatch;

/**
 * 会议类  模拟CountDownLatch的使用
 * 模拟10个参会者和一个主持人参加的一个会以，
 * 每个参会者及主持人需要等待其他的参会者均到场签到之后，才能开始会以并发言
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/24
 */
public class VideoConference implements Runnable{

    private final    CountDownLatch countDownLatch;
    private volatile   Integer number;

    //初始化
    public VideoConference(Integer number){
        this.number = number;
        countDownLatch = new CountDownLatch(number);
        System.out.println("初始化倒门栓" + countDownLatch.getCount() );
    }

    public  void arrive(String name){
        //任务完成  计数减一
        countDownLatch.countDown();
        System.out.println( "当前的类" + countDownLatch +  "  当前计数" + countDownLatch.getCount());
        System.out.println(name + "签到");
        try {
            countDownLatch.await();//等待
            System.out.println(name + "说：让我们开始");

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }


    @Override
    public void run() {
        System.out.println("已经到了" + (number - countDownLatch.getCount()) + "人");
        try {
            countDownLatch.await();//进入休眠
            System.out.println("所有的都到了" + (number - countDownLatch.getCount()) );

        }catch (Exception ex){

        }

    }
}

package com.nsfc.practice.rhread.all.seven;

import java.util.concurrent.CountDownLatch;

/**
 * 参会者
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/24
 */
public class Participant implements Runnable{

//    private static CountDownLatch countDownLatch;
    private final VideoConference videoConference;
    private String name;

    public Participant(String name,VideoConference videoConference) {
        this.videoConference = videoConference;
//        countDownLatch = new CountDownLatch(10);
        this.name = name;
    }

    @Override
    public void run() {

        try {

            //到场
            videoConference.arrive(name);
//            countDownLatch.countDown();
//            System.out.println(Thread.currentThread().getName()+"到了");
//            countDownLatch.await();
            //间隔时间
            Thread.sleep(50);
//            System.out.println(Thread.currentThread().getName()+"回复了");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        VideoConference videoConference = new VideoConference(10);
        Thread videoThread = new Thread(videoConference);
        videoThread.start();
//        countDownLatch = new CountDownLatch(10);
        for(int i=0; i<10; i++){
            Thread thread = new Thread(
                    new Participant("participant:"+i,videoConference));
            thread.start();
        }
    }
}

package com.nsfc.practice.rhread.all.four;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 测试阻塞队列的使用
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/15
 */
public class BlockQueueTest {

    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)){
            System.out.print("Enter base directory (e.g./opt/jdkl.8.0/src): ");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();
            Runnable enumerator = () -> {
                try {
                    enumerate(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {

                }};
            new Thread(enumerator).start();

            for (int i = 1; i<SEARCH_THREADS; i++){

            }



            }
    }


    /**
     * 收集目录下的所有文件
     * @param directory
     * @throws InterruptedException
     */
    public static void enumerate(File directory) throws InterruptedException{
        File[] files = directory.listFiles();
        for (File file : files){
            if (file.isDirectory()){
                enumerate(file);
            }else {
                queue.add(file);
            }
        }
    }

    /**
     * 查询收集到的文件
     * @param file
     * @param keyword
     * @throws IOException
     */
    public static void search(File file,String keyword) throws IOException{
        try (Scanner scanner = new Scanner(file, "UTF-8")){

            int lineNumber = 0;
            while (scanner.hasNextLine()){
                lineNumber++;
                String lineContext = scanner.nextLine();
                if (lineContext.contains(keyword)){
                    System.out.printf("56s:%d:%s%n", file.getPath(), lineNumber, lineContext);
                }
            }
        }
    }


}

package com.nsfc.practice.lambda;

/**
 * 测试一个异常
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/8
 */
public class TestException {

    public static void main(String[] args) {
//        System.out.println(test01());   第五步
    }

    public static  int test01(){

        int b=1;

        try {
            // System.out.println("try block"); 第一步
//            return ++b; 第四部
        }catch (Exception e){
            b = 10;
            System.out.println("catch block");
        }finally {
//            ++b;   第二步
//            System.out.println("finally block");第三步
        }

        System.out.println("last block");
        return b;

    }

}

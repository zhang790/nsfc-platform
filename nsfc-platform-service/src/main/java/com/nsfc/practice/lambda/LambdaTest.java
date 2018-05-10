package com.nsfc.practice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 测试Lambda表达式
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/8
 */
public class LambdaTest {


    private static void testLambdaOne(){
        String[] Weekend = new String[]{"Monday", "ThirdDay", "OnePiece", "football", "SatDay"};

        System.out.println(Arrays.toString(Weekend));
        Arrays.sort(Weekend);
        System.out.println(Arrays.toString(Weekend));

        //使用Lambda重写Compator接口
        Arrays.sort(Weekend,(firset, sencond)-> firset.length() - sencond.length());
        System.out.println(Arrays.toString(Weekend));
    }


    private static void  testLambdaTwo(){
        //java8之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("java8之前的写法 传递方法使用匿名内部类");
            }
        }).start();

        //java8
        new Thread(() -> System.out.println("java8的函数式编程")).start();
    }

    private static void testLambdaThree(){
        //java8之前
        List<String> feature = Arrays.asList("Monday", "ThirdDay", "OnePiece", "football", "SatDay");
        for (String temp : feature){
            System.out.println(temp);
        }

        System.out.println("==================");
        //java8之后
        feature.forEach(temp->System.out.println(temp));

        System.out.println("==================");
        //方法引用
        feature.forEach(System.out::println);

    }

    //使用函数式接口Predicate
    private static void testLambdaFour(){

        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        filter(languages, (str)->str.equals("Java"));
        System.out.println("-------------------------------");
        filter(languages, (str)->true);

    }
    private static void filter(List<String> names, Predicate condition){
        for (String name : names){
            if (condition.test(name)){
                System.out.println(name + "");
            }
        }
    }

    private static void testLambdaFive(){

        //等号前半部分是声明  后半部分是实现
        MyLambdaInterface myLambdaInterface  = (s) -> System.out.println("这是实现" + s);
        myLambdaInterface.doSomeThing("x");

    }

    /**
     * 使用Lambda处理异常  java8之前需要整体try catcah
     */
    private static void testLambdaSix(){

        List<Integer> i = Arrays.asList(3,5,6,0,10,7);
        i.forEach(handleException(k -> System.out.println(50/k)));

    }
    private static Consumer<Integer> handleException(Consumer<Integer> consumer){
        return i -> {
            try {
                consumer.accept(i);
            }catch (Exception e){
                System.out.println("发生异常：" + e.getMessage());
            }

        };
    }


    public static void main(String[] args) {

//        testLambdaTwo();
//        testLambdaThree();
//        testLambdaFour();
//        testLambdaFive();
          testLambdaSix();

    }

}
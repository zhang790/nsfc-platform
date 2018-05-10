package com.nsfc.practice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Lambda异常处理测试
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/8
 */
public class LambdaExceptionTest {

    /**
     * 使用Lambda处理异常  java8之前需要整体try catcah
     */
    private static void testLambdaOne(){

        List<Integer> i = Arrays.asList(3,5,6,0,10,7);
        i.forEach(handleException(k -> System.out.println(50/k)));
    }

    private  static void  testLambdaExceptionTwo(){
        List<Integer> i = Arrays.asList(3,5,6,0,10,7);
        i.forEach(handleExceptionBetter(k -> System.out.println(50/k), ArithmeticException.class));
    }

    /**
     * 处理方式一
     * @param consumer
     * @return
     */
    private static Consumer<Integer> handleException(Consumer<Integer> consumer){
        return i -> {
            try {
                consumer.accept(i);
            }catch (Exception e){
                System.out.println("发生异常：" + e.getMessage());
            }

        };
    }

    /**
     * 通过反省 处理的异常类型
     * @param consumer
     * @param clazz
     * @param <T>
     * @param <E>
     * @return
     */
    private static <T , E extends Exception> Consumer<T>  handleExceptionBetter(Consumer<T> consumer, Class<E> clazz) {

        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = clazz.cast(ex);
                    System.err.println(
                            "Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw ex;
                }
            }
        };
    }

    public static void main(String[] args) {
        testLambdaExceptionTwo();
    }

}

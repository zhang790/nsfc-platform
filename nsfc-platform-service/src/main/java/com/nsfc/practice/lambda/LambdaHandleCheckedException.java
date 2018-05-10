package com.nsfc.practice.lambda;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Lambda处理checked异常
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/8
 */
public class LambdaHandleCheckedException {

    /**
     * IO异常是Checked异常 必须处理
     * @throws IOException
     */
    private static void writeToFiel(int i) throws IOException{
        if (i == 6){
            throw new IOException();
        }
        System.out.println(i);
    }

    private static void testHandleException(){
        List<Integer> i = Arrays.asList(3,5,6,0,10,7);
        i.forEach(handleCheckException((k -> writeToFiel(k)), IOException.class));
    }

    private static <T, E extends Exception> Consumer<T> handleCheckException(ThrowConsumer<T, E> throwConsumer, Class<E> Exceptionclazz){
        return i -> {
            try {
                throwConsumer.accept(i);
            }catch (Exception e){
                try {
                    e.printStackTrace();
                }catch (ClassCastException classCasetException){
                    throw new RuntimeException(classCasetException);

                }
            }
        };
    }

    public static void main(String[] args) {
        testHandleException();
    }

}

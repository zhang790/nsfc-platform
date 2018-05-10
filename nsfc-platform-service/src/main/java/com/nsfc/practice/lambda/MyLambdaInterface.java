package com.nsfc.practice.lambda;

/**
 * 自定义lambda函数式接口
 */
@FunctionalInterface //强制一个接口只有一个函数
public interface MyLambdaInterface {

    void doSomeThing(String name);
}

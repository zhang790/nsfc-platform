package com.nsfc.platform.user.service.impl;

/**
 * 自定义函数接口处理cheked异常
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/8
 */
@FunctionalInterface
public interface ThrowConsumer <T, E extends Exception>{
    void accept(T t) throws E;
}

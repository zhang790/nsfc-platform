package com.nsfc.practice.datasource;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * 模拟数据库驱动类  不连接数据库  只是休眠一会
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/23
 */
public class ConnectionDriver {

    /**
     * 使用动态代理的方式
     */
    static class ConnectionHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.equals("commit")){
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance
                (ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionHandler());
    }



}

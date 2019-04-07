package com.syb.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    private Object object;
    public JDKProxy(Object object){
        this.object = object;
    }

    public  Object getInstance(){
        Object instance = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
        return instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        befor();
        Object invoke = method.invoke(this.object, args);
        after();
        return invoke;
    }

    public void befor(){
        System.out.println("jdk启动之前");
    }

    public void after(){
        System.out.println("jdk 启动之后");
    }

}

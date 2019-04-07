package com.syb.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CGlibProxy implements MethodInterceptor {

    private Object object;
    public CGlibProxy(){
        this.object = object;
    }

    public  Object getInstance(Class<?> clazz){
        //相当于Proxy，代理的工具类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        befor();
        Object obj = methodProxy.invokeSuper(o,objects);
        after();
        return obj;
    }

    public void befor(){
        System.out.println("cglib启动之前");
    }

    public void after(){
        System.out.println("cglib启动之后");
    }


}

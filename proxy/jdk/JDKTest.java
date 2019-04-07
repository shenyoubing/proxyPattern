package com.syb.proxy.jdk;

import java.lang.reflect.Method;

public class JDKTest {
    public static void main(String[] args) {
        try {
            //源码里面限定jdk代理目标类实现的接口不能超过65535个，
            // 由于java虚拟机的限制 由于java使用UNICODE标准字符集，为16位，因此一共能表示2的16次方个字符，即65535个。
            Phone hwphone = new HuaWeiPhone();
            Object instance = new JDKProxy(hwphone).getInstance();
            Method method = instance.getClass().getMethod("sellPhone", null);
            method.invoke(instance,null);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

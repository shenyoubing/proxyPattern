package com.syb.proxy.cglib;

import java.lang.reflect.Method;

public class CGlibTest {
    public static void main(String[] args) {
        try {
            HuaWeiPhone instance = (HuaWeiPhone)new CGlibProxy().getInstance(HuaWeiPhone.class);
            instance.sellPhone();
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

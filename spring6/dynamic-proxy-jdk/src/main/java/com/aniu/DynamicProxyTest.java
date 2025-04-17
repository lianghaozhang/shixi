package com.aniu;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {

//      需要代理的目标对象
        OrderService target = new OrderServiceImpl();

//      创建代理对象
        OrderService targetProxy = (OrderService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));

//      使用代理对象调用代理方法
        targetProxy.query();
        targetProxy.insert();
        targetProxy.update();
    }
}

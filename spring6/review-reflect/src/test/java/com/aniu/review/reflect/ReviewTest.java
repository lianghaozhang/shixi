package com.aniu.review.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReviewTest {

    @Test
    public void test1() throws Exception {
        // 获取类
        Class<?> clazz = Class.forName("com.aniu.com.aniu.review.reflect.User");
        // 获取要执行的方法
        Method method_one = clazz.getDeclaredMethod("look_oneArg", String.class);
        Method method_two = clazz.getDeclaredMethod("look_twoArg", String.class, int.class);
        // 实例化执行方法的对象
        // 方法一
        Object object1 = clazz.newInstance();
        // 方法二
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object object2 = constructor.newInstance();
        // 执行方法
        method_one.invoke(object1, "zhangsan");
        method_two.invoke(object1, "zhangsan", 23);

    }
    
    
    @Test
    public void test2() throws Exception {
        String className = "com.aniu.com.aniu.review.reflect.User";
        String propertyName = "age";
        Class<?> clazz = Class.forName(className);
//        获取通过set方法注入的方法名
        String methodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
//        通过field属性获取到成员变量的类型，因为成员变量的类型和set方法的参数类型一致
        Class<?> type = clazz.getDeclaredField(propertyName).getType();
        Method setAge = clazz.getDeclaredMethod(methodName, type);

        Object object = clazz.newInstance();
        System.out.println(object);
        setAge.invoke(object, 999);
        System.out.println(object);
    }
}

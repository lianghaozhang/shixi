package com.aniu.review.annotation;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReflectAnnotationTest {

//    通过反射判断类上是否有注解，并获取注解的值
    @Test
    public void test() throws Exception {
        Class<?> clazz = Class.forName("com.aniu.review.bean.A");
        if (clazz.isAnnotationPresent(Ooo.class)){
            Ooo annotation = clazz.getAnnotation(Ooo.class);
            String name = annotation.name();
            int age = annotation.age();
            System.out.println("name:" + name + ", age:" + age);
        }
    }

//    通过反射把使用了@Ooo注解的类找出来
    @Test
    public void test2() throws Exception {
        Map<String, Object> ioc = new HashMap<>();
        String packageName = "com.aniu.review.bean";
        String packagePath = packageName.replace('.', '/');
//        System.out.println(packagePath);
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
//        System.out.println(url);
        String path = url.getPath();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
//            System.out.println(f.getName().split("\\.")[0]);
            String className = packageName + "." + f.getName().split("\\.")[0];
//            System.out.println(className);
            Class<?> clazz = Class.forName(className);
            if(clazz.isAnnotationPresent(Ooo.class)){
                Ooo annotation = clazz.getAnnotation(Ooo.class);
                String id = annotation.name();
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                Object object = constructor.newInstance();
                ioc.put(id, object);
            }
        }

        ioc.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });
    }
}

package com.aniu.com.aniu.spring6.bean.lifecycle;

public class User {

    private String name;

    public User() {
        System.out.println("第一步：实例化bean");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步：bean属性赋值");
    }

    public void initBean(){
        System.out.println("第三步：初始化bean");
    }

    public void destroyBean(){
        System.out.println("第五步：销毁bean");
    }
}

package com.aniu;

public class OrderServiceImpl implements OrderService {
    @Override
    public void query() {
        System.out.println("查询订单");
    }

    @Override
    public void update() {
        System.out.println("更新订单");
    }

    @Override
    public void insert() {
        System.out.println("插入订单");
    }
}

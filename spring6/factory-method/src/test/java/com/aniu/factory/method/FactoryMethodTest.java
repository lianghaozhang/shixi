package com.aniu.factory.method;

import org.junit.Test;

public class FactoryMethodTest {

    @Test
    public void testFactoryMethod() {
        QiangFactory qiangFactory = new QiangFactory();
        Weapon weapon = qiangFactory.get();
        weapon.attack();

        TankFactory tankFactory = new TankFactory();
        Weapon weapon1 = tankFactory.get();
        weapon1.attack();
    }
}

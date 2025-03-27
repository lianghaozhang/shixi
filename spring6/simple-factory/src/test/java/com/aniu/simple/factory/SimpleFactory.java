package com.aniu.simple.factory;

import org.junit.Test;

public class SimpleFactory {

    @Test
    public void test() {
        WeaponFactory.get("TANK").gongji();
        WeaponFactory.get("QIANG").gongji();
        WeaponFactory.get("FEIJI").gongji();
    }
}

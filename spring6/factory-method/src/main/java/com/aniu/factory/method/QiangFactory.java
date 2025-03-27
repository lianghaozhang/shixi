package com.aniu.factory.method;

public class QiangFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Qiang();
    }
}

package com.aniu.simple.factory;

public class WeaponFactory {

    public static Weapon get(String type){
        if(type.equals("FEIJI")){
            return new Feiji();
        }else if(type.equals("QIANG")){
            return new Qiang();
        }else if(type.equals("TANK")){
            return new Tank();
        }else {
            throw new RuntimeException("不支持该武器");
        }
    }
}

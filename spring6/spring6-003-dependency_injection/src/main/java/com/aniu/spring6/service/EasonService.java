package com.aniu.spring6.service;

import com.aniu.spring6.dao.EasonDao;

public class EasonService {

    private EasonDao easonDao;

    public void setEasonDao(EasonDao easonDao) {
        this.easonDao = easonDao;
    }

    public void sayHello(String city){
        easonDao.create(city);
    }
}

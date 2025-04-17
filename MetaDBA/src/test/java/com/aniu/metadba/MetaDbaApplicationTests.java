package com.aniu.metadba;

import com.aniu.metadba.service.ConnectionService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MetaDbaApplicationTests {

    @Resource
    private ConnectionService connectionService;

    @Test
    void test01() {
        connectionService.checkContrarian();
//        System.out.println(connectionService.getDatabaseTables(20));
    }



}

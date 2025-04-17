package com.aniu.metadba.controller;

import com.aniu.metadba.entity.DataSource;
import com.aniu.metadba.service.DatasourceService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataSourceController {

    @Resource
    private DatasourceService datasourceService;

    @GetMapping("/api/getDataSourceList")
    public List<DataSource> selectAll() {
        return datasourceService.selectAll();
    }
}

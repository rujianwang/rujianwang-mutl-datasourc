package com.example.demo.controller;

import com.example.demo.domain.mapper.QueryMapper;
import com.example.demo.model.CustomerDataSourceCreateModel;
import com.example.demo.model.CustomerDataSourceDetailModel;
import com.example.demo.service.CustomerDataSourceService;
import com.github.yeecode.dynamicdatasource.DynamicDataSource;
import com.github.yeecode.dynamicdatasource.model.DataSourceInfo;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wang
 * @Date: 2021/4/24 9:31
 */
@RestController
public class HomeController {
    ModelMapper modelMapper = new ModelMapper();
    private final DynamicDataSource dynamicDataSource;
    private final CustomerDataSourceService _dataSourceService;

    @Resource
    private QueryMapper queryMapper;

    public HomeController(
            DynamicDataSource dynamicDataSource,
            CustomerDataSourceService dataSourceService) {
        this.dynamicDataSource = dynamicDataSource;
        _dataSourceService = dataSourceService;
    }

    @GetMapping("/")
    public String index() {
        return "ok";
    }

    @PostMapping("/data-sources")
    public Integer create(@RequestBody CustomerDataSourceCreateModel model) {
        return _dataSourceService.create(model);
    }

    @GetMapping("/data-sources")
    public List<CustomerDataSourceDetailModel> list() {
        return _dataSourceService.list();
    }

    @GetMapping("/data-sources/exec")
    public String exec() {
        var list = _dataSourceService.list();
        StringBuilder str = new StringBuilder();
        for (CustomerDataSourceDetailModel model : list) {
            var s = new DataSourceInfo(
                    model.getName(),
                    model.getDriverClassName(),
                    model.getUrl(),
                    model.getUserName(),
                    model.getPassword()
            );
            dynamicDataSource.addAndSwitchDataSource(s, true);
            var obj = queryMapper.query("select * from user");
            str.append(obj.get(0).getName()).append(" - ");
        }
        return str.toString();
    }
}

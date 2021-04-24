package com.example.demo.service.impl;

import com.example.demo.domain.CustomerDataSource;
import com.example.demo.domain.mapper.CustomerDataSourceMapper;
import com.example.demo.model.CustomerDataSourceCreateModel;
import com.example.demo.model.CustomerDataSourceDetailModel;
import com.example.demo.service.CustomerDataSourceService;
import com.github.yeecode.dynamicdatasource.DynamicDataSource;
import com.github.yeecode.dynamicdatasource.model.DataSourceInfo;
import lombok.var;
import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wang
 * @Date: 2021/4/24 9:35
 */
@Service
public class CustomerDataSourceServiceImpl implements CustomerDataSourceService {

    ModelMapper modelMapper = new ModelMapper();

    @Resource
    private CustomerDataSourceMapper customerDataSourceMapper;
    private final DynamicDataSource dynamicDataSource;
//    private final JdbcTemplate jdbcTemplate;

    public CustomerDataSourceServiceImpl(
            DynamicDataSource dynamicDataSource
//            JdbcTemplate jdbcTemplate
    ) {
        this.dynamicDataSource = dynamicDataSource;
//        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer create(CustomerDataSourceCreateModel model) {
        CustomerDataSource entity = modelMapper.map(model, CustomerDataSource.class);
        dynamicDataSource.switchDefaultDataSource();
        customerDataSourceMapper.save(entity);
//        if (id > 0) {
////            var source = new DataSourceInfo(
////                    model.getKey(),
////                    model.getDriverClassName(),
////                    model.getUrl(),
////                    model.getUserName(),
////                    model.getPassword()
////            );
////            dynamicDataSource.addAndSwitchDataSource(source, false);
////            var result = jdbcTemplate.queryForList("select * from user");
//        }
//        return id;
        return 0;
    }

    @Override
    public List<CustomerDataSourceDetailModel> list() {
        dynamicDataSource.switchDefaultDataSource();
        var list = customerDataSourceMapper.list();
        var result = new ArrayList<CustomerDataSourceDetailModel>();
        list.forEach(entity -> {
            result.add(modelMapper.map(entity, CustomerDataSourceDetailModel.class));
        });
        return result;
    }
}

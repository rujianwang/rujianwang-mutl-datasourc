package com.example.demo.service;

import com.example.demo.domain.CustomerDataSource;
import com.example.demo.model.CustomerDataSourceCreateModel;
import com.example.demo.model.CustomerDataSourceDetailModel;

import java.util.List;

/**
 * @Author: wang
 * @Date: 2021/4/24 9:34
 */
public interface CustomerDataSourceService {
    Integer create(CustomerDataSourceCreateModel model);

    List<CustomerDataSourceDetailModel> list();
}

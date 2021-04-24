package com.example.demo.model;

import lombok.Data;


/**
 * @Author: wang
 * @Date: 2021/4/24 10:30
 */
@Data
public class CustomerDataSourceDetailModel {
    private Integer id;

    private String code;

    private String name;

    private String remark;

    private String driverClassName;

    private String url;

    private String userName;

    private String password;
}

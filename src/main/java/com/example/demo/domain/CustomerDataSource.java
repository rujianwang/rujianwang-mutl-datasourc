package com.example.demo.domain;

import lombok.Data;

//import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: wang
 * @Date: 2021/4/24 9:35
 */
@Data
//@Entity
//@Table
public class CustomerDataSource implements Serializable {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
    private Integer id;

    private String code;

    private String name;

    private String remark;

    private String driverClassName;

    private String url;

    private String userName;

    private String password;
}

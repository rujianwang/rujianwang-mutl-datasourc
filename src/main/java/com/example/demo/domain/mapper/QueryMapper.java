package com.example.demo.domain.mapper;

import com.example.demo.domain.CustomerDataSource;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: wang
 * @Date: 2021/4/24 15:10
 */
@Mapper
public interface  QueryMapper {

    @Select("${sql}")
    List<User> query(@Param("sql")String sql);
}

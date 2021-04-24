package com.example.demo.domain.mapper;

import com.example.demo.domain.CustomerDataSource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: wang
 * @Date: 2021/4/24 14:18
 */
@Mapper
public interface  CustomerDataSourceMapper {
    @Select("select * from customer_data_source")
    List<CustomerDataSource> list();

    @Insert("INSERT INTO customer_data_source(" +
            "  code," +
            "  driver_class_name," +
            "  name," +
            "  password ," +
            "  remark," +
            "  url," +
            "  user_name) VALUES(" +
            "#{code}, " +
            "#{driverClassName}, " +
            "#{name}," +
            "#{password}," +
            "#{remark}," +
            "#{url}," +
            "#{userName}" +
            ")")
    void save(CustomerDataSource entity);
}

package com.yibaijin.service.boot.dao.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(value = "com.yibaijin")
@Configuration
public class MybatisConfiguration {

}

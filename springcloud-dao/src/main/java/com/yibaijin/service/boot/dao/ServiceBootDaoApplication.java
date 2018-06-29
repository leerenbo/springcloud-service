package com.yibaijin.service.boot.dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = "com.yibaijin")
@ImportResource("classpath*:application-context-*.xml")
public class ServiceBootDaoApplication implements CommandLineRunner {

    @Resource
    DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceBootDaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(dataSource.getConnection());
    }
}

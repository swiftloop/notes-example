package com.github.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.github.example.mapper")
public class ApacheShardingSphereJdbcExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApacheShardingSphereJdbcExampleApplication.class, args);
    }

}

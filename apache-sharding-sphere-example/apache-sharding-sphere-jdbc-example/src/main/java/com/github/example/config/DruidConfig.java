//package com.github.example.config;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
///**
// * @author sorata 2020-08-28:11:17
// */
//@Configuration
//public class DruidConfig {
//
//    @Bean
//    @Primary
//    @ConfigurationProperties(value = "spring.shardingsphere.datasource.ds1")
//    public DataSource master(){
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties(value = "spring.shardingsphere.datasource.ds2")
//    public DataSource slave(){
//        return DruidDataSourceBuilder.create().build();
//    }
//
//}

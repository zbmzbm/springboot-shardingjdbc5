package com.example.shardingjdbc5demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan(basePackages = {"com.example.shardingjdbc5demo.mapper"})
public class ShardingJdbc5DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbc5DemoApplication.class, args);
    }

}

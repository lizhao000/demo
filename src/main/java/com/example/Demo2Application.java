package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement//开启注解版事务
@EnableCaching(proxyTargetClass = true)//开启注解版的缓存
@SpringBootApplication
@MapperScan("com.example.dao")//扫描Mapper
public class Demo2Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
}

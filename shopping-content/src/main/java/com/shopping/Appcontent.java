package com.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableEurekaClient
@Transactional
@MapperScan("com.shopping.mapper")
public class Appcontent {
public static void main(String[] args) {
	SpringApplication.run(Appcontent.class, args);
}
}

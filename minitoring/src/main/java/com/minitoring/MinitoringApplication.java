package com.minitoring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * 包括三个注解
 * @Configuration：表示将该类作用SpringBoot配置文件类。
 * @EnableAutoConfiguration:表示程序启动时，自动加载SpringBoot默认的配置。
 * @ComponentScan:表示程序启动时，自动扫描当前包及子包下所有类。
 */
@MapperScan("com.minitoring.mapper") // mapper接口类扫描包配置
public class MinitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinitoringApplication.class, args);
	}
}

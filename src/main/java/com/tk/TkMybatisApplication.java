package com.tk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@EnableScheduling
@MapperScan({"com.tk.mapper"})
@SpringBootApplication(scanBasePackages = "com.tk")
public class TkMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkMybatisApplication.class, args);
	}

}

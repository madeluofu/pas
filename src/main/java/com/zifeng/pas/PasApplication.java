package com.zifeng.pas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zifeng.pas.mapper")
@SpringBootApplication
public class PasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasApplication.class, args);
	}

}

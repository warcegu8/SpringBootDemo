package com.spring.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动类
 * @author  milo
 * @version 1.0.0
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.spring.demo.mapper")
public class DemoApplication {
	/**
	 * 主方法，程序入口
	 * @param args 入参
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动类
 * @author  milo
 * @version 1.0.0
 */
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.spring.demo.dao")
@SpringBootApplication
@ServletComponentScan
public class DemoApplication {
	/**
	 * 主方法，程序入口
	 * @param args 入参
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

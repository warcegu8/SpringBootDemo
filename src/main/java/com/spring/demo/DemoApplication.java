package com.spring.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * @author  milo
 * @date 2018-09-26
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.spring.demo.mapper")//指定要扫描的Mapper类的包
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

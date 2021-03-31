package com.spring.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.proxy.DruidDriver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * druid数据配置类
 * @author  milo
 * @date 2018-09-26
 */
@Configuration
public class DruidDataSourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() throws  Exception{
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}

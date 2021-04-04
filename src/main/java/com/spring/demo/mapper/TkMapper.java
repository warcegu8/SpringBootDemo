package com.spring.demo.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用配置类
 * @author  milo
 * @version 1.0.0
 * @param <T>
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {

}

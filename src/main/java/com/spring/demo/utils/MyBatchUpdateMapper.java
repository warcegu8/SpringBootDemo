package com.spring.demo.utils;

import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * 自定义批量更新的Mapper
 * @author  milo
 * @version 1.0.0
 */
public interface MyBatchUpdateMapper<T> {
    @UpdateProvider(type=MyUpdateProvider.class,method = "dynamicSQL")
    void batchUpdate(List<T> list);
}

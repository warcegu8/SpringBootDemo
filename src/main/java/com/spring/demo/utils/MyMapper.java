package com.spring.demo.utils;

import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;
import tk.mybatis.mapper.common.base.select.SelectAllMapper;
import tk.mybatis.mapper.common.base.select.SelectCountMapper;
import tk.mybatis.mapper.common.base.select.SelectMapper;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeySelectiveMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.common.example.UpdateByExampleSelectiveMapper;

/**
 * 定制化的Mapper
 * @author  milo
 * @version 1.0.0
 */
public interface MyMapper<T> extends SelectCountMapper<T>,
                                     SelectMapper<T>,
                                     SelectAllMapper<T>,
                                     SelectByExampleMapper<T>,
                                     MyBatchUpdateMapper<T>,
                                     UpdateByExampleSelectiveMapper<T>,
                                     UpdateByPrimaryKeySelectiveMapper<T>,
                                     InsertSelectiveMapper<T>
{

}

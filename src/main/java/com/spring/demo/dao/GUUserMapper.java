package com.spring.demo.dao;

import com.spring.demo.entity.vo.UserVO;
import com.spring.demo.utils.MyMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.common.Mapper;

/**
 *
 */
@CacheNamespace
public interface GUUserMapper extends MyMapper<UserVO> {


}

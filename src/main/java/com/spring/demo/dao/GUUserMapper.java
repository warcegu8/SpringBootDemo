package com.spring.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.demo.entity.vo.UserVO;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 *
 */
@CacheNamespace
public interface GUUserMapper extends BaseMapper<UserVO> {


}

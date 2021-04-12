package com.spring.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.demo.entity.dto.UserDTO;
import com.spring.demo.entity.vo.UserVO;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户dao
 * @author  milo
 * @version  1.0.0
 */
@CacheNamespace
@Repository
public interface UserMapper extends BaseMapper<UserVO> {

}

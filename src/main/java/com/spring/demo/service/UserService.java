package com.spring.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.demo.dao.UserMapper;
import com.spring.demo.entity.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

     public IPage<UserVO> selectPage(Page<UserVO> page) {
         IPage<UserVO> roleDOList = userMapper.selectPage(page,null);
         return roleDOList;
     }



}

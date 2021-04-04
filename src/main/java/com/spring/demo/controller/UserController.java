package com.spring.demo.controller;


import com.mysql.jdbc.StringUtils;
import com.spring.demo.entity.dto.UserDTO;
import com.spring.demo.entity.vo.UserVO;
import com.spring.demo.enu.ErrorListEnum;
import com.spring.demo.mapper.GUUserMapper;
import com.spring.demo.mapper.UserMapper;
import com.spring.demo.utils.GeneralVO;
import com.spring.demo.utils.ListPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import sun.java2d.loops.FillRect;

import javax.annotation.Resource;
import java.util.List;

/**
 * demo
 * @author  milo
 * @date 2018-09-26
 */
@RestController
@RequestMapping("/user")
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private GUUserMapper gUUserMapper;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/queryUsersByCondition",method = RequestMethod.POST)
    public ListPageVO queryUsersByCondition(@RequestBody UserDTO userDto) {
        List<UserVO> userList = null;
        if(!StringUtils.isNullOrEmpty(userDto.getId())){
            userList = userMapper.queryUsersById(userDto.getId());
        }
        if(!StringUtils.isNullOrEmpty(userDto.getUserName())){
            userList = userMapper.queryUsersByName(userDto.getUserName());
        }
        return new ListPageVO(ErrorListEnum.ERROR_LIST_SUCCESS,userList,userDto.getPageInfo());
    }

    /**
     * 插入用户信息
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public GeneralVO inertUser(@RequestBody UserVO userVO) {
        gUUserMapper.insertSelective(userVO);
        return new GeneralVO(ErrorListEnum.ERROR_LIST_SUCCESS,null);
    }


}


package com.spring.demo.controller;


import com.mysql.jdbc.StringUtils;
import com.spring.demo.entity.dto.UserDTO;
import com.spring.demo.entity.vo.UserVO;
import com.spring.demo.mapper.UserMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * demo
 * @author  milo
 * @date 2018-09-26
 */
@RestController
@RequestMapping("/demo")
@EnableAutoConfiguration
public class UserController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/findUserById",method = RequestMethod.POST)
    List<UserVO> queryUsersByCondition(@RequestBody UserDTO userDto) {
        List<UserVO> userList = null;
        if(!StringUtils.isNullOrEmpty(userDto.getId())){
            userList = userMapper.queryUsersById(userDto.getId());
        }
        if(!StringUtils.isNullOrEmpty(userDto.getUserName())){
            userList = userMapper.queryUsersByName(userDto.getUserName());
        }
        return userList;
    }
}


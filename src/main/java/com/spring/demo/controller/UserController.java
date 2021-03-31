package com.spring.demo.controller;


import com.mysql.jdbc.StringUtils;
import com.spring.demo.entity.dto.UserDTO;
import com.spring.demo.entity.vo.UserVO;
import com.spring.demo.enu.ErrorListEnum;
import com.spring.demo.mapper.UserMapper;
import com.spring.demo.utils.ListPageVO;
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
@RequestMapping("/user")
@EnableAutoConfiguration
public class UserController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/queryUsersByCondition",method = RequestMethod.POST)
    ListPageVO queryUsersByCondition(@RequestBody UserDTO userDto) {
        List<UserVO> userList = null;
        if(!StringUtils.isNullOrEmpty(userDto.getId())){
            userList = userMapper.queryUsersById(userDto.getId());
        }
        if(!StringUtils.isNullOrEmpty(userDto.getUserName())){
            userList = userMapper.queryUsersByName(userDto.getUserName());
        }
        return new ListPageVO(ErrorListEnum.ERROR_LIST_SUCCESS,userList,userDto.getPageInfo());
    }
}


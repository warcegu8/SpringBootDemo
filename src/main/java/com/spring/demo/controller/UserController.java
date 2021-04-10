package com.spring.demo.controller;


import com.mysql.jdbc.StringUtils;
import com.spring.demo.entity.dto.UserDTO;
import com.spring.demo.entity.vo.UserVO;
import com.spring.demo.enu.ErrorListEnum;
import com.spring.demo.enu.FlagListEnum;
import com.spring.demo.dao.GUUserMapper;
import com.spring.demo.dao.UserMapper;
import com.spring.demo.utils.GeneralVO;
import com.spring.demo.utils.ListPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import sun.java2d.loops.FillRect;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        userDto.build();
        List<UserVO> userList = null;
        if(userDto.getUserId() != null){
            UserVO userCondition = new UserVO();
            userCondition.setUserId(userDto.getUserId());
            userCondition.setIsDelete(FlagListEnum.FLG_LIST_NOT_DELETE.getKey());
            userList = gUUserMapper.select(userCondition);
        }
        if(!StringUtils.isNullOrEmpty(userDto.getUserName())){
            UserVO userCondition = new UserVO();
            userCondition.setUserName(userDto.getUserName());
            userCondition.setIsDelete(FlagListEnum.FLG_LIST_NOT_DELETE.getKey());
            Example example = new Example(UserVO.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("userName","%" + userDto.getUserName() + "%").
            andEqualTo("isDelete",FlagListEnum.FLG_LIST_NOT_DELETE.getKey());
            userList = gUUserMapper.selectByExample(example);
        }
        return new ListPageVO(ErrorListEnum.ERROR_LIST_SUCCESS,userList,userDto.getPageInfo());
    }

    /**
     * 保存用户信息
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public GeneralVO inertUser(@RequestBody UserVO userVO) {
        //生成数据库主键
        if(userVO.getUserId() == null){
            userVO.setId(UUID.randomUUID().toString().replace("-",""));
            userVO.setCreateOn(new Date());
            userVO.setUpdateOn(new Date());
            userVO.setIsDelete(FlagListEnum.FLG_LIST_NOT_DELETE.getKey());
            int userId = gUUserMapper.selectCount(null) + 1;
            userVO.setUserId(userId);
            userVO.setUpdateBy("123456");
            userVO.setCreateBy("123456");
            //insertSelective空属性会使用数据默认值
            Integer result = gUUserMapper.insertSelective(userVO);
            if(result !=null && result == 1){
                return new GeneralVO(ErrorListEnum.ERROR_LIST_SUCCESS,null);
            }
            else{
                return new GeneralVO(ErrorListEnum.ERROR_LIST_FAIL,null);
            }
        }else{
            userVO.setUpdateOn(new Date());
            userVO.setUpdateBy("123456");
            //insertSelective空属性会使用数据默认值
            Integer result = gUUserMapper.updateByPrimaryKeySelective(userVO);
            if(result != null && result == 1){
                return new GeneralVO(ErrorListEnum.ERROR_LIST_SUCCESS,null);
            }else{
                return new GeneralVO(ErrorListEnum.ERROR_LIST_FAIL,null);
            }
        }
    }

    /**
     * 保存用户信息
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public GeneralVO deleteUser(@RequestBody UserVO userVO) {
            userVO.setIsDelete(FlagListEnum.FLG_LIST_DELETED.getKey());
            userVO.setUpdateOn(new Date());
            userVO.setUpdateBy("123456");
            Integer result = gUUserMapper.updateByPrimaryKeySelective(userVO);
            if(result != null && result == 1){
                return new GeneralVO(ErrorListEnum.ERROR_LIST_SUCCESS,null);
            }
            else{
                return new GeneralVO(ErrorListEnum.ERROR_LIST_FAIL,null);
            }
        }
    }



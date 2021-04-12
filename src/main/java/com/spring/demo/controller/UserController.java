package com.spring.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.demo.entity.dto.UserDTO;
import com.spring.demo.entity.vo.UserVO;
import com.spring.demo.enu.ErrorListEnum;
import com.spring.demo.enu.FlagListEnum;
import com.spring.demo.dao.UserMapper;
import com.spring.demo.service.UserService;
import com.spring.demo.utils.GeneralVO;
import com.spring.demo.utils.ListPageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
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

    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/queryUsersByCondition",method = RequestMethod.POST)
    public ListPageVO queryUsersByCondition(@RequestBody UserDTO userDto) {
        Page<UserVO> page = new Page<UserVO>();
        page.setCurrent(userDto.getCurrent());
        page.setSize(userDto.getOffset());
        IPage<UserVO> result = userService.selectPage(page);
        return new ListPageVO(ErrorListEnum.ERROR_LIST_SUCCESS,result.getRecords(),null);
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
            userVO.setCreateOn(new Date());
            userVO.setUpdateOn(new Date());
            userVO.setIsDelete(FlagListEnum.FLG_LIST_NOT_DELETE.getKey());
            int userId = userMapper.selectCount(null) + 1;
            userVO.setUserId(userId);
            userVO.setUpdateBy("123456");
            userVO.setCreateBy("123456");
            Integer result = userMapper.insert(userVO);
            if(result !=null && result == 1){
                return new GeneralVO(ErrorListEnum.ERROR_LIST_SUCCESS,null);
            }
            else{
                return new GeneralVO(ErrorListEnum.ERROR_LIST_FAIL,null);
            }
        }else{
            userVO.setUpdateOn(new Date());
            userVO.setUpdateBy("123456");
            Integer result = userMapper.updateById(userVO);
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
            Integer result = userMapper.updateById(userVO);
            if(result != null && result == 1){
                return new GeneralVO(ErrorListEnum.ERROR_LIST_SUCCESS,null);
            }
            else{
                return new GeneralVO(ErrorListEnum.ERROR_LIST_FAIL,null);
            }
        }
    }



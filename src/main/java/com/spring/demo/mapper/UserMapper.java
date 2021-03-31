package com.spring.demo.mapper;

import com.spring.demo.entity.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 用户映射类
 * @author  milo
 * @date 2018-09-26
 */
public interface UserMapper{
    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @Select("select id,user_name as userName,province from users where id = #{id}")
    List<UserVO> queryUsersById(@Param("id") String id);

    /**
     * 根据用户名称查询用户信息
     * @param userName
     * @return
     */
    @Select("select id,user_name as userName from users where user_name like concat('%',#{userName},'%')")
    List<UserVO> queryUsersByName(@Param("userName") String userName);
}

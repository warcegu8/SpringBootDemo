package com.spring.demo.entity.dto;

import lombok.Data;

/**
 * 用户数据传输对象
 * @author  milo
 * @date 2018-09-26
 */
@Data
public class UserDTO{
    /**
     * 数据库主键
     */
    private String id;
    /**
     * 用户昵称
     */
    private String userName;
}

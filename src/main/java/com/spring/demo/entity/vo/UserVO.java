package com.spring.demo.entity.vo;

import lombok.Data;

/**
 * 用户实体类
 * @author  milo
 * @date 2018-09-26
 */
@Data
public class UserVO {
    /**
     * 数据库主键
     */
    private String id;

    /**
     * 用户名称
     */
    private String userName;
}

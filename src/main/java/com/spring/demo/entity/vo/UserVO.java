package com.spring.demo.entity.vo;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户实体类
 * @author  milo
 * @date 2018-09-26
 */
@Data
@Table(name="users")
public class UserVO {
    /**
     * 数据库主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;
}

package com.spring.demo.entity.dto;

import com.spring.demo.utils.PageEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户数据传输对象
 * @author  milo
 * @date 2018-09-26
 */
@Data
public class UserDTO extends PageEntity{

    /**
     * 数据库主键
     */
    private String id;
    /**
     * 业务主键
     */
    private Integer userId;
    /**
     * 用户昵称
     */
    private String userName;
}

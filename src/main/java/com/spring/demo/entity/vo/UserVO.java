package com.spring.demo.entity.vo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author  milo
 * @date 2018-09-26
 */
@Data
@Table(name="users")
public class UserVO implements Serializable {

    /**
     * 数据库主键
     */
    @Id
    private String id;

    /**
     * 业务主键
     */
    @Column(name="user_id")
    private Integer userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 创建时间
     */
    @Column(name="create_on")
    private Date createOn;

    /**
     * 创建人
     */
    @Column(name="create_by")
    private String createBy;

    /**
     * 修改时间
     */
    @Column(name="update_on")
    private Date updateOn;

    /**
     * 修改人
     */
    @Column(name="update_by")
    private String updateBy;

    /**
     * 删除标志，0代表未删除，1代表已删除
     */
    @Column(name="is_delete")
    private Integer isDelete;
}

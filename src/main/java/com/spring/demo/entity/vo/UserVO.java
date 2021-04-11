package com.spring.demo.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author  milo
 * @date 2018-09-26
 */
@Data
@TableName("users")
public class UserVO implements Serializable {

    /**
     * 数据库主键
     */
    @TableId(value = "id",type = IdType.UUID)
    private String id;

    /**
     * 业务主键
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 创建时间
     */
    @TableField("create_on")
    private Date createOn;

    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 修改时间
     */
    @TableField("update_on")
    private Date updateOn;

    /**
     * 修改人
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 删除标志，0代表未删除，1代表已删除
     */
    @TableField("is_delete")
    private Integer isDelete;
}

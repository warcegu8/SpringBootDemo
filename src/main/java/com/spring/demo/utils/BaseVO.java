package com.spring.demo.utils;

import com.google.gson.annotations.Expose;
import lombok.Data;

/**
 * 基本输出格式
 * @author  milo
 * @date 2018-09-26
 */
@Data
public class BaseVO {
    /**
     * 返回码
     */
    @Expose
    private int code;
    /**
     * 返回信息
     */
    @Expose
    private String msg;

    /**
     * 含参构造器
     * @param code
     * @param msg
     */
    public BaseVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 无参构造器
     */
    public BaseVO() {
    }
}

package com.spring.demo.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.annotations.Expose;
import com.spring.demo.enu.ErrorListEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页对象
 * @author  milo
 * @date 2018-09-26
 * @param <T>
 */
public class ListPageVO<T> extends BaseVO {
    private static final String KEY_ROWS = "rows";
    private static final String KEY_PAGE = "page";
    @Expose
    private T body;

    public ListPageVO() {
    }

    public ListPageVO(int code, String msg, List<T> rows, Page page, Map<String, Object> retMap) {
        this.setCode(code);
        this.setMsg(msg);
        Map<String, Object> bodyMap = new HashMap(4);
        bodyMap.put("rows", rows);
        bodyMap.put("page", page);
        if (null != retMap && retMap.size() > 0) {
            bodyMap.putAll(retMap);
        }
        this.setBody((T) bodyMap);
    }

    public ListPageVO(int code, String msg, List<T> rows, Page page) {
        this(code, msg, rows, page, (Map)null);
    }

    public ListPageVO(ErrorListEnum listEnum, List<T> rows, Page page) {
        this(listEnum.getKey(), listEnum.getValue(), rows, page);
    }

    public T getBody() {
        return this.body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ListPageVO{body=" + this.body + '}';
    }
}

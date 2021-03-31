package com.spring.demo.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Druid 配置类
 * 登录监控界面时，要加上项目名称“http://127.0.0.1:8081/springBootDemo/druid/sql.html”
 * @author  milo
 */
@WebServlet(urlPatterns = "/druid/*",initParams= {
         @WebInitParam(name = "allow", value = "127.0.0.1"),
         @WebInitParam(name="loginUsername",value="admin"),// 用户名
         @WebInitParam(name="loginPassword",value="123"),// 密码
         @WebInitParam(name="resetEnable",value="false")
         })
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = 1L;
}


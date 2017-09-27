package com.tedu.web;

import com.tedu.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制层
 * 服务器端的servlet
 * 接受注册页面提交的数据，并插入到数据库中
 */
public class RegisterServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("启动成功"); //Test
        // 设置中文编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
        // 接受register.jsp页面提交过来的表单数据
        String email = req.getParameter("email");
        String nickName = req.getParameter("nickName");
        String password = req.getParameter("password");
//        System.out.println(email + nickName + password); // Test
        // 调用模型层，将邮箱、昵称、密码插入到数据库中
        UserDao.InsertRegistedInfo(email,nickName,password);
        // 插入成功后 跳转至login.jsp中 （请求重定向：servlet已经完成任务，需要跳转至其他页面使用请求重定向[不带object]）
        resp.sendRedirect("/login.jsp");

    }
}

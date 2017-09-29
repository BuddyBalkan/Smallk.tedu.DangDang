package com.tedu.web;

import com.tedu.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 控制层
 * 服务器端 在register.jsp上用于检查所需要注册的邮箱是否被注册过
 */
public class CheckEmailServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Hi."); // Test
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
//        String s = req.getParameter("email");
//        System.out.println(s); // Test
//        System.out.println(UserDao.getUserCellsByEmail(req.getParameter("email"))); // Test
        PrintWriter out = resp.getWriter();
//        out.println(UserDao.getUserCellsByEmail(req.getParameter("email")));
        if (UserDao.getUserCellsByEmail(req.getParameter("email"))){// true表示数据库中已经存在该Email 不能再注册
            out.println("1");
        }else {
            out.println("0");
        }



    }
}

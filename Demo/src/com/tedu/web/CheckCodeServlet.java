package com.tedu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 控制层
 * 服务器端的一个servlet 用于检查验证码输入是否正确
 */
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      System.out.println("Hi");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
        PrintWriter out = resp.getWriter();
        String verificationCode = req.getParameter("verificationCode");
        HttpSession session = req.getSession();
        if ((session.getAttribute("verificationCode")).equals(verificationCode)){
            out.println("1");
        }else {
            out.println("0");
        }
    }


}

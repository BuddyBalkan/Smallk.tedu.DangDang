package com.tedu.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by SmallK on 2017/9/21.
 * 服务器端的一个Servlet
 * 当浏览器向该Servlet发送请求时，该Servlet会向页面响应Hello内容
 */
public class HelloServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HttpServletRequest 用于接受浏览器端发送过来的请求
        // HttpServletResponse 用于向浏览器端响应的

        PrintWriter printWriter = resp.getWriter();
        //PrintWriter的功能是向页面写数据、内容
        printWriter.print("<h1>Hello</h1>");
        printWriter.print("<div style='color: #f92690 ;font-size :50'>today is a nice day</div>");
    }
}

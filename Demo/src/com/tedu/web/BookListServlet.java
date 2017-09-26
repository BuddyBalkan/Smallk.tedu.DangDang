package com.tedu.web;

import com.tedu.bean.DBook;
import com.tedu.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by SmallK on 2017/9/26.
 * 服务器端的一个servlet    将d_book中的所有图书显示在页面上
 */
public class BookListServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决页面向服务器端发送数据中含有编码格式错误
        req.setCharacterEncoding("utf-8");
        // 解决服务器向浏览器端响应中含有编码格式错误
        resp.setContentType("text/html;charset=utf-8");

        // servlet 属于控制层负责调用模型层 获取模型层返回的结果。
        ArrayList<DBook> books = BookDao.getAllBooks();
        // 将模型层的返回的结果，转发给页面，由页面完成显示功能
        req.setAttribute("bs",books);
        req.getRequestDispatcher("booklist.jsp").forward(req,resp);// 在完成一整个HTTP事务使用的都是同一个req和resp
//        // 1、使用JDBC连接数据库，查询出结果集
//        Connection connection = DBUtil.getConnection();
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement("SELECT * FROM d_book");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            DBUtil.Close(preparedStatement, connection);
//        }
//        // 2、将结果集显示在booklist.html页面上
    }
}

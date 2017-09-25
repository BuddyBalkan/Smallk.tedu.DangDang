package com.tedu.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by SmallK on 2017/9/25.
 * 专门用于接受从/t_emp页面中传来的删除请求，并执行JDBC的删除操作，最后将执行结果显示在页面上
 */
public class EmpDeleteServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.print("已接受到删除请求");
        // 接受到由浏览器端传递过来的参数
        String id = req.getParameter("id");//获得参数
        // 1、使用JDBC 对数据库中的进行删除操作
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM t_emp WHERE id = ?");
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 2、通过重新定向技术返回原界面
        resp.sendRedirect("/t_emp");
    }

}

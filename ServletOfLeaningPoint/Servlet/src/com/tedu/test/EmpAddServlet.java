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
 * 1.接受addEmp.html的提交请求 并接受其传输的数据
 * 2.将接受到的表单数据通过JDBC向数据库中插入该数据
 * 3.当插入数据成功后 该servlet将转向t_empServlet并将其显示在浏览器
 */
public class EmpAddServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] infos = new String[5];
        infos[0] = req.getParameter("id");
        infos[1] = req.getParameter("password");
        infos[2] = req.getParameter("name");
        infos[3] = req.getParameter("birthday");
        infos[4] = req.getParameter("salary");
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO t_emp (id,password,name,birthday,salary) " +
                    "VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1,Integer.parseInt(infos[0]));
            preparedStatement.setString(2,infos[1]);
            preparedStatement.setString(3,infos[2]);
            preparedStatement.setString(4,infos[3]);
            preparedStatement.setDouble(5,Double.parseDouble(infos[4]));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.Close(connection,preparedStatement);
        }
        resp.sendRedirect("/t_emp");


    }
}

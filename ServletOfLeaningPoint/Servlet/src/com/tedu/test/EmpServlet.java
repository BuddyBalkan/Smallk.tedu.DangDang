package com.tedu.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SmallK on 2017/9/21.
 * 该类为服务器上的一个Servlet，用于将数据库中的数据查询出来，并显示在浏览器页面上。
 */
public class EmpServlet extends HttpServlet{
    /**
     * 将MySQL中的数据查询出来
     * 将查询出来的数据显示在浏览器页面上
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM t_emp");
            resultSet = preparedStatement.executeQuery();

            PrintWriter out = resp.getWriter();
            out.println("<table border=\"1\" cellspacing=\"0\" align=\"center\" width=\"60%\">\n" +
                    "\t\t<tr align=\"center\">\n" +
                    "\t\t\t<td>id</td>\n" +
                    "\t\t\t<td>password</td>\n" +
                    "\t\t\t<td>name</td>\n" +
                    "\t\t\t<td>birthday</td>\n" +
                    "\t\t\t<td>salary</td>\n" +
                    "<td>operation</td>"+
                    "\t\t</tr>\n");

            while (resultSet.next()){
                out.println("<tr align=\"center\">\n" +
                        "\t\t\t<td>" + resultSet.getInt("id") +
                        "</td>\n" +
                        "\t\t\t<td>" + resultSet.getString("password") +
                        "</td>\n" +
                        "\t\t\t<td>" + resultSet.getString("name") +
                        "</td>\n" +
                        "\t\t\t<td>" + resultSet.getDate("birthday") +
                        "</td>\n" +
                        "\t\t\t<td>" + resultSet.getDouble("salary") +
                        "</td>\n" +
                        "<td>\n" +
                        "\t\t\t\t<a href=\"/delete?id=" + resultSet.getInt("id") +
                        "\"><input type=\"button\" value=\"delete\"></a>\n" +
                        "\t\t\t</td>"+
                        "\t\t</tr>");
            }
            out.println("\t</table>");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null){
                    resultSet.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("关闭连接失败");
            }
        }
    }
}

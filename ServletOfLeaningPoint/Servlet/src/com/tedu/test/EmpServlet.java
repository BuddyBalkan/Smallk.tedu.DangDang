package com.tedu.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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


        PrintWriter out = resp.getWriter();
        out.println("<table>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>id</td>\n" +
                "\t\t\t<td>password</td>\n" +
                "\t\t\t<td>name</td>\n" +
                "\t\t\t<td>birthday</td>\n" +
                "\t\t\t<td>salary</td>\n" +
                "\t\t</tr>\n" +
                "\t</table>");
    }
}

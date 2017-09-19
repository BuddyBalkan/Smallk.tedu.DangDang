package com.tedu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by SmallK on 2017/9/19.
 * 使用JDBC从数据库中删除数据
 */
public class TestDelete {
    static final String DB_Driver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dangdangwan";
    static final String DB_UserName = "root";
    static final String DB_UserPassword = "123";

    public static void main(String[] args) throws Exception {
        Class.forName(DB_Driver);

        Connection connection = DriverManager.getConnection(DB_URL,DB_UserName,DB_UserPassword);

        // 防止SQL注入
//        String sql = "DELETE FROM t_emp WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM t_emp WHERE id = ?");
        preparedStatement.setInt(1,1001);
        preparedStatement.executeUpdate();//当对表执行delete insert update时使用该方法

        connection.close();

    }
}

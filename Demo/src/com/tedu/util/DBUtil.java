package com.tedu.util;

import java.sql.*;

/**
 * Created by SmallK on 2017/9/19.
 * 用于封装 获得数据库链接的方法
 */
public class DBUtil {
    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dang";
    static final String DB_userName = "root";
    static final String DB_userPassword = "123";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL,DB_userName,DB_userPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("获取连接数据库驱动失败，可能驱动地址定义错了。");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取链接失败，可能用户密码已修改、用户名已修改、数据库名已修改、数据库端口已修改。");
        }
        return connection;
    }
    public static void Close(PreparedStatement preparedStatement, Connection connection){
        try {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            Close(preparedStatement, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

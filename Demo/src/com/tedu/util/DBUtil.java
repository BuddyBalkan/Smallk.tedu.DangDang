package com.tedu.util;

import java.sql.*;

/**
 * Created by SmallK on 2017/9/19.
 * 用于封装 获得数据库链接的方法
 */
public class DBUtil {
    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dang";
    static final String CharsetUTF8 ="?useUnicode=true&characterEncoding=utf8";// 用于设置数据库的编码
    static final String DB_userName = "root";
    static final String DB_userPassword = "123";

    /**
     * 如名 获取数据库连接
     * @return 返回连接类型
     */
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

    /**
     * 如名 封装安全关闭方法 用于增删改操作
     * @param preparedStatement 需要关闭的preparedStatement
     * @param connection 需要关闭的connection
     */
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

    /**
     * 如名 安全关闭连接等 用于查询数据操作
     * @param resultSet 需要关闭的resultSet
     * @param preparedStatement 需要关闭的prepareStatement
     * @param connection 需要关闭的connection
     */
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

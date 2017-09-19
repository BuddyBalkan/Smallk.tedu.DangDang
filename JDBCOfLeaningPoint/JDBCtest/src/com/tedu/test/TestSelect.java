package com.tedu.test;

import java.sql.*;
import java.util.Date;

/**
 * Created by SmallK on 2017/9/19.
 * 使用JDBC从MySQL数据库中查询数据
 */
public class TestSelect {
    public static void main(String[] args) throws Exception {
//        // 1.注册加载驱动 (mysql-xx.jar)
//        Class.forName("com.mysql.jdbc.Driver");
//
//        // 2.获得数据库的链接 Connection
//        String userName = "root";
//        String userPassword = "123";
//        String DB_URL = "jdbc:mysql://localhost:3306/dangdangwan";
//        //               协议名：子协议名：//主机：端口/数据库库名
//        Connection connection = DriverManager.getConnection(DB_URL,userName,userPassword);
//        System.out.print(connection);
        Connection connection = DBUtil.getConnection();// 使用该方法将以上操作替代
        // 3.获得PreparedStatement对象，预执行SQL编译
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM t_emp");
        ResultSet resultSet = preparedStatement.executeQuery();
//          以下是另一种方法 不知道区别
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM t_emp ");

        // 4.执行SQL语句，获得结果集,并循环输出结果集
        System.out.println("\t\t\t\t\tid\t\tname\tpassword\tbirthday\tsalary");
        while (resultSet.next()){   // ResultSet.next()  用于判断数据库执行sql语句之后的结果集里是否有数据
            Integer index = resultSet.getRow();
            Integer t_emp_id = resultSet.getInt("id");
            String t_emp_password = resultSet.getString("password");
            String t_emp_name = resultSet.getString("name");
            Date t_emp_birthday = resultSet.getDate("birthday");
            Double t_emp_salary = resultSet.getDouble("salary");

            System.out.println("resultSet[row]:" + index + "\t" + t_emp_id + "\t" + t_emp_name + "\t" + t_emp_password + "\t"
                    + t_emp_birthday + "\t" + t_emp_salary);
        }

        // 5.关闭数据库的链接
        if (connection != null){
            connection.close();
        }
        if (preparedStatement != null){
            preparedStatement.close();
        }
        if (resultSet != null){
            resultSet.close();
        }
    }
}

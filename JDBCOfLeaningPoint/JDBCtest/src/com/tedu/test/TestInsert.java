package com.tedu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by SmallK on 2017/9/19.
 * 使用JDBC完成插入操作
 */
public class TestInsert {
    public static void main(String[] args) throws Exception {
        Connection connection = DBUtil.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO t_emp VALUES (?,?,?,?,?)");

        preparedStatement.setInt(1,1005);
        preparedStatement.setString(2,"987654321");
        preparedStatement.setString(3,"ZhaoLiu");
        preparedStatement.setInt(4,20170919);
        preparedStatement.setDouble(5,5600.89);

        preparedStatement.executeUpdate();

        connection.close();
        System.out.println("插入成功。");
    }

}

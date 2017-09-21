package com.tedu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by SmallK on 2017/9/19.
 * 完成JDBC对数据的修改
 * 将id=1001的这条数据的密码修改为666666，工资修改为20000.5
 */
public class TestUpdate {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE t_emp SET password = ?,salary = ? WHERE id = ?");
        preparedStatement.setString(1,"666666");
        preparedStatement.setDouble(2,20000.5);
        preparedStatement.setInt(3,1001);

        preparedStatement.executeUpdate();
        System.out.println("已修改成功。");
        connection.close();
    }
}

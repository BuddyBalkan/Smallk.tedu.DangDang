package com.tedu.test;

import java.sql.*;

/**
 * Created by SmallK on 2017/9/19.
 * 完成JDBC对某一数据的查询
 * 根据条件id 查询id为1001的这条数据
 */
public class TestSelectById {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtil.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM t_emp WHERE id = ?");
        preparedStatement.setInt(1, 1001);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            java.util.Date birthday = resultSet.getDate("birthday");
            Double salary = resultSet.getDouble("salary");
            System.out.println("获取单条结果如下：");
            System.out.println("id: " + id + ", password:" + password + ", name:" + name + ", birthday:"
                    + birthday + ", salary:" + salary);
        }
        connection.close();

    }
}

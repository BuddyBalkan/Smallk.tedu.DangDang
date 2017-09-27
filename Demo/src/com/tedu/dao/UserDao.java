package com.tedu.dao;

import com.tedu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 模型层 封装对d_user表的操作
 */
public class UserDao {
    /**
     * 该方法封装插入数据操作
     * @param email 用户名账户邮箱
     * @param nickName 用户名昵称
     * @param password 用户名密码
     */
    public static void InsertRegistedInfo(String email, String nickName, String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO d_user (email, nickname, password) VALUES (?,?,?)");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,nickName);
            preparedStatement.setString(3,password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入数据失败，可能是sql语句不符合语法");
        }finally {
            DBUtil.Close(preparedStatement,connection);
        }
    }

//    /**
//     * Test
//     * @param args
//     */
//    public static void main(String[] args){
//        InsertRegistedInfo("lxk1113@sina.com", "张晓锴", "1113");
//    }
}

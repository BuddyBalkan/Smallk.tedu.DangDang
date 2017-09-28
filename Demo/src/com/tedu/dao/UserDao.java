package com.tedu.dao;

import com.tedu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    /**
     * 在register.jsp的检查Email中异步刷新 判断用户账户是否被注册过
     * @param email 用于查询条件的email
     * @return true 表示该邮箱已经被注册（查询出结果）  false 表示该邮箱未被注册（未查询出结果）
     */
    public static boolean getUserCellsByEmail(String email){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM d_user WHERE email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.Close(resultSet, preparedStatement, connection);
        }
        return false;
    }

//    /**
//     * Test
//     * @param args
//     */
//    public static void main(String[] args){
//        InsertRegistedInfo("lxk1113@sina.com", "张晓锴", "1113");
//    }
}

package com.tedu.dao;

import com.tedu.bean.DBook;
import com.tedu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 * Created by SmallK on 2017/9/26.
 * 模型层  表示dao工厂 用于加工d_book表的增删改查的操作
 * 1. 将所有d_book表中所有数据查询出来
 * 2.
 */
public class BookDao {
    public static ArrayList<DBook> getAllBooks(){
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<DBook> books = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM d_book");
            resultSet = preparedStatement.executeQuery();
            // 用循环将数据库中的所有d_book数据存入到books（ArrayList）中
            while (resultSet.next()){
                DBook book = new DBook(resultSet.getInt("id"), resultSet.getString("product_name"),
                        resultSet.getString("description"), resultSet.getDouble("fixed_price"),
                        resultSet.getDouble("dang_price"), resultSet.getString("product_pic"),
                        resultSet.getString("author"), resultSet.getString("publishing"),
                        new Date(resultSet.getLong("publish_time")), //(如何用long类型的数据表示或解析成Date类型 解决：将long类型的数据作为参数传入Date的构造器中即可自动解析)
                        resultSet.getString("author_summary"), resultSet.getString("catalogue"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.Close(resultSet, preparedStatement, connection);
        }
        return books;
    }
}

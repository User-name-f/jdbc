package com.mky.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pojo.admin;
import util.C3p0Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
    public boolean findByUsername(String name) throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
//        String username = "root";
//        String password = "123456";
//
//        Connection connection = DriverManager.getConnection(url, username, password);


//        BasicDataSource bds = new BasicDataSource();
//        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        bds.setUrl("jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8");
//        bds.setUsername("root");
//        bds.setPassword("123456");
//        bds.setInitialSize(20);
//        bds.setMinIdle(10);
//        Connection connection = bds.getConnection();
//
//
//
//        String sql = "select count(*) from t_admin where username=?";
//        PreparedStatement stmt = connection.prepareStatement(sql);
//        stmt.setString(1, name);
//
//        ResultSet res = stmt.executeQuery();
//       if(res.next()) {
//            return res.getInt(1) > 0;
//        }
//       return false;

        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select * from t_admin where username=?";
        admin it =(admin) runner.query(sql, new BeanHandler(admin.class),name);
        if(it==null)
            return false;
        return true;
    }
}

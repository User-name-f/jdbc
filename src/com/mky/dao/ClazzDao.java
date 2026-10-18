package com.mky.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import pojo.Clazz;
import pojo.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClazzDao {

    /**
     * 查询 t_clazz 里的所有班级，用于“添加学生”页面上的班级下拉框。
     */
    public List<Clazz> findAllClazz() throws Exception
    {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
//        String username = "root";
//        String password = "123456";
//
//        Connection connection = DriverManager.getConnection(url, username, password);


        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8");
        cpds.setUser("root");
        cpds.setPassword("123456");

        cpds.setInitialPoolSize(20);
        Connection connection = cpds.getConnection();


        String sql = "select id, clazz_name, college, major, grade from t_clazz order by id";
        PreparedStatement stmt = connection.prepareStatement(sql);

        List<Clazz> list = new ArrayList<>();
        ResultSet res = stmt.executeQuery();
        while (res.next())
        {
            Clazz clazz = new Clazz();
            clazz.setId(res.getInt("id"));
            clazz.setClazz_name(res.getString("clazz_name"));
            clazz.setCollege(res.getString("college"));
            clazz.setMajor(res.getString("major"));
            clazz.setGrade(res.getInt("grade"));
            list.add(clazz);
        }

        stmt.close();
        connection.close();
        return list;
    }

    public Clazz findById(Integer id)throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from t_clazz where id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1,id);
        ResultSet res = stmt.executeQuery();
        Clazz clazz = new Clazz();
        if(res.next()) {
            clazz.setId(res.getInt("id"));
            clazz.setClazz_name(res.getString("clazz_name"));
            clazz.setCollege(res.getString("college"));
            clazz.setMajor(res.getString("major"));
            clazz.setGrade(res.getInt("grade"));
        }
        connection.close();
        stmt.close();
        return clazz;
    }
}

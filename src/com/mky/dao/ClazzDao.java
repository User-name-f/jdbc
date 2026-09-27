package com.mky.dao;

import pojo.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClazzDao {

    public List<student> findAll() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from student ";
        PreparedStatement stmt = connection.prepareStatement(sql);

        List<student> list = new ArrayList<>();
        ResultSet res = stmt.executeQuery();
        while(res.next()) {
            student stu = new student();
            stu.setId(res.getInt("id"));
            stu.setStudent_no(res.getString("student_no"));
            stu.setName(res.getString("name"));
            stu.setGender(res.getString("gender"));
            stu.setCollege(res.getString("college"));
            stu.setMajor(res.getString("major"));
            stu.setClazz_name(res.getString("clazz_name"));
            stu.setStatus(res.getInt("status"));
            stu.setEnroll_year(res.getInt("enroll_year"));
            stu.setPhone(res.getString("phone"));
            list.add(stu);
        }
        connection.close();
        stmt.close();
        return list;
    }

    public student findById(Integer id)throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from student where student_no=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1,id);
        student stu = new student();
        ResultSet res = stmt.executeQuery();
        while(res.next()) {
            stu.setId(res.getInt("id"));
            stu.setStudent_no(res.getString("student_no"));
            stu.setName(res.getString("name"));
            stu.setGender(res.getString("gender"));
            stu.setCollege(res.getString("college"));
            stu.setMajor(res.getString("major"));
            stu.setClazz_name(res.getString("clazz_name"));
            stu.setStatus(res.getInt("status"));
            stu.setEnroll_year(res.getInt("enroll_year"));
            stu.setPhone(res.getString("phone"));
        }
        connection.close();
        stmt.close();
        return stu;
    }
}

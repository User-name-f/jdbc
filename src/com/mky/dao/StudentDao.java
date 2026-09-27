package com.mky.dao;

import pojo.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public void insert(student stu) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "insert into t_student(student_no, name, gender, class_id, phone, enroll_year, status) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1,stu.getStudent_no());
        stmt.setString(2,stu.getName());
        stmt.setString(3,stu.getGender());
        stmt.setString(5,stu.getPhone());
        stmt.setInt(6,stu.getEnroll_year());
        stmt.setInt(7,stu.getStatus());
        stmt.setInt(4,stu.getClazz_id());

        int i=stmt.executeUpdate();
        System.out.println("改变了："+i);
        connection.close();
        stmt.close();
    }

    public void update(student stu)throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "update t_student set name=?, gender=?, class_id=?, phone=?, enroll_year=?, status=? where student_no=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1,stu.getName());
        stmt.setString(2,stu.getGender());
        stmt.setString(4,stu.getPhone());
        stmt.setInt(5,stu.getEnroll_year());
        stmt.setInt(6,stu.getStatus());
        stmt.setInt(3,stu.getClazz_id());

        int i=stmt.executeUpdate();
        System.out.println("改变了："+i);
        connection.close();
        stmt.close();
    }

    public void deleteById(String id)throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "delete from t_student where student_no=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1,id);

        int i=stmt.executeUpdate();
        System.out.println("改变了："+i);
        connection.close();
        stmt.close();
    }

    public student findById(String id) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from t_student where student_no=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1,id);
        student stu =new student();
        ResultSet res =stmt.executeQuery();

        while(res.next())
        {
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

    public List<student> findAll() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from t_student";
        PreparedStatement stmt = connection.prepareStatement(sql);

        List<student> list = new ArrayList<>();
        ResultSet res =stmt.executeQuery();

        while(res.next())
        {
            student stu =new student();
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
}

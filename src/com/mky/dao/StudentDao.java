package com.mky.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.student;
import util.C3p0Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<student> search(String keyword, String college) throws Exception
    {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
//        String username = "root";
//        String password = "123456";
//
//        Connection connection = DriverManager.getConnection(url, username, password);
//
//        StringBuilder sql = new StringBuilder();
//        sql.append("select s.id, s.student_no, s.name, s.gender, s.phone, s.enroll_year, s.status, ");
//        sql.append("c.clazz_name, c.college, c.major ");
//        sql.append("from t_student s left join t_clazz c on s.clazz_id = c.id ");
//        sql.append("where s.name =? and  c.college=?");
//
//        PreparedStatement stmt = connection.prepareStatement(sql.toString());
//        stmt.setString(1,keyword);
//        stmt.setString(2,college);
//
//        List<student> list = new ArrayList<>();
//        ResultSet res = stmt.executeQuery();
//
//        while (res.next())
//        {
//            student stu = new student();
//            stu.setId(res.getInt("id"));
//            stu.setStudent_no(res.getString("student_no"));
//            stu.setName(res.getString("name"));
//            stu.setGender(res.getString("gender"));
//            stu.setCollege(res.getString("college"));
//            stu.setMajor(res.getString("major"));
//            stu.setClazz_name(res.getString("clazz_name"));
//            stu.setStatus(res.getInt("status"));
//            stu.setEnroll_year(res.getInt("enroll_year"));
//            stu.setPhone(res.getString("phone"));
//            list.add(stu);
//        }
//
//        stmt.close();
//        connection.close();
//        return list;
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "select s.id, s.student_no, s.name, s.gender, s.phone, s.enroll_year, s.status, " +
                "c.clazz_name, c.college, c.major " +
                "from t_student s left join t_clazz c on s.clazz_id = c.id " +
                "where s.name =? and  c.college=?";
        List<student> list = (List)runner.query(sql,new BeanListHandler(student.class),keyword,college);
        return list;
    }

    public void insert(student stu) throws Exception
    {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
//        String username = "root";
//        String password = "123456";
//
//        Connection connection = DriverManager.getConnection(url, username, password);
//
//        String sql = "insert into t_student(student_no, name, gender, clazz_id, phone, enroll_year, status) VALUES(?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement stmt = connection.prepareStatement(sql);
//
//        stmt.setString(1,stu.getStudent_no());
//        stmt.setString(2,stu.getName());
//        stmt.setString(3,stu.getGender());
//        stmt.setString(5,stu.getPhone());
//        stmt.setInt(6,stu.getEnroll_year());
//        stmt.setInt(7,stu.getStatus());
//        stmt.setInt(4,stu.getClazz_id());

//        int i=stmt.executeUpdate();


        QueryRunner runner =new QueryRunner(C3p0Utils.getDataSource());
        String sql = "insert into t_student(student_no, name, gender, clazz_id, phone, enroll_year, status) VALUES(?, ?, ?, ?, ?, ?, ?)";
        int i=runner.update(sql,stu.getStudent_no(),stu.getName(),stu.getGender(),stu.getClazz_id(),stu.getPhone(),stu.getEnroll_year(),stu.getStatus());



        System.out.println("改变了："+i);

//        stmt.close();
//        connection.close();
    }

    public void update(student stu)throws Exception
    {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
//        String username = "root";
//        String password = "123456";
//
//        Connection connection = DriverManager.getConnection(url, username, password);
//
//        String sql = "update t_student set name=?, gender=?, clazz_id=?, phone=?, enroll_year=?, status=? where student_no=?";
//        PreparedStatement stmt = connection.prepareStatement(sql);
//
//        stmt.setString(1,stu.getName());
//        stmt.setString(2,stu.getGender());
//        stmt.setString(4,stu.getPhone());
//        stmt.setInt(5,stu.getEnroll_year());
//        stmt.setInt(6,stu.getStatus());
//        stmt.setInt(3,stu.getClazz_id());
//
//        int i=stmt.executeUpdate();


        QueryRunner runner =new QueryRunner(C3p0Utils.getDataSource());
        String sql = "update t_student set name=?, gender=?, clazz_id=?, phone=?, enroll_year=?, status=? where student_no=?";
        int i=runner.update(sql,stu.getName(),stu.getGender(),stu.getClazz_id(),stu.getPhone(),stu.getEnroll_year(),stu.getStatus(),stu.getStudent_no());



        System.out.println("改变了："+i);
//        connection.close();
//        stmt.close();
    }

    public int deleteById(String id)throws Exception
    {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
//        String username = "root";
//        String password = "123456";
//
//        Connection connection = DriverManager.getConnection(url, username, password);
//
//        String sql = "delete from t_student where student_no=?";
//        PreparedStatement stmt = connection.prepareStatement(sql);
//
//        stmt.setString(1,id);
//
//        int i=stmt.executeUpdate();


        QueryRunner runner =new QueryRunner(C3p0Utils.getDataSource());
        String sql = "delete from t_student where student_no=?";
        return runner.update(sql,id);


//        System.out.println("改变了："+i);

//        stmt.close();
//        connection.close();
//        return i;
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

        String sql = "select s.id, s.student_no, s.name, s.gender, s.phone, s.enroll_year, s.status,c.clazz_name, c.college, c.major from t_student s left join t_clazz c on s.clazz_id = c.id ";
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

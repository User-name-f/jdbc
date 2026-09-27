package com.mky.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
    public boolean findByUsername(String name) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select count(*) from t_admin where username=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, name);

        ResultSet res = stmt.executeQuery();
        boolean is = false;
        while (res.next()) {
            is = true;
            break;
        }
        return is;
    }
}

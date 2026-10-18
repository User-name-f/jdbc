<%--
  Created by IntelliJ IDEA.
  User: mky
  Date: 2026/9/20
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Clazz" %>
<%@ page import="com.mky.dao.ClazzDao" %>
<%
    List<Clazz> clazzList = new ClazzDao().findAllClazz();
%>
<html>
<head>
    <title>add</title>
    <style>
        .form-table {
            width: 600px;
            margin: 30px auto;
            border-collapse: collapse;
        }
        .form-table th, .form-table td {
            border: 1px solid black;
            padding: 8px;
        }
        .form-table th {
            background-color: #4a86e8;
            color: black;
            text-align: center;
            font-size: 16px;
        }
        .form-table td.label {
            text-align: right;
            background-color: #f9f9f9;
        }
        .form-table input[type="text"] {
            width: 100%;
        }
        .form-table select {
            width: 100%;
        }
        .form-table td.buttons {
            text-align: center;
        }
    </style>
</head>
<body>
<form action="addStudent" method="post">
    <table class="form-table">
        <tr>
            <th colspan="2">▼添加/修改学生信息</th>
        </tr>
        <tr>
            <td class="label">学号：</td>
            <td><input type="text" name="student_no"></td>
        </tr>
        <tr>
            <td class="label">姓名：</td>
            <td><input type="text" name="name" ></td>
        </tr>
        <tr>
            <td class="label">性别：</td>
            <td>
                <input type="radio" name="gender" value="男">男
                <input type="radio" name="gender" value="女">女
            </td>
        </tr>
        <tr>
            <td class="label">班级：</td>
            <td>
                <select name="clazz_id">
                    <option value="">请选择班级</option>
                    <%
                        for (Clazz clazz : clazzList) {
                    %>
                    <option value="<%=clazz.getId()%>"><%=clazz.getClazz_name()%></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td class="label">电话：</td>
            <td><input type="text" name="phone" ></td>
        </tr>
        <tr>
            <td class="label">入学年：</td>
            <td><input type="text" name="enroll_year" ></td>
        </tr>
        <tr>
            <td class="label">状态：</td>
            <td>
                <select name="status">
                    <option value="">请选择状态</option>
                    <option value="1" >在读</option>
                    <option value="2" >休学</option>
                    <option value="3" >退学</option>
                    <option value="4" >毕业</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="buttons">
                <input type="submit" value="保存">
                <input type="button" value="返回" onclick="location.href='student'">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

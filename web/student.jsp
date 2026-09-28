<%--
  Created by IntelliJ IDEA.
  User: mky
  Date: 2026/9/20
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student</title>
    <style>
        table {
            margin: 0 auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #999;
            padding: 8px;
            text-align: center;
        }
        th { background-color: grey; }
        a { color: #0066cc; text-decoration: none; margin: 0 5px; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
<table>
    <tr>
        <th colspan="9" style="background-color:deepskyblue;"><h3>学籍列表</h3></th>
    </tr>

    <tr>
        <th colspan="9"  style="background-color:white;">
            姓名/学号：<input type="text" size="12">
            学院：<input type="text" size="12">
            <input type="button" value="查询">
            <input type="button" value="添加">
        </th>
    </tr>

    <tr>
        <th>序号</th><th>学号</th><th>姓名</th><th>性别</th>
        <th>学院</th><th>专业</th><th>班级</th><th>状态</th><th>操作</th>
    </tr>
    <tr>
        <td>1</td><td>2024010101</td><td>张三</td><td>男</td>
        <td>计算机学院</td><td>电子计算机工程</td><td>电计202401</td><td>在读</td>
        <td>
            <a href="addStudent.jsp">修改</a>
            <a href="#" onclick="return delConfirm()">删除</a>
        </td>
    </tr>
    <tr>
        <td>2</td><td>2024010102</td><td>李四</td><td>女</td>
        <td>计算机学院</td><td>电子计算机工程</td><td>电计202401</td><td>在读</td>
        <td>
            <a href="addStudent.jsp">修改</a>
            <a href="#" onclick="return delConfirm()">删除</a>
        </td>
    </tr>
</table>
    <script>
        function delConfirm() {
        return confirm("确认要删除？？");
        }
    </script>
</body>
</html>

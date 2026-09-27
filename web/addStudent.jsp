<%--
  Created by IntelliJ IDEA.
  User: mky
  Date: 2026/9/20
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </style>
</head>
<body>
<form action="#" method="post">
    <table class="form-table">
        <tr>
            <th colspan="2">▼添加/修改学生信息</th>
        </tr>
        <tr>
            <td class="label">学号：</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td class="label">姓名：</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td class="label">性别：</td>
            <td>
                <input type="radio" name="gender" >男
                <input type="radio" name="gender" >女
            </td>
        </tr>
        <tr>
            <td class="label">班级：</td>
            <td>
                <select>
                    <option>电计2401</option>
                    <option>电计2402</option>
                    <option>电计2403</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="label">电话：</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td class="label">入学年：</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td class="label">状态：</td>
            <td>
                <select>
                    <option>在读</option>
                    <option>休学</option>
                    <option>退学</option>
                    <option>毕业</option>
                </select>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

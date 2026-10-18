<%--
  Created by IntelliJ IDEA.
  User: mky
  Date: 2026/9/20
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.student" %>
<%@ page import="com.mky.dao.StudentDao" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<%!
    // 把数据库里的状态编号转成页面上显示的文字
    private String statusText(Integer status) {
        if (status == null) {
            return "";
        }
        switch (status) {
            case 1: return "在读";
            case 2: return "休学";
            case 3: return "退学";
            case 4: return "毕业";
            default: return String.valueOf(status);
        }
    }
%>


<%
    request.setCharacterEncoding("UTF-8");

    String deleteNo = request.getParameter("deleteNo");
    if (deleteNo != null && !deleteNo.trim().isEmpty()) {
        new StudentDao().deleteById(deleteNo.trim());
    }

    String keyword = request.getParameter("keyword");   // 姓名/学号
    String college = request.getParameter("college");   // 学院
//
    List<student> studentList = (List<student>) request.getAttribute("studentList");
    if (studentList == null) {
        try {
            studentList = new StudentDao().findAll();
            request.setAttribute("studentList",studentList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
%>
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
<table id="studentTable">
    <thead>
    <tr>
        <th colspan="11" style="background-color:deepskyblue;"><h3>学生列表</h3></th>
    </tr>

    <tr>
        <th colspan="11" style="background-color:white;">
            <form action="student" method="get">
                姓名/学号：<input type="text" name="keyword" size="12">
                学院：<input type="text" name="college" size="12">
                <input type="submit" value="查询">
                <input type="button" value="添加" onclick="location.href='addStudent.jsp'">
            </form>
        </th>
    </tr>

    <tr>
        <th>序号</th><th>学号</th><th>姓名</th><th>性别</th>
        <th>学院</th><th>专业</th><th>班级</th><th>状态</th><th>入学年</th><th>电话</th><th>操作</th>
    </tr>
    </thead>
    <tbody id="studentBody">

    <c:forEach var="stu" items="${studentList}">
    <tr>
        <td>${stu.id}</td>
        <td>${stu.student_no}</td>
        <td>${stu.name}</td>
        <td>${stu.gender}</td>
        <td>${stu.college}</td>
        <td>${stu.major}</td>
        <td>${stu.clazz_name}</td>
        <td>${stu.status}</td>
        <td>${stu.enroll_year}</td>
        <td>${stu.phone}</td>
        <td>
            <a href="addStudent.jsp">修改</a>
            <a href="student.jsp?deleteNo=${stu.student_no}"
            onclick="return confirm('确认要删除吗？');">删除</a>
        </td>
    </tr>
</c:forEach>
    </tbody>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: mky
  Date: 2026/9/13
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>登 录</title>
  </head>
  <body>
  <form action="login" method="post">
    <table border="1" align="center" cellspacing="0">
      <tr>
        <th colspan="2" bgcolor="#4a86e8">用户登录</th>
      </tr>
      <tr>
        <td align="right" width="50%">账号：</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td align="right">密码：</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="登 录">
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="checkbox" name="remember" value="1">
          一周免登录
        </td>
      </tr>
    </table>
  </form>
  </body>
</html>

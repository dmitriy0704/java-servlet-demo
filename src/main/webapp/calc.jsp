<%@ page import="dev.folomkin.javaservletdemo.Calculator" %><%--
  Created by IntelliJ IDEA.
  User: dmitriyfolomkin
  Date: 10.12.2025
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calc</title>
</head>
<body>
<h2>Square of 3 = <%= new Calculator().square(3) %>
</h2>
</body>
</html>

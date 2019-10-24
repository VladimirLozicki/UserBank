<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Users: vladimirlozickiy
  Date: 2019-08-09
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <style>
        .cube {
            float: left;
            width: 150px;
            height: 20px;
        }

    </style>
</head>
<body>
<form method="post" action="/rich">
    <div>
        <div class="cube" id="richest">More richest: ${name}</div>
        <input type="submit" class="input" value="get" id="rich">
    </div>
</form>

<form method="post" action="/all">
    <div>
        <div class="cube">Accounts sum: ${all} </div>
        <input type="submit" class="input" value="get">
    </div>
</form>

</body>
</html>

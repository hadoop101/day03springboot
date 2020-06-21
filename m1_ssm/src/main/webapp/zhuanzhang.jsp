<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/21
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/account/zhuanzhang" method="post">
        转出账户<input type="text" name="from"><br/>
        转入账户<input type="text" name="to"><br/>
        金额 <input type="text" name="vale"><br/>
        <input type="submit" name="开始"><br/>
    </form>
</body>
</html>

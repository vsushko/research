<%--
  Created by IntelliJ IDEA.
  User: vsa
  Date: 26.11.14
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spizza</title>
</head>
<body>
<h2>Thank you for your order!</h2>
<%-- возбуждает заключительное событие --%>
    <![CDATA[
        <a href="${flowExecutionUrl}&_eventId=finished">Finish</a>
    ]]>
</body>
</html>

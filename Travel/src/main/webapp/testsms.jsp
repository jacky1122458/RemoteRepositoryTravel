<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="https://api.kotsms.com.tw/kotsmsapi-1.php?username=s85761056&password=s2dgiixdl&dstaddr=${sms[0][5]}&
smbody=親愛的${sms[0][3]}，您好已接收到你的訂單已成團 訂購日期,金額為${sms[0][4]}">傳送</a>

<form method="get" action="<c:url value="/index.jsp"/>">
		<button name="back" value="back" >回首頁</button>
</form>
</body>
</html>

<%@page import="model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信箱驗證 10分鐘內有效</title>
</head>
<body>
<form action='<c:url value="/client/stu.controller" />'  method="get" >
<input type="text" name="stu" value="${SessionScope.s}">

<input type="submit" name="prodaction" value="驗證">

</form>
</body>
</html>
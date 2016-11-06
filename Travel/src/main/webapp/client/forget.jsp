<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("forgetok")!=null)
	{out.print("<script>alert('請至信箱查看新密碼並重新登入後再次修改密碼!');window.location.href='login.jsp'</script>");
	}
	session.removeAttribute("forgetok");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forget</title>
		<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/style.css" type="text/css">
		<link rel="stylesheet" href="../css/goldblack.css" type="text/css">
</head>
<body>
<form action="ForgetServlet" method="get">
<span>帳號
<input type="text" name="account" value="${param.account}"></span><span>${forget.account}${forget.nobean}</span><br>
<span>信箱
<input type="text" name="email" value="${param.email}"></span><span>${forget.email}</span><br>
<input type="submit" name="prodaction" value="找回密碼" style="position:relative;left:250px">
</form>
</body>
</html>
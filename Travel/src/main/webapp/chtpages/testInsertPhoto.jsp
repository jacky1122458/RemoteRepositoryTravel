<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value="/testInsertphoto.view" />" method="get">
<table>
	<tr>
		<td>HotelID : </td>
		<td><input type="text" name="hotelid" value="${param.hotelid}"></td>
		<td><span class="error">${error.hotelid}</span></td>
	</tr>
	<tr>
		<td>description : </td>
		<td><input type="text" name="description" value="${param.description}"></td>
		<td><span class="error">${error.description}</span></td>
	</tr>
	<tr>
		<td>　</td>
		<td align="right"><input type="submit" value="insert"></td>
	</tr>
</table>
</form>
<h3><a href="<c:url value="/chtpages/testIndex.jsp" />">testIndex</a></h3>
</body>
</html>
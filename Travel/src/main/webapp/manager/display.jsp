<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="../css/table.css" /> -->


<title>Display</title>
</head>
<body>

<h3>Select Product Table Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>memberid</th>
		<th>account</th>
		<th>password</th>
		<th>sex</th>
		<th>email</th>
		<th>birth</th>
		<th>cellphone</th>
		<th>address</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean" items="${select}">
		<c:url value="members.jsp" var="path">
			<c:param name="memberid" value="${bean.memberid}" />
			<c:param name="account" value="${bean.account}" />
			<c:param name="password" value="${bean.password}" />
			<c:param name="sex" value="${bean.sex}" />
			<c:param name="email" value="${bean.email}" />
			<c:param name="birth" value="${bean.birth}" />
			<c:param name="cellphone" value="${bean.cellphone}" />
			<c:param name="address" value="${bean.address}" />
		</c:url>

	<tr>
		<td><a href="${path}">${bean.memberid}</a></td>
		<td>${bean.account}</td>
		<td>${bean.password}</td>
		<td>${bean.sex}</td>
		<td>${bean.email}</td>
		<td>${bean.birth}</td>
		<td>${bean.cellphone}</td>
		<td>${bean.address}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>
<h3><a href="<c:url value="/members.jsp" />">members Table</a></h3>

</body>
</html>
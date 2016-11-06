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
<h3>Select Photos Result : ${fn:length(photos)} row(s) selected</h3>
<%-- <img src="${pageContext.servletContext.contextPath}/testPhoto.show?hotelphotoid=4"/> --%>

<c:if test="${not empty photos}">
<table>
	<thead>
	<tr>
		<th>photo</th>
		<th>hotelphotoid</th>
		<th>hotelid</th>
		<th>description</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean" items="${photos}">
	<tr>
		<td>${bean.hotelphotoid}</td>
		<td>${bean.hotelid}</td>
		<td>${bean.description}</td>
	</tr>
	<img src='${PageContext.servletContext.contextPath}/testPhoto.show?hotelphotoid=${bean.hotelphotoid}' />
	</c:forEach>
	
	</tbody>
</table>
</c:if>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>testHotels</title>
</head>
<body>

<h3>Select Hotel Result : ${fn:length(hotels)} row(s) selected</h3>
<c:if test="${not empty hotels}">
<table>
	<thead>
	<tr>
		<th>hotelid</th>
		<th>hotelname</th>
<!-- 		<th>typeid</th> -->
<!-- 		<th>phone</th> -->
<!-- 		<th>class_level</th> -->
<!-- 		<th>check_in</th> -->
<!-- 		<th>check_out</th> -->
<!-- 		<th>price_bed</th> -->
<!-- 		<th>years</th> -->
<!-- 		<th>address</th> -->
<!-- 		<th>language</th> -->
		<th>description</th>
		<th>description</th>
<!-- 		<th>note</th> -->
<!-- 		<th>lat</th> -->
<!-- 		<th>lng</th> -->
<!-- 		<th>tol_avg</th> -->
<!-- 		<th>total_comment</th> -->
<!-- 		<th>status</th> -->
		
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean" items="${hotels}">
	<c:url value="/testPhoto.view" var="path">
			<c:param name="hotelid" value="${bean.hotelid}" />
	</c:url>
	
	<tr>
		<td><a href="${path}">${bean.hotelid}</a></td>
		<td>${bean.hotelname}</td>
<%-- 		<td>${bean.typeid}</td> --%>
<%-- 		<td>${bean.phone}</label></td> --%>
<%-- 		<td>${bean.class_level}</td> --%>
<%-- 		<td>${bean.check_in}</td> --%>
<%-- 		<td>${bean.check_out}</td> --%>
<%-- 		<td>${bean.price_bed}</td> --%>
<%-- 		<td>${bean.years}</td> --%>
<%-- 		<td>${bean.address}</td> --%>
<%-- 		<td>${bean.language}</td> --%>
		<td>${fn:replace(bean.description," " ,"<br />")}</td>
		<td>${bean.description}</td>
<%-- 		<td>${bean.note}</td> --%>
<%-- 		<td>${bean.lat}</td> --%>
<%-- 		<td>${bean.lng}</td> --%>
<%-- 		<td>${bean.tol_avg}</td> --%>
<%-- 		<td>${bean.total_comment}</td> --%>
<%-- 		<td>${bean.status}</td> --%>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>


</body>
</html>
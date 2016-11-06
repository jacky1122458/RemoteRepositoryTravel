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

<h3>Select Hotel Result : ${fn:length(result)} row(s) selected</h3>
<c:if test="${not empty result}">
<table>
	<thead>
	<tr>
		<th>hotelid</th>
		<th>hotelname</th>
		<th>description</th>
		<th>description</th>
		
	</tr>
	</thead>
	<tbody>
	<c:forEach var="map" items="${result}">
	<tr>
		<td>${map.Hotelbean.hotelname}</td>
		<c:forEach var="room" items="${map.roomlist}">
		<tr>
		<td>${room.roomname}*${room.number}</td>
		</tr>
		</c:forEach>
		<td> 總共${map.roomnumber}間</td>
		<td> 建議共${map.peoplenum}人入住</td>
		<td> 一晚總價${map.price}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>


</body>
</html>
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
<table>
	<thead>
           <tr>
				<th>orderid</th>
				<th>hotelname</th>
				<th>roomname</th>
				<th>name</th>
				<th>price</th>
				<th>peoplenum</th>
				<th>number</th>
				<th>cellphone</th>
				<th>spec</th>
				<th>status</th>
			</tr>
	</thead>
	<tbody>
	<c:forEach var="bean1" items="${result}">
		 	<tr>
		 		<td>${bean1[0]}</td>
		 		<td>${bean1[1]}</td>
		 		<td>${bean1[2]}</td>
		 		<td>${bean1[3]}</td>
		 		<td>${bean1[4]}</td>
		 		<td>${bean1[5]}</td>
		 		<td>${bean1[6]}</td>
		 		<td>${bean1[7]}</td>
		 		<td>${bean1[8]}</td>
		 		<td>${bean1[9]}</td>
		 	</tr>	
	
		 	
		 	
	</c:forEach>
</body>
</html>
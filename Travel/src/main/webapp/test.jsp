<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display</title>
</head>
<body>
<h3>Table</h3>
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/order.jsp" />">
				
			

<table>
	<thead>
	<tr>
		<th>順序</th>
		<th>景點</th>
		<th>類型</th>
		<th>開放時間</th>
		<th>簡介</th>
		<th>地圖</th>
		<th>網址</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean1" items="${Travel}" >
		 	<tr>
		 		<td>${bean1[0]}</td>
		 		<td>${bean1[2]}</td>
		 		<td>${bean1[3]}</td>
		 		<td>${bean1[4]}</td>
		 		<td>${bean1[5]}</td>
	<td><iframe width="350" height="350" frameborder="0" src="https://www.google.com/maps?geocode=&q= ${bean1[6]},${bean1[7]} &z=22&output=embed"></iframe></td>	
			 	<td><a href="<c:url value="${bean1[8]}" />">show tour</a></td>
		 	</tr>
	</c:forEach>
	</tbody>
	<td>
		<button id="order"  name="order" value="order">
			order
		</button>
	</td>

</table>  
</form>


<form method="get" action="<c:url value="/showtour1.controller"/>">
		<button name="serch" value="serch" >serch</button>
</form>

<table>
	<thead>
	<tr>
		<th>姓名</th>
		<th>行程</th>
		<th>評論</th>
		<th>分數</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean2" items="${evaluate}" >
		 	<tr>
		 		<td>${bean2[1]}</td>
		 		<td>${bean2[2]}</td>
		 		<td>${bean2[3]}</td>
		 		<td>${bean2[4]}</td>
		 		<td>${bean2[5]}</td>
		 	</tr>
	</c:forEach>
	</tbody>
</table> 

</body>
</html>
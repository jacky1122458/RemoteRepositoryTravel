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

<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/order/CancelOrder_DetailServlet" />">
			checkin<Input id='checkin' type='text' name='checkin' value='${checkin}'><P/>
		 	checkout<Input id='checkout' type='text' name='checkout' value='${checkout}'><P/>
		 	
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
			</tr>
	</thead>
	<tbody>
	<c:forEach var="bean1" items="${result}">
		 	<tr>
		 		orderid<Input type='text' name='orderid' value='${bean1[0]}'><P/>
		 		<td>${bean1[0]}</td>
		 		<td>${bean1[1]}</td>
		 		<td>${bean1[2]}</td>
		 		<td>${bean1[3]}</td>
		 		<td>${bean1[4]}</td>
		 		<td>${bean1[5]}</td>
		 		<td>${bean1[6]}</td>
		 		<td>${bean1[7]}</td>
		 		<td>${bean1[8]}</td>
		 		status<Input type='text' name='status' value='${bean1[9]}'><P/>
		 		roomid<Input type='text' name='roomid' value='${bean1[10]}'><P/>
		 	</tr>	
	</c:forEach>
	
	</tbody>
</table>
	<button id="order" class="ui-button ui-corner-all ui-widget" name="cancel" value="cancel">
						cancel
	</button>
</form>
<script type="text/javascript">
	var bla = document.getElementById("checkin").value;
	var y = new Date(bla);
	var result = y.getFullYear()+"/"+(y.getMonth()+1)+"/"+y.getDate();	
	document.getElementById("checkin").value = result;
	
	var bla1 = document.getElementById("checkout").value;
	var y1 = new Date(bla1);
	var result1 = y1.getFullYear()+"/"+(y1.getMonth()+1)+"/"+y1.getDate();
	document.getElementById("checkout").value = result1;
</script>
</body>
</html>
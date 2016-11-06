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
				<th>memberid</th>
				<th>price_total</th>
				<th>orderday</th>
				<th>checkin</th>
				<th>checkout</th>
			</tr>
	</thead>
	<tbody>
	<c:forEach var="bean1" items="${result1}">
		 	<tr>
		 		<td>${bean1.orderid}</td>
		 		<td>${bean1.memberid}</td>
		 		<td>${bean1.price_total}</td>
		 		<td class="translate">${bean1.orderdate}</td>
		 		<td class="translate">${bean1.checkin}</td>
		 		<td class="translate" id='checkout' >${bean1.checkout}</td>
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
	document.getElementById("checkout").result1
	
	var trs = document.getElementsByClassName("translate").value;
	var ntrs =new Date(trs);
	var resultNew = ntrs.getFullYear()+"/"+(ntrs.getMonth()+1)+"/"+ntrs.getDate();
	document.getElementsByClassName("translate").value = resultNew;
	
	</script>
</body>
</html>
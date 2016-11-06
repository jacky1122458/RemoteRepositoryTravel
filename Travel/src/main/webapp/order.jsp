<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<title>Product</title>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/json2.js"></script>
<script type="text/javascript" src="../js/product.js"></script>

</head>
<body>

<h3>order</h3>

<form action="<c:url value="/order.controller" />" method="get">
			

<table>
	<tr>
		<td>人數 : </td>
		<td><input id="person" type="text" name="num" onchange="changeprice()" ></td>
		<td><span class="error">${error.num}</span></td>
		<td><span class="">剩餘人數${settour[0][3]}</span>
	</tr>
	<tr>
		<td>姓名 : </td>
		<td><input type="text" name="name" ></td>		
		<td><span class="error">${error.name}</span></td>
	</tr>
	<tr>
		<td>價錢 : </td>
		<td><input id="price" type="text" name="price" value="${settour[0][2]}" ></td>
		<td><span class="error">${error.price}</span></td>
	</tr>
	<tr>
		<td>電話 : </td>
		<td><input type="text" name="phone" ></td>
		<td><span class="error">${error.phone}</span></td>
	</tr>
	<tr>
		<td>訂購日 : </td>
		<td><input id="today" type="text" name="orderdate" value=""  readonly="readonly"></td>
	</tr>
	<tr>
		<td>出團日 : </td>
		<td><input type="text" name="outdate" value="${settour[0][6]}" readonly="readonly"></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="prodaction" value="Order">
			<span class="error">${error.Order}</span>
			<span class="total"></span>
		</td>
	</tr>
</table>
</form>

<script type="text/javascript">
var unchag = new Date();
var result = unchag.getFullYear() + "-" + (unchag.getMonth()+1) + "-" +unchag.getDate();
document.getElementById("today").value = result;

function changeprice(){
var x = document.getElementById("person").value;
var y = document.getElementById("price").value;
var z = parseInt(x*y);
document.getElementById("price").value = z;
}
</script>


</body>
</html>
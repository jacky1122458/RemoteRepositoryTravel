<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>Members</title>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/json2.js"></script>
<script type="text/javascript" src="../js/product.js"></script>

<script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
		function doBlur() {
		var id = document.forms[0].id.value;
		callProductIdServlet("GET", id, "textJson", contextPath);
}
</script>

<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>
</head>
<body>

<h3>Welcome </h3>

<h3>Product Table</h3>

<form action="<c:url value="../members.controller" />" method="get">
<table>
	<tr>
		<td>account: </td>
		<td><input type="text" name="account" value="${param.account}" onblur="doBlur()"></td>
		<td><span class="error">${error.account}</span></td>
	</tr>
		<tr>
		<td>password: </td>
		<td><input type="text" name="password" value="${param.password}" onblur="doBlur()"></td>
		<td><span class="error">${error.password}</span></td>
	</tr>
	<tr>
		<td>Name : </td>
		<td><input type="text" name="name" value="${param.name}"></td>
		<td></td>
	</tr>
	<tr>
		<td>sex : </td>
		<td><input type="text" name="sex" value="${param.sex}"></td>
		<td><span class="error">${error.sex}</span></td>
	</tr>
	<tr>
		<td>email : </td>
		<td><input type="text" name="email" value="${param.email}"></td>
		<td><span class="error">${error.email}</span></td>
	</tr>
	<tr>
		<td>birth : </td>
		<td><input type="text" name="birth" value="${param.birth}"></td>
		<td><span class="error">${error.birth}</span></td>
	</tr>
		<tr>
		<td>cellphone : </td>
		<td><input type="text" name="cellphone" value="${param.cellphone}"></td>
		<td><span class="error">${error.cellphone}</span></td>
	</tr>
		<tr>
		<td>address : </td>
		<td><input type="text" name="address" value="${param.address}"></td>
		<td><span class="error">${error.address}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="prodaction" value="Join">
			<input type="submit" name="prodaction" value="Update">
		</td>
		<td>
			<input type="submit" name="prodaction" value="Delete">
			<input type="submit" name="prodaction" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${error.action}</span></h3>

<c:if test="${not empty delete and delete}">
<h3>Delete Product Table Success : 1 row deleted</h3>
<script type="text/javascript">clearForm();</script>
</c:if>
<c:if test="${not empty delete and !delete}">
<h3>Delete Product Table Failed : 0 row deleted</h3>
<script type="text/javascript">clearForm();</script>
</c:if>


<c:if test="${not empty insert}">
<h3>Insert Product Table Success</h3>
<table border="1">
	<tr><td>account</td><td>${insert.account}</td></tr>
	<tr><td>password</td><td>${insert.password}</td></tr>
	<tr><td>name</td><td>${insert.name}</td></tr>
	<tr><td>sex</td><td>${insert.sex}</td></tr>
	<tr><td>email</td><td>${insert.email}</td></tr>
	<tr><td>birth</td><td>${insert.birth}</td></tr>
	<tr><td>cellphone</td><td>${insert.cellphone}</td></tr>
	<tr><td>email</td><td>${insert.address}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>Update Product Table Success</h3>
<table border="1">
	<tr><td>Id</td><td>${update.id}</td></tr>
	<tr><td>Name</td><td>${update.name}</td></tr>
	<tr><td>Price</td><td>${update.price}</td></tr>
	<tr><td>Make</td><td>${update.make}</td></tr>
	<tr><td>Expire</td><td>${update.expire}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>



</body>
</html>
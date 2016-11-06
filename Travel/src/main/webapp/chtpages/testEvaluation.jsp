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
<script type="text/javascript">
var contextPath = "${pageContext.request.contextPath}";
function doBlur() {
	document.getElementById("img").style.display = "inline";
	var id = document.forms[0].id.value;
 	callProductIdServlet("GET", id, "textJson", contextPath);
// 	callProductIdServlet("POST", id, "textText", contextPath);
// 	callProductIdServlet("GET", id, "textXml", contextPath);
}
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
	var messageNode = document.getElementById("message");
	while(messageNode.hasChildNodes()) {
		messageNode.removeChild(messageNode.childNodes[0]);
	}
}
</script>
</head>
<body>

<h3>evaluation</h3>

<form action="<c:url value="/Evaluation.controller" />" method="post">
<table>
	<tr>

		<td>cleanliness : </td>
		<td><input type="text" name="cleanliness" value="${param.cleanliness}" ></td>
		<td><span class="error">${error.id}</span><span id="message"></span></td>
	</tr>
	<tr>
		<td>comfort : </td>
		<td><input type="text" name="comfort" value="${param.comfort}"></td>
		<td></td>
	</tr>
	<tr>
		<td>location : </td>
		<td><input type="text" name="location" value="${param.location}"></td>
		<td><span class="error">${error.location}</span></td>
	</tr>
	<tr>
		<td>facilities : </td>
		<td><input type="text" name="facilities" value="${param.facilities}"></td>
		<td><span class="error">${error.facilities}</span></td>
	</tr>
	<tr>
		<td>staff : </td>
		<td><input type="text" name="staff" value="${param.staff}"></td>
		<td><span class="error">${error.staff}</span></td>
	</tr>
	<tr>
		<td>cp : </td>
		<td><input type="text" name="cp" value="${param.cp}"></td>
		<td><span class="error">${error.cp}</span></td>
	</tr>
	<tr>
		<td>total : </td>
		<td><input type="text" name="total" value="${param.total}"></td>
		<td><span class="error">${error.total}</span></td>
	</tr>
	<tr>
		<td>advantage : </td>
		<td><input type="text" name="advantage" value="${param.advantage}"></td>
		<td><span class="error">${error.advantage}</span></td>
	</tr>
	<tr>
		<td>defect : </td>
		<td><input type="text" name="defect" value="${param.defect}"></td>
		<td><span class="error">${error.defect}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="prodaction" value="Insert">
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
	<tr><td>Id</td><td>${insert.id}</td></tr>
	<tr><td>Name</td><td>${insert.name}</td></tr>
	<tr><td>Price</td><td>${insert.price}</td></tr>
	<tr><td>Make</td><td>${insert.make}</td></tr>
	<tr><td>Expire</td><td>${insert.expire}</td></tr>
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
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

<style>
	
</style>

</head>
<body>

<h3>評論</h3>

<form action="<c:url value="/Evaluatemytour.controller" />" method="get">
			

<table>
	<tr>
		<td>留言 : </td>
		<td><textarea name="say"  ></textarea>></td>
		<td><span class="error">${error.namesay}</span></td>
		<td><span class=""></span>
	</tr>
	<tr>
		<td>評分 : </td>
		<td><input type="text" name="num"  ></td>		
		<td><span class="error">${error.id}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="prodaction" value="check">
			<span class="total"></span>
		</td>
	</tr>
</table>
</form>

</body>
</html>
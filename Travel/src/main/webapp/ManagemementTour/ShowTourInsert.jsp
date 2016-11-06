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
<h3>新增</h3>
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/showtourinsert.controller" />">


<table>
	<tr>
		<td>旅程名稱: </td>
		<td><input type="text" name="tourname" value=""></td>
		<td><span class="error">${error.id}</span></td>
	</tr>
	<tr>
		<td>開團人數: </td>
		<td><input type="text" name="member" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>旅程價錢: </td>
		<td><input type="text" name="price" value="${param.price}"></td>
		<td><span class="error">${error.price}</span></td>
	</tr>
	<tr>
		<td>集合時間: </td>
		<td><input type="text" name="make" value="${param.make}"></td>
		<td><span class="error">${error.make}</span></td>
	</tr>
	<tr>
		<td>額外費用: </td>
		<td><input type="text" name="expire" value="${param.expire}"></td>
		<td><span class="error">${error.expire}</span></td>
	</tr>
	<tr>
		<td>年齡限制: </td>
		<td><input type="text" name="max" value="${param.max}"></td>
		<td><span class="error">${error.max}</span></td>
	</tr>
	<tr>
		<td>是否供餐: </td>
		<td><input type="text" name="fool" value="${param.fool}"></td>
		<td><span class="error">${error.fool}</span></td>
	</tr>
	<tr>
		<td>備註: </td>
		<td><input type="text" name="remark" value="${param.remark}"></td>
		<td><span class="error">${error.remark}</span></td>
	</tr>
	<tr>
		<td>集合地點: </td>
		<td><input type="text" name="meet" value="${param.meet}"></td>
		<td><span class="error">${error.meet}</span></td>
	</tr>
	<tr>
		<td>經度: </td>
		<td><input type="text" name="lat" value="${param.lat}"></td>
		<td><span class="error">${error.lat}</span></td>
	</tr>
	<tr>
		<td>緯度: </td>
		<td><input type="text" name="lng" value="${param.lng}"></td>
		<td><span class="error">${error.lng}</span></td>
	</tr>
	<tr>
		<td>說明: </td>
		<td><input type="text" name="ex" value="${param.ex}"></td>
		<td><span class="error">${error.ex}</span></td>
	</tr>
	<tr>
		<td>出團日期: </td>
		<td><input type="text" name="outdate" value="${param.outdate}"></td>
		<td><span class="error">${error.outdate}</span></td>
	</tr>
	<tr>
		<td>
			<button name="insert" value="insert">新增</button>
		</td>
	</tr>
</table>

</form>
</body>
</html>
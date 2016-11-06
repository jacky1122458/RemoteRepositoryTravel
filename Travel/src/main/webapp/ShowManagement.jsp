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
<h3>我想砍誰就砍誰</h3>
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/management.controller" />">
<table >
	<thead>
	<tr>
		<th>帳號</th>
		<th>帳號姓名</th>
		<th>旅程名稱</th>
		<th>評論</th>
		<th>評分</th>
		<th>狀態</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean1" items="${result}" >
		 	<tr>
		 		<td>${bean1[1]}</td>
		 		<td>${bean1[2]}</td>
		 		<td>${bean1[3]}</td>
		 		<td>${bean1[4]}</td>
		 		<td>${bean1[5]}</td>
		 		<td>${bean1[6]}</td>
		 		<td>${bean1[7]}</td>
		 		<td>
		 		<button id="change"  name="change" value="${bean1[0]}">
						更改狀態
				</button>
		 		</td>
		 	</tr>		 	
	</c:forEach>
</table>
</form>



</body>
</html>
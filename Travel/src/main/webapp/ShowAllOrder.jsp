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
<h3>訂單管理</h3>
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/managementorder.controller" />">
<input type="text" name="inputtext" placeholder="請輸入tourid" ><c:if test="${shownum[0][0]>0}"><span>剩餘人數${shownum[0][0]}</span></c:if>
<button name="check" value="check" >搜尋</button>			    <c:if test="${shownum[0][0]==0}"><span>已滿團</span></c:if>				
<table >
	<thead>
	<tr>
		<th>訂單編號</th>
		<th>帳號</th>
		<th>姓名</th>
		<th>訂購人姓名</th>
		<th>連絡電話</th>
		<th>旅程名稱</th>
		<th>訂購人日期</th>
		<th>出團日期</th>
		<th>狀態</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean1" items="${show}" >
		 	<tr>
		 		<td>${bean1[0]}</td>
				<td>${bean1[1]}</td>
				<td>${bean1[2]}</td>
				<td>${bean1[3]}</td>
				<td>${bean1[4]}</td>
				<td>${bean1[5]}</td>
				<td>${bean1[6]}</td>
				<td>${bean1[7]}</td>
				<td>
					<c:if test="${bean1[8]==false}">取消訂單</c:if>
					<c:if test="${bean1[8]==true}">下訂單</c:if>	
				</td>
				<td>
					<button name="button" value="${bean1[0]}">寄信</button>
				</td>
				<span>${error.id}</span>
			</tr>		 	
	</c:forEach>
</table>
</form>


<form method="get" action="<c:url value="/index.jsp"/>">
		<button name="back" value="back" >回首頁</button>
</form>
</body>
</html>
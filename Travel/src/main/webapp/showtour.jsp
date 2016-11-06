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
<h3>Table</h3>
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/showtour1.controller" />">
<table >
	<thead>
	<tr>
		<th>編號</th>
		<th>旅程</th>
		<th>成團人數</th>
		<th>價錢</th>
		<th>集合時間</th>
		<th>額外費用</th>
		<th>年齡上限</th>
		<th>餐點</th>
		<th>備註</th>
		<th>集合地點</th>
		<th>說明</th>
		<th>出團日</th>
		<th>狀態</th>
		<th>查看旅程</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean1" items="${tour}" >
		 	<tr>
		 		<td>${bean1[0]}</td>
		 		<td>${bean1[1]}</td>
		 		<td>${bean1[2]}</td>
		 		<td>${bean1[3]}</td>
		 		<td>${bean1[4]}</td>
		 		<td>${bean1[5]}</td>
		 		<td>${bean1[6]}</td>
		 		<td>${bean1[7]}</td>
		 		<td>${bean1[8]}</td>
		 		<td>${bean1[9]}</td>
		 		<td>${bean1[10]}</td>
		 		<td>${bean1[11]}</td>
		 		<td><c:if test="${bean1[12] == true}">
		 				上架
		 			</c:if>
		 			<c:if test="${bean1[12] == false}">
		 				下架
		 			</c:if>
		 		</td>	 		
		 		<td>
		 		<c:if test="${bean1[12] == false}">
		 		<button id=""  name="" onclick="return false;" style="background-color: #000000;">
						客滿
				</button>
		 		</c:if>
		 		<c:if test="${bean1[12] == true}">
		 		<button id="look"  name="look" value="${bean1[0]}">
						查看
				</button>
				</c:if>
		 		</td>
		 	</tr>
	</c:forEach>
</table>
</form>

<table>
	<thead>
	<tr>
		<th>評價</th>
	</tr>
	</thead>
<c:forEach var="s" items="${ss}" >
		 	<tr>
		 		<td><c:if test="${s == null}">
		 				尚未評價
		 			</c:if>
		 			<c:if test="${s != null}">
		 				${s}
		 			</c:if>
		 		</td>
		 	</tr>
		 	
	</c:forEach>

</table>



</body>
</html>
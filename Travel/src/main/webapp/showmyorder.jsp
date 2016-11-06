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

<script language="javascript">
var unchag = new Date();
var result = unchag.getFullYear() + "-" + (unchag.getMonth()+1) + "-" +unchag.getDate();
var x = document.getElementById("outdate").value;	


if(result.valueOf() > x.valueOf()){
alert("注意開始時間不能晚於結束時間！");
}
</script>

</head>
<body>
<span id="error_message" style="display:none;">${error.redayy}</span>
<h3>Table</h3>
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/showmyorder.controller" />">
<table >
	<thead>
	<tr>
		<th>帳號</th>
		<th>帳號姓名</th>
		<th>訂購姓名</th>
		<th>價錢</th>
		<th>電話</th>
		<th>旅程名稱</th>
		<th>訂購人數</th>
		<th>訂購日期</th>
		<th>出團日期</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean1" items="${mytour}" >
		 	<tr>
		 		<td>${bean1[1]}</td>
		 		<td>${bean1[2]}</td>
		 		<td>${bean1[3]}</td>
		 		<td>${bean1[4]}</td>
		 		<td>${bean1[5]}</td>
		 		<td>${bean1[7]}</td>
		 		<td>${bean1[8]}</td>
		 		<td>${bean1[9]}</td>
		 		<td id="outdate">${bean1[10]}</td>
		 		<td>
		 		<button id="look"  name="look" value="${bean1[0]}">
						取消
				</button>
		 		</td>
		 		<td>
		 		<button id="evaluate"  name="evaluate" value="${bean1[0]}">
						評論
				</button>
		 		</td>
		 	</tr>		 	
	</c:forEach>
		
	
</table>
</form>
<script>
	alert(document.getElementById("error_message").text());
</script>
</body>
</html>
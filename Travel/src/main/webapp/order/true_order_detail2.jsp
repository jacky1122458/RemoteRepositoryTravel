<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Welcome G&King</title>
		<meta name="Jeff" content="Student" />
		<!-- Date: 2016-10-07 -->
		<!-- bootstrap -->
		<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/style.css" type="text/css">
		<link rel="stylesheet" href="../css/goldblack.css" type="text/css">
		<link rel="stylesheet" href="../css/hotelreserved_info_update.css" type="text/css">

		<!-- favicon -->
		<link rel="shortcut icon" href="../images/favicon.png" type="image/x-icon">
		<link rel="icon" href="../images/favicon.png" type="image/x-icon">

		<style>
			#home {
				background-image: url("../images/photos/banner.jpg");
				background-repeat: repeat;
				background-color: #3C3C3C;
			}
		</style>

	</head>
	<body id="home">
		<nav class="navbar  navbar-default" role="navigation">
			<div class="container">
				<jsp:include page="/include/head.jsp" />
			</div><!-- container-fluid -->
		</nav>
		<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/order/CancelOrder_DetailServlet" />">
		<!--訂單編號、旅館名稱、房間類型、訂房名字、訂房價錢、幾間、手機、備註；隱藏INPUT-入住退房日期、訂單編號、房間編號、狀態-->
		<div id="container">
			<table class="table table-striped">
				<thead>
					<th>訂單編號：</th>
					<th>旅館名稱：</th>
					<th>房間類型：</th>
					<th>房間數：</th>
					<th>價錢：</th>
					<th>訂房者名字：</th>
					<th>手機：</th>
					<th>備註：</th>
				</thead>
	<c:forEach var="bean1" items="${result}">
			<input type="hidden" name='checkin' id="checkin" value='${checkin}'/>
			<input type="hidden" name='checkout' id="checkout" value='${checkout}'/>
			<input type="hidden" name='orderid' value='${bean1[0]}'/>
			<input type="hidden" name='status' value='${bean1[9]}'/>
			<input type="hidden" name='roomid' value='${bean1[10]}'/>
			
				<tbody>
				<tr class="info">
					<td>${bean1[0]}</td>
					<td>${bean1[1]}</td>
					<td>${bean1[2]}</td>
					<td>${bean1[6]}</td>
					<td>${bean1[4]}</td>
					<td>${bean1[3]}</td>
					<td>${bean1[7]}</td>
					<td>${bean1[8]}</td>
				</tr>				
				</tbody>
	</c:forEach>
			</table>		
		</div>
			<button class="cancel" type="submit" name="cancel" value="cancel">
											取消預約
										</button>
		</form>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
			$(".cancel").button();
		</script>
		<script type="text/javascript">
			var bla = document.getElementById("checkin").value;
			var y = new Date(bla);
			var result = y.getFullYear()+"/"+(y.getMonth()+1)+"/"+y.getDate();	
			document.getElementById("checkin").value = result;
			
			var bla1 = document.getElementById("checkout").value;
			var y1 = new Date(bla1);
			var result1 = y1.getFullYear()+"/"+(y1.getMonth()+1)+"/"+y1.getDate();
			document.getElementById("checkout").value = result1;

		</script>
	</body>
</html>
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
		<link rel="stylesheet" href="../css/member_info.css" type="text/css">

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
		<c:forEach var="bean1" items="${result}">
		<div id="central" style="height:500px;float:left;margin:0 auto;">
			<input type="hidden" name='checkin' value='${checkin}'/>
			<input type="hidden" name='checkout' value='${checkout}'/>
			<input type="hidden" name='orderid' value='${bean1[0]}'/>
			<input type="hidden" name='status' value='${bean1[9]}'/>
			<input type="hidden" name='roomid' value='${bean1[10]}'/>
			<p>訂單編號：<span>${bean1[0]}</span></p>
			<p>旅館名稱：<span>${bean1[1]}</span></p>
			<p>房間類型：<span>${bean1[2]}</span></p>
			<p>房間數：<span>${bean1[6]}</span></p>
			<p>價錢：<span style="font-size: 12px">${bean1[4]}</span></p>
			<p>訂房者名字：<span style="font-size: 12px">${bean1[3]}</span></p>
			<p>手機：<span style="font-size: 12px">${bean1[7]}</span></p>
			<p>備註：<span style="font-size: 12px">${bean1[8]}</span></p>
		<p><input type="button" class="update" value="取消預約" style="float:right;" name="cancel" value="cancel"/></p>
		</div>
		</c:forEach>
		</form>

		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
			$(".update").button();
		</script>
	
	</body>
</html>
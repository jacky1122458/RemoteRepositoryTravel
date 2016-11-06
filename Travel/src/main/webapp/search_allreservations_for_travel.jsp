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
		<!-- Date: 2016-10-05 -->
		<!-- bootstrap -->
		<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
		<link rel="stylesheet" href="assets/style.css" type="text/css">
		<link rel="stylesheet" href="css/goldblack.css" type="text/css" />
		<link rel="stylesheet" href="css/search_allreservations_for_travel.css" type="text/css">
		
		<!-- favicon -->
		<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
		<link rel="icon" href="images/favicon.png" type="image/x-icon">

		<style>
			#home {
				background-image: url("images/photos/banner.jpg");
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

		<div id="Mainframe">
		
	<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/showmyorder.controller" />">
				<span id="error_message" style="color:#ffffff">${error.redayy}</span>
				
				<h3 class="search_box_title">行程訂單</h3>
				<c:forEach var="bean1" items="${mytour}" >
			<article id="reserved_travel_list" class="main_introduce_loop">
				<div class="block_decoration">
				<div>
					<h3 class="fontstylebar">${bean1[7]}</h3>
					
					<div class="trip_scene">
						<p><span class="ui-icon ui-icon-flag"> </span><a class="travel_place" href="<c:url value="/showmyallattractions.controller# ${bean1[12]}"/>" target="_blank">${bean1[12]}</a></p>
						<p><span class="ui-icon ui-icon-arrowthick-1-s"> </span></p>
						<p><span class="ui-icon ui-icon-flag"> </span><a class="travel_place" href="<c:url value="/showmyallattractions.controller# ${bean1[13]}"/>" target="_blank">${bean1[13]}</a></p>
						<p><span class="ui-icon ui-icon-arrowthick-1-s"> </span></p>
						<p><span class="ui-icon ui-icon-flag"> </span><a class="travel_place" href="<c:url value="/showmyallattractions.controller# ${bean1[14]}"/>" target="_blank">${bean1[14]}</a></p>
						<br>
						<p style="color:#FF0000;font-size:14px;"><span class="ui-icon ui-icon-notice"> </span>(點選文字可以連結至景點介紹)</p>
					</div>
					<div class="buyer">
						<strong style="font-size:1.5em">訂購人:</strong>
						<span style="font-size:12px;">${bean1[3]}</span>
					</div>
					<div  class="buyer_phone">
						<strong style="font-size:1.5em">電話:</strong>
						<span style="font-size:12px;">${bean1[5]}</span>
					</div>
					<div class="price-zone">
						<strong style="font-size:1.5em">價格：</strong>
						<span style="font-size:12px;">（人數為<span name="person">${bean1[8]}</span>位）</span>
						<span class="travel_total_price">TWD${bean1[4]}</span>
					</div>
				</div>
				<div class="checkinandout">
					<strong style="font-size:1.5em">
						出團日期：
					</strong>
					<span>${bean1[10]}</span><br>
				</div>
				<button class="look"  name="look" value="${bean1[0]}">
						取消訂單
				</button>
				<button id="eva" class="look"  name="evaluate" value="${bean1[0]}">
						評論旅程
				</button>
				
				</div>
			</article>
			
			</c:forEach>
			</form>
							
			
			
		</div>
		
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		
		<script>
		$(".look").button();
	
		
		</script>
	</body>
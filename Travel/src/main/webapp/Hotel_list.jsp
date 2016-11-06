<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<link rel="stylesheet" href="css/hotel_list.css" type="text/css">		
		<link rel="stylesheet" href="<c:url value="/css/goldblack.css" />" type="text/css">

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
				<!-- Brand and toggle get grouped for better mobile display -->
				<jsp:include page="/include/head.jsp" />
			</div><!-- container-fluid -->
		</nav>
		<div id="whole_block">
			<!-- class為bookstrap等同float:left -->
		<div id="side_block" class="pull-left">
		<jsp:include page="/include/searchframe.jsp" />
		</div>


		<div id="main_block" class="pull-right">
			<div id="ajaxsrwrap">
				<div data-block-id="sr_warnings">
					<div class="sr_warnings__content"></div>
				</div>
				<!--旅館列表-->
				
				<c:forEach var="map" items="${result}">
				<form action="<c:url value="/pages/RoomServlet" />" method="post">
				<c:url value="/pages/RoomServlet" var="path"><!--呼叫ROOMSERVLT-->
					<c:param name="hotelid" value="${map.Hotelbean.hotelid}" />
					<c:param name="checkin" value="${param.checkin}" />
					<c:param name="checkout" value="${param.checkout}" />
					<c:param name="number" value="${param.roomNum}" />
					<c:param name="adultNum" value="${param.adultNum}" />
				</c:url>
				<div class="wraper_hotel">
					<div class="images_temp">
<!-- 						<img class="images" src="images/hotel_frontdoor.png"></img> -->
						<img class="images" src="<c:url value='/PhotoDescript.show?hotelid=${map.Hotelbean.hotelid}&descript=index' />" />
					</div>
					<div class="hotel_context_area">
						<div class="hotel_content">
							<span><a class="font_style_tem" href="${path}">${map.Hotelbean.hotelname}</a></span>
							<div class="address">
								<a href="">${map.Hotelbean.address}</a>
							</div>
							<div class="member_number">
								<span><h3 class="font_style_tem">非常好${map.Hotelbean.tol_avg}</h3></span>
							</div>
							
							<div class="total-count-romm-price">
								<c:forEach var="room" items="${map.roomlist}">
								<tr>
<%-- 								<td>${room.roomname}*${room.number}間</td> --%>
									<p>${room.roomname}*${room.number}間</p>
								</tr>
								</c:forEach>
								<p>最多${map.peoplenum}人入住</p>
								<p><b class="room_price_font">一晚總價${map.price}</b></p>
							</div>
						</div>
						
					</div>
					<div class="spacing_line"></div>
					<div class="btn_area">
						<input class="ui-button ui-corner-all ui-widget" value="book new" style="width:150px;" onclick="location.href='${path}';">
					</div>
				</div>
				</form>
				</c:forEach>
			
			</div>
		</div>
		</div>
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
			var x = $(".select_bar_tem input").val();
			
			$("#rooms option[value="+x+"]").attr("selected","selected");
			
			var y = $("#adults_col input").val();
			
			$("#adults option[value="+y+"]").attr("selected","selected");
			
			var i = $("#search_box_datefrom input").val();
            $("#search_box_datefrom input").datepicker("setDate",i);
            
            var j = $("#search_box_dateto input").val();
            $("#search_box_dateto input").datepicker("setDate",j);
            
            $("#rooms").change(function(){
            	var r = $("#rooms :selected").val();
            	console.log(r);
            	$("#rooms").find('option').removeAttr("selected");
            	$("#rooms option[value="+r+"]").prop("selected","selected");
            	$("input[name='roomNum']").attr("value",r);
            });
            $("#adults").change(function(){
            	var r = $("#adults :selected").val();
            	console.log(r);
            	$("#adults").find('option').removeAttr("selected");
            	$("#adults option[value="+r+"]").prop("selected","selected");
            	$("input[name='adultNum']").attr("value",r);
            });
            
			$(function() {
				$("#datefrom,#dateto").datepicker({
					dateFormat : "yy/mm/dd",
					minDate: '@minDate'
				});
				/*$("#datefrom").datepicker("setDate","new Date()");
				$("#dateform").datepicker("getDate");				
				$("#dateto").datepicker("setDate","+1");*/
				
				/*user點選入住日期，退房日期自動加1*/
				$("#datefrom").change(function(){					
					var day = $("#datefrom").datepicker("getDate");
					day = new Date(day.valueOf());
					day.setDate(day.getDate()+1);
					$("#dateto").datepicker("setDate",day).datepicker("option","minDate",day);
				});	
				
				/*$("#dateto").change(function(){					
					var day = $("#dateto").datepicker("getDate");
					day = new Date(day.valueOf());
					day.setDate(day.getDate()-1);
					$("#datefrom").datepicker("setDate",day);
				});*/
				
				$("#submit_btn").button();
				
			});
			
		</script>
	</body>

</html>
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
		
		<link rel="stylesheet" href="<c:url value="/assets/bootstrap/css/bootstrap.min.css" />" type="text/css"/>
		<link rel="stylesheet" href="<c:url value="/assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" />" type="text/css"/>
		<link rel="stylesheet" href="<c:url value="/assets/style.css" />" type="text/css">
		<link rel="stylesheet" href="<c:url value="/css/goldblack.css" />" type="text/css">
		
		<!-- favicon -->
		<link rel="shortcut icon" href="<c:url value="images/favicon.png" />" type="image/x-icon">
		<link rel="icon" href="images/favicon.png" type="image/x-icon">
	</head>
	<body id="home">
		<nav class="navbar  navbar-default" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<jsp:include page="/include/head.jsp" />
			</div><!-- container-fluid -->
		</nav>
		<div id="slider">
			<div class="banner">
				<img src="<c:url value="/images/photos/banner.jpg" />"  class="img-responsive" alt="slide">
				<div class="welcome-message">
					<div class="wrap-info">
						<div class="information">
							<h1  class="animated fadeInDown" style="color:#FFFF33">Best Search Web</h1>
                            <p class="animated fadeInUp" style="color:#FFFF33">
								You can find lots hotels in Taipei!!
							</p>

							<div class="home-reservation-box clearfix">
								<form class="booking-form" name="bookroom" action="<c:url value="/serachotel2.controller" />" method="post">
<%-- 								<form class="booking-form" name="bookroom" action="<c:url value="/serachotel.controller" />" method="post"> --%>
									<div>
										<input class="show_big" type="text" name="address" value="${param.address}" placeholder="搜尋地點">
									</div>
									<div id="search_box_datefrom">
									<i style="position:absolute;left:190px;padding: 6px 15px;" class="glyphicon glyphicon-calendar"></i>
									<input class="show_big" type="text" id="datefrom" name="checkin" value="${param.checkin}" placeholder="Check In" readonly="readonly">
									</div>
									<div id="search_box_dateto">
									<i style="position:absolute;left:380px;padding: 6px 15px;" class="glyphicon glyphicon-calendar"></i>
									<input class="show_big" type="text" id="dateto" name="checkout" value="${param.checkout}" placeholder="Check Out" readonly="readonly">
									</div>
									<div class="select-wrapper">
										<select id="rooms" name="roomNum">
											<option value="none">Rooms</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
										</select>
									</div>
									<div class="select-wrapper">
										<select id="adults" name="adultNum">
											<option value="none">Adults</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
										</select>
									</div>


									<input class="ui-button ui-corner-all ui-widget" type="submit" value="Search" style="height:30px;color:#000000">
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
			

		</div>

		<style type="text/css">
			h1, h2, h3, h4, h5, h6, #ui-datepicker-div .ui-datepicker-title, .dropcap, .ui-tabs .ui-tabs-nav li, #title-wrapper h1, #main-menu li, #main-menu li span, .flex-caption, .accommodation_img_price {
				font-family: "Merriweather", serif;
			}

		</style>
		<script type="text/javascript" src="<c:url value="/assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js" />"></script>
		<script type="text/javascript" src="<c:url value="/assets/jquery-ui-1.12.1.custom/jquery-ui.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/assets/bootstrap/js/bootstrap.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		
		<script>
		 	
			$(function() {
				$("#datefrom,#dateto").datepicker({
					dateFormat : "yy/mm/dd",
					minDate: '@minDate'
					
				});
                $("#datefrom").datepicker("setDate","new Date()");
                $("#dateform").datepicker("getDate");               
                $("#dateto").datepicker("setDate","+1");
                
                /*user點選入住日期，退房日期自動加1*/
                $("#datefrom").change(function(){                 
                    var day = $("#datefrom").datepicker("getDate");
                    day = new Date(day.valueOf());
                    day.setDate(day.getDate()+1);
                    $("#dateto").datepicker("setDate",day).datepicker("option","minDate",day);
                }); 
			});
		</script>
	</body>

</html>


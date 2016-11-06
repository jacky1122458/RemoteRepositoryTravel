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
		<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
		<link rel="stylesheet" href="../assets/style.css" type="text/css">
		<link rel="stylesheet" href="../css/goldblack.css" type="text/css" />
		<link rel="stylesheet" href="../css/search_allreservations_for_hotel.css" type="text/css">
		
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
		<div id="Mainframe">
		
		<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/order/UpateOrderDateServlet"  />">
			<h3 class="search_box_title">旅館訂單</h3>
			<c:forEach var="bean1" items="${result}">
			<article id="reserved_hotel_list" class="main_introduce_loop">
				<div style="width:240px;height:360px;float:left;">
					<img class="big_img_template" src="<c:url value='/PhotoDescript.show?hotelid=${bean1[9]}&descript=index' />">
				</div>
				<div class="check_hotel_content">
					<h3 class="fontstylebar">${bean1[1]}</h3>
					<p style="font-style:italic;margin:5px 5px;">
						${bean1[8]}
					</p>
					<div class="spacing-line"> </div>
					<div class="bedtype">
						<span style="margin-left:25px;">訂單編號:${bean1[0]}</span>
						<span style="margin-left:25px;">會員編號:${bean1[2]}</span>
							<Input type='hidden' name='orderid' value='${bean1[0]}'><P/>
					</div>
					<div class="price-zone">
						<strong style="font-size:1.5em">總價：</strong>
					<span class="hotel_room_price">TWD ${bean1[3]}</span>
					</div>
				</div>
				<div class="checkinandout">
				<div>
							入住日期：
						</div>
						<div id="search_box_datefrom" style="margin:10px 10px;">
							<input class="datefrom" name="checkin" type="text" value="${bean1[5]}" readonly="readonly" style="width:200px;height:30px;padding-left: 50px;">（15:00起）</input>
						</div>
						<div>
							退房日期：
						</div>
						<div id="search_box_dateto" style="margin:10px 10px;">
							<input class="dateto" name="checkout" type="text" value="${bean1[6]}" readonly="readonly" style="width:200px;height:30px;padding-left: 50px;">（12:00前）</input>
						</div>
				<c:url value="/order/Order_detilCheckingServlet" var="link">
					<c:param name="orderid" value='${bean1[0]}'/>
					<c:param name="checkin" value='${bean1[5]}'/>
					<c:param name="checkout" value='${bean1[6]}'/>
				</c:url>
			<div style="position:relative;left:100px;top:50px;">
					<button  class="ui-button ui-corner-all ui-widget" 　>
						<p><a href="${link}" style="color:#000000;">查詢訂單明細<img src="../img/click.png"/></a></p>
					</button>
				<button id="submit_btn" class="ui-button ui-corner-all ui-widget" name="submit_btn" value="search">
						修改訂購日期<img src="../img/click.png"/></a></p>
					</button>
			</div>
			</article>
				</c:forEach>
		</form>
			
			
		</div>
		
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		
	<script>
			$(function() {
				var a = $("input[name='checkin']").val();
				a = new Date(a.valueOf()); 
				
				var b = $("input[name='checkout']").val();
				
				$(".datefrom").datepicker({
					dateFormat : "yy/mm/dd",
					minDate: '@minDate'
				});
				$(".datefrom:eq(0)").change(function() {
					var day = $(".datefrom").datepicker("getDate");
					day = new Date(day.valueOf());
					day.setDate(day.getDate() + 1);
					$(".dateto:eq(0)").datepicker("setDate", day).datepicker("option","minDate",day);

				});

				$(".dateto").datepicker({
					dateFormat : "yy/mm/dd",
					minDate: '@minDate'
				});
				
				$("#submit_btn").button();
				
			});
		</script>
	</body>
	
</html>
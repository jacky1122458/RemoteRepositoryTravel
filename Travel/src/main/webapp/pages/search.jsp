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
		<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap-theme.min.css" type="text/css" />
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.structure.min.css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.theme.min.css"/>
		<link rel="stylesheet" href="../assets/style.css" type="text/css">


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
	<body>
<div style="width:500px;height:500px;">
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/pages/RoomServlet" />">
					<div class="search_box_tem">
						<div>
							入住日期：
						</div>
						<div id="search_box_datefrom">
							<input id="datefrom" name="datefrom" type="text" readonly="readonly" style="width:200px;height:30px;"/>
							<td><span class="error">${error.checkin}</span></td>
						</div>
						<div>
							退房日期：
						</div>
						<div id="search_box_dateto">
							<input id="dateto" name="dateto" type="text" readonly="readonly" style="width:200px;height:30px;"/>
							<td><span class="error">${error.checkout}</span></td>
						</div>
					</div>
					<div id="person_count_kinds" class="search_box_tem">
						<div class="select_bar_tem">
							<label>客房：</label>
							<select id="rooms" name="book_rooms">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
						</div>
						<div class="select_bar_tem">
							<label>成人：</label>
							<select id="adults" name="book_room_adults">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
						</div>
						<div>
							<label>hotel_id</label>
							<input type="text" id="hotelid" name="hotelid"/>
							<td><span class="error">${error.hotelid}</span></td>
						</div>
						<div>
							<label>memberid</label>
							<input type="text" id="memberid" name="memberid"/>
							<td><span class="error">${error.memberid}</span></td>
						</div>
					</div>
					<button id="submit_btn" class="ui-button ui-corner-all ui-widget" name="submit_btn" value="search">
						Search
					</button>
				</form>
			</div>
		<h3><a href="<c:url value="/pages/ForUs.jsp" />">hello</a></h3>
		<h3><a href="<c:url value="/order/order.jsp" />">查看訂單</a></h3>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="../assets/bootstrap/js/bootstrap.min.js"></script>
		
		<script>
			$(function() {
				$("#datefrom,#dateto,#dateorder").datepicker({
					dateFormat : "yy/mm/dd",
					minDate: '@minDate'
				});
				
				$("#submit_btn").button();
				
			});
		</script>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" type="text/css"/>
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.structure.min.css" type="text/css"/>
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.theme.min.css" type="text/css"/>
		<link rel="stylesheet" href="assets/style.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<style type="text/css">
#showPhoto {
	position:absolute;
	z-index:1;
	left:600px;
	top:75px;
	width:300px;
	height:300px;
}
</style>
<title>Display</title>
</head>
<body>
<div style="width:500px;height:500px;">
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/serachotel.controller" />">
					<div class="search_box_tem">
						<div>address:<div>
						<input type="text" name="address" value="${param.address}">
						<td><span class="error">${error.address}</span></td>
						<div>
							入住日期：
						</div>
						<div id="search_box_datefrom">
							<input id="datefrom" name="checkin" value="${param.checkin}" type="text" readonly="readonly" style="width:200px;height:30px;"/>
							<td><span class="error">${error.checkin}</span></td>
						</div>
						<div>
							退房日期：
						</div>
						<div id="search_box_dateto">
							<input id="dateto" name="checkout" value="${param.checkout}" type="text" readonly="readonly" style="width:200px;height:30px;"/>
							<td><span class="error">${error.checkout}</span></td>
						</div>
					</div>
					<div id="person_count_kinds" class="search_box_tem">
						<div class="select_bar_tem">
							<label>客房：</label>
							<select id="rooms" name="number">
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
							<select id="adults" name="peoplenum">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
						</div>
					</div>
					<button id="submit_btn" class="ui-button ui-corner-all ui-widget" name="submit_btn" value="search">
						Search
					</button>
					
					<div id="filter_condition_3" class="filter_tem">
						<i class="ui-icon ui-icon-triangle-1-s"></i><span class="search_box_constrain_conditions">price：</span>
						<br>
						<input type="checkbox" name="price" value="1" />
						<label for="search_box_constrain_facilitytype_conditions_1">1700以下</label>
						<br>
						<input type="checkbox" name="price" value="2"/>
						<label for="search_box_constrain_facilitytype_conditions_2">1700~3400</label>
						<br>
						<input type="checkbox" name="price" value="3"/>
						<label for="search_box_constrain_facilitytype_conditions_3">3400~5400</label>
						<input type="checkbox" name="price" value="4"/>
						<label for="search_box_constrain_facilitytype_conditions_3">5400up</label>
					</div>
					
					<div id="filter_condition_3" class="filter_tem">
						<i class="ui-icon ui-icon-triangle-1-s"></i><span class="search_box_constrain_conditions">旅館服務：</span>
						<br>
						<input type="checkbox" name="service" value="1" />
						<label for="search_box_constrain_facilitytype_conditions_1">含早餐</label>
						<br>
						<input type="checkbox" name="service" value="3"/>
						<label for="search_box_constrain_facilitytype_conditions_2">客房服務</label>
						<br>
						<input type="checkbox" name="service" value="5"/>
						<label for="search_box_constrain_facilitytype_conditions_3">櫃臺24小時接待</label>
						<br>
						<input type="checkbox" name="service" value="7"/>
						<label for="search_box_constrain_facilitytype_conditions_4">可攜帶寵物</label>
					</div>
					
					<div id="filter_condition_3" class="filter_tem">
						<i class="ui-icon ui-icon-triangle-1-s"></i><span class="search_box_constrain_conditions">旅館類型：</span>
						<br>
						<input type="checkbox" name="type" value="1" />
						<label for="search_box_constrain_facilitytype_conditions_1">飯店</label>
						<br>
						<input type="checkbox" name="type" value="2"/>
						<label for="search_box_constrain_facilitytype_conditions_2">旅館</label>
						<br>
						<input type="checkbox" name="type" value="3"/>
						<label for="search_box_constrain_facilitytype_conditions_3">汽車旅館</label>
						<br>
						<input type="checkbox" name="type" value="4"/>
						<label for="search_box_constrain_facilitytype_conditions_4">青年旅館</label>
					</div>
					
</form>
</div>


<h3>Select Hotel Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>hotelid</th>
		<th>hotelname</th>
		<th>class_level</th>
		<th>address</th>
		<th>lat</th>
		<th>lng</th>
		<th>tol_avg</th>
		<th>total_comment</th>
		<th>roomid</th>
		<th>roomname</th>
		<th>price</th>
		<th>weekdayrate</th>
		<th>peoplenum</th>
		<th>bedtype</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean" items="${select}">
	
	<c:url value="/room.controller" var="path">
			<c:param name="hotelid" value="${bean.hotelid}" />
			<c:param name="checkin" value="${param.checkin}" />
			<c:param name="checkout" value="${param.checkout}" />
	</c:url>
	<tr>
		<td>${bean.hotelid}</td>
		<td><a href="${path}">${bean.hotelname}</a></td>
		<td>${bean.class_level}</td>
		<td>${bean.address}</label></td>
		<td>${bean.lat}</td>
		<td>${bean.lng}</td>
		<td>${bean.tol_avg}</td>
		<td>${bean.total_comment}</td>
		<td>${bean.roomid}</td>
		<td>${bean.roomname}</td>
		<td>${bean.price}</td>
		<td>${bean.weekdayrate}</td>
		<td>${bean.peoplenum}</td>
		<td>${bean.bedtype}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>
<h3><a href="<c:url value="/testIndex.jsp" />">Index</a></h3>
		
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>

		<script>
			$(function() {
				$("#datefrom,#dateto").datepicker({
					dateFormat : "yy/mm/dd",
					minDate: '@minDate'
				});
			});
		</script>

</body>
</html>
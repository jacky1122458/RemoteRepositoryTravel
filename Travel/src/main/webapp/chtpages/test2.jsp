<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display</title>
</head>
<body>

<c:if test="${not empty hotel}">
<table><thead><tr>
		<th>hotelid</th>
		<th>hotelname</th>
		<th>typeid</th>
		<th>phone</th>
		<th>class_level</th>
		<th>check_in</th>
		<th>check_out</th>
		<th>price_bed</th>
		<th>years</th>
		<th>address</th>
		<th>language</th>
		<th>note</th>
		<th>lat</th>
		<th>lng</th>
		<th>tol_avg</th>
		<th>total_comment</th>
		<th>status</th></tr></thead>
	<tbody><tr>
		<td>${hotel.hotelid}</td>
		<td>${hotel.hotelname}</td>
		<td>${hotel.typeid}</td>
		<td>${hotel.phone}</label></td>
		<td>${hotel.class_level}</td>
		<td>${hotel.check_in}</td>
		<td>${hotel.check_out}</td>
		<td>${hotel.price_bed}</td>
		<td>${hotel.years}</td>
		<td>${hotel.address}</td>
		<td>${hotel.language}</td>
		<td>${hotel.note}</td>
		<td>${hotel.lat}</td>
		<td>${hotel.lng}</td>
		<td>${hotel.tol_avg}</td>
		<td>${hotel.total_comment}</td>
		<td>${hotel.status}</td></tr></tbody>
</table>
</c:if>

<h3>Select service Result : ${fn:length(service)} row(s) selected</h3>
<c:if test="${not empty service}">
<table><thead><tr>
		<th>hotelid</th>
		<th>hotelname</th></tr></thead>
	<tbody>
	<c:forEach var="bean" items="${service}">
	<tr>
		<td>${bean.serviceid}</td>
		<td>${bean.servicename}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<h3>Select card Result : ${fn:length(card)} row(s) selected</h3>
<c:if test="${not empty card}">
<table><thead><tr>
		<th>cardtype</th>
		<th>cardphoto</th>
	<tbody>
	<c:forEach var="bean" items="${card}">
	<tr>
		<td>${bean.cardtype}</td>
		<td>${bean.cardphoto}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<h3>Select card Result : ${fn:length(review)} row(s) selected</h3>
<c:if test="${not empty review}">
<table><thead><tr>
		<th>hotelreviewID</th>
		<th>date</th>
		<th>cleanliness</th>
		<th>comfort</th>
		<th>location</th>
		<th>facilities</th>
		<th>staff</th>
		<th>cp</th>
		<th>total</th>
		<th>advantage</th>
		<th>defect</th>
		<th>display</th>
	<tbody>
	<c:forEach var="bean" items="${review}">
	<tr>
		<td>${bean.hotelreviewID}</td>
		<td>${bean.date}</td>
		<td>${bean.cleanliness}</td>
		<td>${bean.comfort}</td>
		<td>${bean.location}</td>
		<td>${bean.facilities}</td>
		<td>${bean.staff}</td>
		<td>${bean.cp}</td>
		<td>${bean.total}</td>
		<td>${bean.advantage}</td>
		<td>${bean.defect}</td>
		<td>${bean.display}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<h3>Select photo Result : ${fn:length(photo)} row(s) selected</h3>
<c:if test="${not empty photo}">
<table><thead><tr>
		<th>hotelphotoid</th>
		<th>hotelid</th>
		<th>description</th>
	<tbody>
	<c:forEach var="bean" items="${photo}">
	<tr>
		<td>${bean.hotelphotoid}</td>
		<td>${bean.hotelid}</td>
		<td>${bean.description}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/pages/HotelServlet" />">
			memberid<Input type='text' name='memberid' value='${memberid}'><P/>
			orderday<Input type='text' name='orderday' value='${orderday}'><P/>
		 	checkin<Input type='text' name='checkin' value='${checkin}'><P/>
    		checkout<Input type='text' name='checkout' value='${checkout}'><P/>
    		name<Input type='text' name='name' value='王先生'><P/>
    		cellphone<Input type='text' name='cellphone' value='0933818538'><P/>
    		spec<Input type='text' name='spec' value=''><P/>
    		================================================================
<table>
	<thead>
	<tr>
		<th>roomname</th>
		<th>price</th>
		<th>peoplenum</th>
		<th>room_numbers</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="bean1" items="${rooms}">
			roomid<Input type='text' name='roomid' value='${bean1[0]}'><P/>
		 	roomname<Input type='text' name='roomname' value='${bean1[1]}'><P/>
            price<Input type='text' name='price' value='${bean1[2]}'><P/>
            peoplenum<Input type='text' name='peoplenum' value='${bean1[3]}'><P/>
            room_numbers<Input type='text' name='room_numbers' value='${bean1[4]}'><P/>
            status<Input type='text' name='status' value='true'><P/>
           ================================================================== 
		 	<tr>
		 		<td>${bean1[1]}</td>
		 		<td>${bean1[2]}</td>
		 		<td>${bean1[3]}</td>
		 		<td>${bean1[4]}</td>
		 	</tr>
		 
	</c:forEach>		
	</tbody>
</table>
	<button id="order" class="ui-button ui-corner-all ui-widget" name="order" value="order">
						order
	</button>
</form>
<h3><a href="<c:url value="/pages/search.jsp" />">Product Table</a></h3>
</body>
</html>
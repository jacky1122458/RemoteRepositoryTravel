<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.structure.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.theme.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/style.css" type="text/css">

<title>Home</title>
<script>
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
	var messageNode = document.getElementById("message");
	while(messageNode.hasChildNodes()) {
		messageNode.removeChild(messageNode.childNodes[0]);
	}
}
</script>
</head>
<body>

<h3>Welcome  ${sessionScope.userid}</h3>


<h3><a href="<c:url value="/testWeb.view" />">testWeb</a></h3>
<h3><a href="<c:url value="/testHotel.controller" />">testPhoto</a></h3>
<h3><a href="<c:url value="/chtpages/testInsertPhoto.jsp" />">testInsertPhoto</a></h3>
<form action="<c:url value="/login.controller" />" method="get">
<table>
	<tr>
		<td>ID : </td>
		<td><input type="text" name="userid" value="${param.userid}"></td>
		<td><span class="error">${error.username}</span></td>
	</tr>
	<tr>
		<td>　</td>
		<td align="right"><input type="submit" value="Login"></td>
	</tr>
</table>
</form>


<form action="<c:url value="/serachotel.controller" />" method="post">
<table>
	<tr>
		<td>ADDRESS : </td>
		<td><input type="text" name="address" value="${param.address}"></td>
		<td><span class="error">${error.address}</span></td>
	</tr>
	<tr>
		<div id="search_box_datefrom">
		<i class="glyphicon glyphicon-calendar"></i>
		<input class="show_big" type="text" id="datefrom" name="checkin" value="${param.checkin}" placeholder="Check In" readonly="readonly">
		</div>
	</tr>
	<tr>
		<div id="search_box_dateto">
		<i class="glyphicon glyphicon-calendar"></i>
		<input class="show_big" type="text" id="dateto" name="checkout" value="${param.checkout}" placeholder="Check Out" readonly="readonly">
		</div>
	</tr>
	<tr>
		<td>Number : </td>
		<td><input type="text" name="number" value="${param.number}"></td>
		<td><span class="error">${error.number}</span></td>
	</tr>
	<tr>
		<td>Pelplenum : </td>
		<td><input type="text" name="peoplenum" value="${param.peoplenum}"></td>
		<td><span class="error">${error.peoplenum}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="hotelaction" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>
</form>

<c:if test="${not empty EvaHotelHotel}">
<h3>Can Evaluation Hotel Result : ${fn:length(EvaHotelHotel)} row(s) selected</h3>
<table>
	<thead>
	<tr>
		<th>hotelname</th>
		<th>check</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="result" items="${EvaHotelHotel}">
		<c:url value="/chtpages/testEvaluation.jsp" var="path">
			<c:set var="hotelid" value="${result.hotel.hotelid}" scope="session"/>
			<c:set var="orderid" value="${result.orderBean.orderid}" scope="session"/>
		</c:url>
	<tr>
		<td><a href="${path}">${result.hotel.hotelname}</a></td>
		<td>${result.orderBean.checkin}</td>

	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<%-- <c:if test="${not empty EvaHotelHotel}"> --%>
<%-- <h3>Can Evaluation Hotel Result : ${fn:length(EvaHotelHotel)} row(s) selected</h3> --%>
<!-- <table> -->
<!-- 	<thead> -->
<!-- 	<tr> -->
<!-- 		<th>hotelid</th> -->
<!-- 		<th>hotelname</th> -->
<!-- 		<th>typeid</th> -->
<!-- 		<th>class_level</th> -->
<!-- 		<th>check_in</th> -->
<!-- 		<th>check_out</th> -->
<!-- 		<th>address</th> -->
<!-- 		<th>language</th> -->
<!-- 	</tr> -->
<!-- 	</thead> -->
<!-- 	<tbody> -->
<%-- 	<c:forEach var="bean" items="${EvaHotelHotel}"> --%>
<%-- 		<c:url value="" var="path"> --%>
<%-- 			<c:param name="hotelid" value="${bean.hotelid}" /> --%>
<%-- 		</c:url> --%>
<!-- 	<tr> -->
<%-- 		<td>${bean.hotelid}</td> --%>
<%-- 		<td><a href="${path}">${bean.hotelname}</a></td> --%>
<%-- 		<td>${bean.typeid}</td> --%>
<%-- 		<td>${bean.class_level}</td> --%>
<%-- 		<td>${bean.check_in}</td> --%>
<%-- 		<td>${bean.check_out}</td> --%>
<%-- 		<td>${bean.address}</td> --%>
<%-- 		<td>${bean.language}</td> --%>
<!-- 	</tr> -->
<%-- 	</c:forEach> --%>
	
<!-- 	</tbody> -->
<!-- </table> -->
<%-- </c:if> --%>

<h3><span class="error">${error.action}</span></h3>

		
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="../assets/bootstrap/js/bootstrap.min.js"></script>

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
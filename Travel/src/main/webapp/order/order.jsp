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
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/order/Hotel_orderForCheckingServlet" />">
<table>
	<thead>
	
	</thead>
	<tbody>
	
	<c:forEach var="bean1" items="${result}">
           <tr>
           		<th>orderid</th>
				<th>hotelname</th>
				<th>memberid</th>
				<th>price_total</th>
				<th>orderday</th>
				<th>checkin</th>
				<th>checkout</th>
			</tr>
		 	<tr>
		 		<td>${bean1[0]}</td>
		 		<td>${bean1[1]}</td>
		 		<td>${bean1[2]}</td>
		 		<td>${bean1[3]}</td>
		 		<td>${bean1[4]}</td>
		 		<td>${bean1[5]}</td>
		 		<td>${bean1[6]}</td>
		 	</tr>	
		 		  
		 	
		 	<c:url value="/order/Order_detilCheckingServlet" var="link">
					<c:param name="orderid" value='${bean1[0]}'/>
					<c:param name="checkin" value='${bean1[4]}'/>
					<c:param name="checkout" value='${bean1[5]}'/>
				</c:url>
			<tr>
				<td><a href="${link}"><img src="../img/click.png"/></a></td>
			</tr>
	</c:forEach>
		
	</tbody>
</table>
	<button id="order" class="ui-button ui-corner-all ui-widget" name="check" value="check">
						Check
	</button>
</form>
			
			</div>
		<h3><a href="<c:url value="/pages/hello.jsp" />">hello</a></h3>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="../assets/bootstrap/js/bootstrap.min.js"></script>
		
		<script>
			$(function() {
				$("#datefrom,#dateto").datepicker({
					dateFormat : "yy/mm/dd",
					minDate: '@minDate'
				});
				
				$("#submit_btn").button();
				
			});
		</script>
	</body>
</html>
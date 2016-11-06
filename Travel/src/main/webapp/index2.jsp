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
		<link rel="stylesheet" href="assets/bootstrap/css/bootstrap-theme.min.css" type="text/css" />
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.structure.min.css"/>
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.theme.min.css"/>
		<link rel="stylesheet" href="assets/style.css" type="text/css">


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
	
	<form method="get" action="<c:url value="/showtour1.controller"/>">
		<button name="serch" value="serch" >serch</button>
	</form>
	
	<form method="get" action="<c:url value="/showmyorder.controller"/>">
		<button name="myorder" value="myorder" >我的行程訂單</button>
	</form>
	
	<form method="get" action="<c:url value="/showmyattractions.controller"/>">
		<button name="myatt" value="myatt" >我的景點</button>
	</form>
				
	<form method="get" action="<c:url value="/myeva.controller"/>">
		<button name="myeva" value="myeva" >我的評論</button>
	</form>
	
	
	
	
	
	
	
	<form method="get" action="<c:url value="/management.controller"/>">
		<button name="management" value="management" >管理評論</button>
	</form>

	
	<form method="get" action="<c:url value="/managementorder.controller"/>">
		<button name="managementorder" value="managementorder" >管理訂單</button>
	</form>
	
	
	
	<form method="get" action="<c:url value="/managementtour.controller"/>">
		<button name="managementtour" value="managementtour" >管理旅程</button>
	</form>
	</body>
	
</html>
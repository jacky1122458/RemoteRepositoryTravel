<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Welcome G&King</title>
		<meta name="Jeff" content="Student" />
		<!-- Date: 2016-10-07 -->
		<!-- bootstrap -->
		<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/style.css" type="text/css">
		<link rel="stylesheet" href="../css/goldblack.css" type="text/css">
		<link rel="stylesheet" href="../css/signup.css" type="text/css">

		<!-- favicon -->
		<link rel="shortcut icon" href="../images/favicon.png" type="image/x-icon">
		<link rel="icon" href="../images/favicon.png" type="image/x-icon">

		<style>
			#home {
				background-image: url("../images/photos/banner.jpg");
				background-repeat: repeat;
				background-color: #3C3C3C;
			}
			.gg {
   				 background-color: red;
   				 font-size: 14px;
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
		<div id="main-menu">
			<form action='<c:url value="/client/join.controller" />' method="post">
				<span class="s">帳號：</span>
				<input class="enter" type="text" name="account" value="${param.account}" min="3" maxlength="15" autofocus="true" autocomplete="off"/><br>
				<span class="gg">${error.account}</span><br>
				<span class="s">密碼：</span>
				<input class="enter" type="password" name="password" value="${param.password}" maxlength="15" autocomplete="off" /><br>
				<span class="gg">${error.password}</span><br>
				<span class="s">姓式：</span>
				<input class="enter" type="text" name="lastname" value="${param.lastname}" placeholder="Ex:王,歐陽" maxlength="15"><br>
				<span class="gg">${error.lastname}</span><br>
				<span class="s">名字：</span>
				<input class="enter" type="text" name="firstname" value="${param.firstname}" placeholder="Ex大名,阿貓,阿狗"  maxlength="15"><br>
				<span class="gg">${error.firstname}</span><br>
				<div class="enter" id="radioset" >
				<span class="s">姓別：</span><span class="gg">${error.sex}</span>
				<input type="radio" id="radio1" name="sex" value="M">
					<label class="s" for="radio1" >男</label>
				<input type="radio" id="radio2" name="sex" value="F"checked="checked">
					<label class="s" for="radio2" >女</label>
				</div>
				<span class="s">生日：</span>
				<input id="birth" class="enter" type="text" name="birth" value="${param.birth}" placeholder="1911/01/01" readOnly="readonly" /><br>
				<span class="gg">${error.birth}</span><br>
				<span class="s">手機：</span>
				<input class="enter" name="cellphone" value="${param.cellphone}" type="tel" maxlength="10" placeholder="0911223344"/><br>
				<span class="gg">${error.cellphone}</span><br>
				<span class="s">電子信箱：</span>
				<input class="enter" type="text" name="email" value="${param.email}" placeholder="xxxooo@gmail.com"  maxlength="40"/><br>
				<span class="gg">${error.email}</span><br>
				<span class="s">聯絡地址：</span>
				<input class="enter" type="text"name="address" value="${param.address}" min="10"/><br>
				<span class="gg">${error.address}</span><br><br>
				
				<input type="submit" value="送出表單" name="prodaction" style="color: black;">
				<input type="reset" value="重新輸入" style="color: black;">
			</form>
		</div>
		
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="../assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/head.js"></script>
		<script>
				$("#birth").datepicker({
					dateFormat:"yy/mm/dd",
					changeYear: true,
					changeMonth: true,
					yearRange: "-100:+0"
				});
			
				

		</script>
			
	</body>
</html>
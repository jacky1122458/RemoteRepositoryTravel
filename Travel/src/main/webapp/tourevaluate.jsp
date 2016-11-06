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
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
		<link rel="stylesheet" href="assets/style.css" type="text/css">
		<link rel="stylesheet" href="css/goldblack.css" type="text/css" />
		<link rel="stylesheet" href="css/search_travel.css" type="text/css">

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
				<jsp:include page="/include/head.jsp" />
			</div><!-- container-fluid -->
		</nav>
		
	<form action="<c:url value="/Evaluatemytour.controller" />" method="get">
		
		<div id="whole_block">
			<!-- class為bookstrap等同float:left -->
			<div id="main_block" style="margin:0 auto;">
				<div id="ajaxsrwrap" style="margin:0 auto;width:350px;height:300px;background-color:#FFEEC0;border-radius:10px 10px 10px 10px;">
					<article id="form-to-submit" style="margin:0 auto;width:350px;height:500px;">
						<form id="send_information_form">
							<fieldset style="text-align:center;">
								<legend style="text-align:center;color:#FF0000";>
									請填寫完整
								</legend>

							<div>
								<label for="mess">留言</label>
								<p><textarea id="mess" maxlength="50" style="vertical-align:text-top;margin-left:50px;resize:none;width:200px;height:50px;"  name='say'> </textarea></p>
								<p><span class="error">${error.namesay}</span></p>
							</div>
							
							<div id="person_count">
								評分 :
								<p><input type="text" name="num"></p>
								<p><span class="error">${error.id}</span></p>
							</div>
							
							<input type="submit" name="prodaction" value="check" id="check">
									<span class="total"></span>
							</fieldset>
						</form>
					</article>
				</div>
			</div>
		</div>
</form>

		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
			$("#check").button();


			$("#member_name").focus(function() {
				$(this).css("background-color", "#F9F900");
				$("#member_name").after("<span id='tem1' style='color:#EA0000;font-size:12px;'>此欄為必填!</span>");
				$("#member_name").val("");
			});
			$("#member_name").blur(function() {
				$(this).css("background-color", "#FFFFFF");
				$("#tem1").remove();
			});
			$("#phone-number").focus(function() {
				$(this).css("background-color", "#F9F900");
				$("#phone-number").after("<span id='tem2' style='color:#EA0000;font-size:12px;'>此欄為必填!</span>");
				$("#phone-number").val("");
			});
			$("#phone-number").blur(function() {
				$(this).css("background-color", "#FFFFFF");
				$("#tem2").remove();
			});

			</script>
			
	</body>

</html>
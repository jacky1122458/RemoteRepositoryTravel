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
		<link rel="stylesheet" href="css/commentSlider.css" type="text/css">
		
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

		<div id="Mainframe">
			<!--書籤頁-->
		
		<!--景點-->
			<article id="commentpage_slider" class="main_loop" style="background-color: #FFFFFF;width: 200px;height:150px;margin:0 auto;">
				<c:forEach var="bean1" items="${eva}" >
				<div class="commentArea" style="display:none;">
				<p>評論者：<span>${bean1[2]}</span></p>
				<p>旅程名稱：<span>${bean1[3]}</span></p>
				<p>評分：<span>${bean1[5]}</span></p>
				<p>評論<textarea style="vertical-align:text-top;resize:none;width:150px;height:40px;" >${bean1[4]}</textarea></p>
				</div>
				</c:forEach>
			</article>
		
			
			
		</div>
		
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="js/jquery.cycle.all.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
		var $aaa = $('.commentArea').toArray();
		var size = $aaa.length;
		var i = 0;
		delayedUpdatelist(i);
		function delayedUpdatelist(x) {
		　if(x < size){ 
		　　$('.commentArea:eq('+x+')').show("slow").delay(3000).fadeOut("slow");
		　　　　setTimeout(function(){ delayedUpdatelist(x+1) }, 5000);
		　} else {
		　　x = 0;
		　　$('.commentArea:eq('+x+')').show("slow").delay(3000).fadeOut("slow");
		　　setTimeout(function(){ delayedUpdatelist(x+1) }, 5000);
		　}
		}
		
		
		</script>
	</body>
	
</html>
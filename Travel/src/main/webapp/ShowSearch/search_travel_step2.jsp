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
		<link rel="stylesheet" href="css/search_travel_detail.css" type="text/css">
		<link rel="stylesheet" href="assets/jquery.raty.css" type="text/css" />

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
		<form id="search_box" class="search_box_tem" method="get"
			action="<c:url value="/ShowSearch/search_travel_step3.jsp" />">
	
		<!--跳出視窗，跳出景點-->
			<article class="popview_loop">
			<div class="togglelink_window">
				<section class="LocationAndAddress">
				<h3 class="search_box_title">${settour[0][1]}</h3>
				</section>
				<!--輪播-->
				<!--初始圖-->
				<div>				
					<div class="placeimagein">
						<img id="showimages"
							src="<c:url value='/PhotoId.show?hotelphotoid=${Travel[0][1]}'/>" />
					</div>
					<!--放圖區-->
					<div class="putin">
						<a href="<c:url value='/PhotoId.show?hotelphotoid=${Travel[0][1]}'/>"><img alt=""
							src="<c:url value='/PhotoId.show?hotelphotoid=${Travel[0][1]}'/>" /></a>
						<a href="<c:url value='/PhotoId.show?hotelphotoid=${Travel[1][1]}'/>"><img alt=""
							src="<c:url value='/PhotoId.show?hotelphotoid=${Travel[1][1]}'/>" /></a>
						<a href="<c:url value='/PhotoId.show?hotelphotoid=${Travel[2][1]}'/>"><img alt=""
							src="<c:url value='/PhotoId.show?hotelphotoid=${Travel[2][1]}'/>" /></a>
					</div>
				</div>
			</div>
			<div class="schedule">
					<h3 class="search_box_title" style="margin-bottom:10px;">行程規劃：</h3>
					<span class="ui-icon ui-icon-flag"> </span><a class="travel_place" href="   <c:url value='/showmyallattractions.controller# ${Travel[0][2]}'/>  " target="_blank">${Travel[0][2]}</a>
					<span class="ui-icon ui-icon-circle-arrow-e"> </span>
					<a class="travel_place" href="<c:url value='/showmyallattractions.controller# ${Travel[1][2]}'/>" target="_blank">${Travel[1][2]}</a>
					<span class="ui-icon ui-icon-circle-arrow-e"> </span>
					<a class="travel_place" href="<c:url value='/showmyallattractions.controller# ${Travel[2][2]}'/>" target="_blank">${Travel[2][2]}</a>
					<br><br>
					<p style="color:#FF0000;font-size:14px;"><span class="ui-icon ui-icon-notice"> </span>(點選文字可以連結至景點介紹)</p>
				</div>


		<div class="btn_search">
				<button style="z-index: 1;position:relative;top:-115px;" class="search" name="sarch" value="sarch">訂購</button>
		</div>
</form>

		<div class="wrapper_comment">
			<c:forEach var="bean2" items="${evaluate}">
				<div class="commentArea" data-grade="${bean2[4]}">
					<div style="border-radius:10px;"><h3 class="search_box_title">${bean2[2]}</h3></div>
					<br>
					<p style="margin-bottom:10px;"><span class="ui-icon ui-icon-person"> </span>姓名：<span class="member_name">${bean2[1]}</span></p>
					<p style="margin-bottom:10px;"><span class="ui-icon ui-icon-heart"> </span>分數：<span class="travel_grade"></span></p>
					<div class="comment_messages" style="height:50px;"><span class="ui-icon ui-icon-comment"> </span>
						評論：
						<div>
						<p class="p_font" style="position:relative;left:80px;">${bean2[3]}</p>
						</div>
					</div>					
				</div>
			</c:forEach>
			</div>
			
			</article>
			
			
			
		</div>
		
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="js/lightbox.js"></script>
		<script type="text/javascript" src="js/jquery.raty.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
		/*div輪播*/
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
		/*stars*/
		var i=0;		
		var change_grade = 0;
		$(".travel_grade").raty({
			path:'images/',
			readOnly:true,
			score:function(){
						change_grade = $(".commentArea:eq("+i+")").data("grade");
						i++;
						return change_grade;
						}
					
		});
		
		// 用來顯示大圖片用
		var $showImage = $('#showimages');

		// 當滑鼠移到 .-block-20120106 中的某一個超連結時
		$('.putin a').mouseover(function(){
		// 把 #show-image 的 src 改成被移到的超連結的位置
		$showImage.attr('src', $(this).attr('href'));
		}).click(function(){
		// 如果超連結被點擊時, 取消連結動作
		return false;
		});
		
		$(".search").button();
		
		
		</script>
	</body>
	
</html>
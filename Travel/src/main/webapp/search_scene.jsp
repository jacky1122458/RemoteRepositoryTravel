<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<link rel="stylesheet" href="css/search_scene.css" type="text/css">
		<link rel="stylesheet" href="assets/changephotos/rhinoslider-1.05.css" type="text/css" />
		<link rel="stylesheet" href="assets/lightbox.css" type="text/css" />

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
		
		
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/showmyattractions.controller" />">
		
		<ul>
			<li><button id=""  name="serch" value="1" class="btn_scene">
						臺北
				</button>
			</li>
			<li><button id=""  name="serch" value="2" class="btn_scene">
						新北
				</button></li>
			<li><button id=""  name="serch" value="3" class="btn_scene">
						桃園
				</button>
			</li>
			<li>
			<button id=""  name="serch" value="4" class="btn_scene">
						台中
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="5" class="btn_scene">
						台南
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="6" class="btn_scene">
						高雄	
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="7" class="btn_scene">
						新竹
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="8" class="btn_scene">
						苗栗
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="9" class="btn_scene">
						彰化	
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="10" class="btn_scene">
						南投
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="11" class="btn_scene">
						雲林
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="12" class="btn_scene">
						嘉義
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="13" class="btn_scene">
						屏東
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="14" class="btn_scene">
						宜蘭
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="15" class="btn_scene">
						花蓮
			</button>
			</li>
			<li>
			<button id=""  name="serch" value="16" class="btn_scene">
						台東
			</button>
			</li>
		</ul>
		</form>
	<c:forEach var="bean" items="${shoattion}">
		<!--景點-->
			<a name=" ${bean[1]}"></a>
			<article id="yangmingMountain${bean[0]}" class="main_introduce_loop">
			<img
				src="<c:url value='/PhotoId.show?hotelphotoid=${bean[0]}'/>"
				class="small_img_template" /> <section class="brief_introduction">
			<h3 class="search_box_title">${bean[1]}</h3>
			<em>&lt;${bean[2]}&gt;</em>
			<hr>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;${bean[4]}</p>
			<a class="togglelink${bean[0]}" style="position:relative;left:200px;cursor:pointer;">more information...</a> </section> </article>
			<!--跳出視窗，跳出景點-->
			<article id="yangmingMountain_detail${bean[0]}" class="loop">
			<div class="togglelink_window">
				<section class="LocationAndAddress">
				<h3 class="search_box_title">${bean[1]}</h3>
				<em style="color:#ff0000;">&lt;${bean[2]}&gt;</em>
				<h6>${bean[5]}</h6>
				</section>
				<img
					src="<c:url value='/PhotoId.show?hotelphotoid=${bean[0]}'/>"
					class="small_img_template" />
			</div>


			<iframe width="350" height="350" frameborder="0"
				src="https://www.google.com/maps?geocode=&q=${bean[6]},${bean[7]}&z=16&output=embed"></iframe>

			<div class="official_window" style="">
				<span class="official_font"><a target="_blank"
					href="${bean[8]}">官方網頁連結</a></span>
			</div>
			</article>
		</c:forEach>
		</div>
		
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="assets/changephotos/js/rhinoslider-1.05.min.js"></script>
		<script type="text/javascript" src="assets/changephotos/js/easing.js"></script>
		<script type="text/javascript" src="assets/changephotos/js/mousewheel.js"></script>
		<script type="text/javascript" src="js/lightbox.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
		$("#Mainframe").tabs();
		
		$(".btn_scene").button();
		</script>
		
		<script src="js/attion.js"></script>
		
	</body>
	
</html>
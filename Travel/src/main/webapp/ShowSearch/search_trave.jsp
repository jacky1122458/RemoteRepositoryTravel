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
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/style.css" type="text/css">
<link rel="stylesheet" href="css/goldblack.css" type="text/css" />
<link rel="stylesheet" href="css/search_travel.css" type="text/css">
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
	</div>
	<!-- container-fluid --> </nav>

				<c:url value="/showtour1.controller" var="link">
					<c:param name="serch" value='serch'/>
				</c:url>



	<div id="Mainframe">

<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/showtour1.controller" />">

			<!--書籤頁-->
		<ul>
			<li><button class="look" name="serch" value="serch">
						全部
				</button>
			</li>
			<li><button class="look" name="taiatt" value="2">
						台北
				</button>
			</li>
			<li><button class="look" name="newtai" value="4">
						新北
				</button>
			</li>
			<li>
				<button class="look" name="conatt" value="3">
						台中
				</button>
			</li>
			<li>
				<button class="look" name="tn" value="5">
						台南
				</button>
			</li>
		</ul>
		
		<c:forEach var="bean1" items="${tour}" >
		
		<!--景點-->
		<article class="main_introduce_loop">
				<section class="travel_information">
					<h3 class="search_box_title"><span class="ui-icon ui-icon-triangle-1-e"> </span>${bean1[1]}</h3>
					<p><span class="ui-icon ui-icon-calendar"> </span>出團日：<span class="travel_dateto">${bean1[11]}</span></p>
					<p><span class="ui-icon ui-icon-person"> </span>滿團人數：<span class="travel_maxperson">${bean1[2]}</span></p>
					<p><span class="ui-icon ui-icon-notice"> </span>集合地點：<span class="travel_meetingplace">${bean1[9]}</span></p>
					<p><span class="ui-icon ui-icon-notice"> </span>集合時間：<span class="travel_meetingtime">${bean1[4]}</span></p>
					<p style="position:relative;left:283px;top:-35px;"><span class="ui-icon ui-icon-notice"> </span>評價：<span class="travel_meetingtime">${bean1[13]}</span></p>
				</section>
				<div class="price_zone" style="position:relative;left:300px;top:-140px;">
					<p><span class="ui-icon ui-icon-cart"> </span>價錢（人頭計費）： TWD <span class="travel_perprice">${bean1[3]}</span><span class="ui-icon ui-icon-info"> </span></p>
				</div>
				
				<c:if test="${bean1[12] == false}">
		 		<button name="" onclick="return false;" style="background-color: #ffffff;">
						客滿
				</button>
		 		</c:if>
		 		<c:if test="${bean1[12] == true}">
		 		<button class="look" name="look" value="${bean1[0]}" style="position:relative;left:350px;">
						查看
				</button>
				</c:if>
								
				<section class="travel_comment" style="width:400px;height:auto;float:right;position:relative;top:-125px;">					
					<p>&nbsp;&nbsp;&nbsp;&nbsp;${bean1[10]}</p>
				</section>
			
		</article>
			<div class="spacing_line"> </div>
		
			
		</c:forEach>					
			
</form>		
</div>			
		
		
		<script type="text/javascript" src="assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript"
			src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript"
			src="assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="js/lightbox.js"></script>
		<script type="text/javascript" src="js/jquery.raty.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
		/*驗證*/
		$("#ckeckform").click(function(){
			if($("#member_name").val()=='' || $("#member_name").val().length<2){
				$("#member_name").val("需要輸入");
				return false;
			}else if($("#phone-number").val=='' || $("#phone-number").val().length!=10){
				$("#phone-number").val("需要正確號碼");
				return false;
			}else{
				alert("您已訂成功，即將跳回首頁");		
				window.location.replace('Index.html');
				
			}
		});
		
		$("#member_name").focus(function(){
			$(this).css("background-color","#F9F900");
			$("#member_name").after("<span id='tem1' style='color:#EA0000;font-size:12px;'>此欄為必填!</span>");
			$("#member_name").val("");
		});
		$("#member_name").blur(			
			function(){			
				$(this).css("background-color","#FFFFFF");
				$("#tem1").remove();
		});
		$("#phone-number").focus(function(){
			$(this).css("background-color","#F9F900");
			$("#phone-number").after("<span id='tem2' style='color:#EA0000;font-size:12px;'>此欄為必填!</span>");
			$("#phone-number").val("");
		});
		$("#phone-number").blur(			
			function(){			
				$(this).css("background-color","#FFFFFF");
				$("#tem2").remove();
		});
		
		/*build options*/
		var rest_person_num = 6;
			
		for(var i=1;i<=rest_person_num;i++){
			var myData = {
					string : "<option value=" + i + ">" + i + "</option>"
				};
			$(".person_count_selectbox").append(myData.string);
		}
		
		/*stars*/
		$(".travel_grade").raty({
			path:'images/',
			readOnly:true,
			score:3
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
		
		$("#Mainframe").tabs();
		$(".look").button();
		
		$(".price_zone").hover(
			function(){
				$(this).append($("<span style='color:#FF0000;'>6歲以上需加收台幣500</span>"));}
				, function() {
   					 $( this ).find( "span:last" ).remove();
		
		});
			
		
			
			
			
		</script>
		

</body>

</html>
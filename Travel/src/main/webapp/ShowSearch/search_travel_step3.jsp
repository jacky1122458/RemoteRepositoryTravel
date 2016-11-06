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
		<link rel="stylesheet" href="<c:url value='/assets/bootstrap/css/bootstrap.min.css'/>" type="text/css"/>
		<link rel="stylesheet" href="<c:url value="/assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" />" type="text/css"/>
		<link rel="stylesheet" href="<c:url value="/assets/style.css" />" type="text/css">
		<link rel="stylesheet" href="<c:url value="/css/goldblack.css" />" type="text/css">
		<link rel="stylesheet" href="<c:url value='/css/search_travel_detail.css'/>" type="text/css">
		<link rel="stylesheet" href="<c:url value='/assets/jquery.raty.css'/>" type="text/css" />

		<!-- favicon -->
		<link rel="shortcut icon" href="<c:url value='/images/favicon.png'/>" type="image/x-icon">
		<link rel="icon" href="<c:url value='/images/favicon.png'/>" type="image/x-icon">

		<style>
			#home {
				background-image: url("<c:url value='/images/photos/banner.jpg'/>");
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
		
		<form action="<c:url value="/order.controller" />" method="get">
		
		<div id="whole_block">
			<!-- class為bookstrap等同float:left -->
			<div id="main_block" class="" style="margin:0 auto;">
				<div id="ajaxsrwrap" style="background-color:#FFEEC0;border-radius:10px 10px 10px 10px;">
					<article id="form-to-submit" style="margin:0 auto;width:350px;height:500px;">
						<form id="send_information_form">
							<fieldset>
								<legend style="text-align:center;color:#FF0000;font-size:35px;">
									請填寫完整
								</legend>

							<p id="person_count">
								<span>人數：</span> <input id="person" type="text" name="num"onchange="changeprice()"> <span class="error">${error.num}</span> <p class="error">剩餘人數${settour[0][3]}</p>
							</p>

							<p>
								<label for="member_name">姓名：</label> <input type="text"
									name="name"> <span class="error">${error.name}</span>
							</p>
							<p>
								<label for="phone-number">電話：</label> <input type="text"
									name="phone"> <span class="error">${error.phone}</span>
							</p>
							<p>
								價錢： <span id='travel_price'> </span>
								<input id="price" type="text" name="price"
									value="${settour[0][2]}">
								<span class="error">${error.price}</span>

							</p>
							<p>
								出團日： <span id='date_togo'> </span> <input type="text"
									name="outdate" value="${settour[0][6]}" readonly="readonly">

							</p>
							<p>
								訂購日： <span id='date_buy'> </span> <input id="today" type="text"
									name="orderdate" value="" readonly="readonly">
							</p>
							<input class="ui-button ui-corner-all ui-widget" type="submit" name="prodaction" value="送出" style="float:right;">
							</fieldset>
						</form>
					</article>
				</div>
			</div>
		</div>
				
		<script type="text/javascript" src="<c:url value="/assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js" />"></script>
		<script type="text/javascript" src="<c:url value="/assets/jquery-ui-1.12.1.custom/jquery-ui.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/assets/bootstrap/js/bootstrap.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
			/*驗證*/
			$("#ckeckform").click(function() {
				if ($("#member_name").val() == '' || $("#member_name").val().length < 2) {
					$("#member_name").val("需要輸入");
					return false;
				} else if ($("#phone-number").val == '' || $("#phone-number").val().length != 10) {
					$("#phone-number").val("需要正確號碼");
					return false;
				} else {
					alert("您已訂成功，即將跳回首頁");
					window.location.replace('Index.html');

				}
			});

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

			/*build options*/
			var rest_person_num = 6;

			for (var i = 1; i <= rest_person_num; i++) {
				var myData = {
					string : "<option value=" + i + ">" + i + "</option>"
				};
				$(".person_count_selectbox").append(myData.string);
			}

			$("#ckeckform").button();

			</script>
			
			
			<script type="text/javascript">
var unchag = new Date();
var result = unchag.getFullYear() + "-" + (unchag.getMonth()+1) + "-" +unchag.getDate();
document.getElementById("today").value = result;

function changeprice(){
var x = document.getElementById("person").value;
var y = document.getElementById("price").value;
var z = parseInt(x*y);
document.getElementById("price").value = z;
}
</script>
	</body>

</html>
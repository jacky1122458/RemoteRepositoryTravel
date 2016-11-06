<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Welcome G&King</title>
		<meta name="Jeff" content="Student" />
		<!-- Date: 2016-10-05 -->
		<!-- bootstrap -->
		<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
		<link rel="stylesheet" href="../assets/style.css" type="text/css">
		<link rel="stylesheet" href="../css/goldblack.css" type="text/css" />
		<link rel="stylesheet" href="../css/check_room_reserve.css" type="text/css">
		<link rel="stylesheet" href="../assets/changephotos/rhinoslider-1.05.css" type="text/css" />
		<link rel="stylesheet" href="../assets/lightbox.css" type="text/css" />

		<!-- favicon -->
		<link rel="shortcut icon" href="../images/favicon.png" type="image/x-icon">
		<link rel="icon" href="../images/favicon.png" type="image/x-icon">

		<style>
			#home {
				background-image: url("../images/photos/banner.jpg");
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
		<div id="whole_block">
			<!-- class為bookstrap等同float:left -->
			<form id="search_box" class="search_box_tem" style="width: 1000px;margin: 0 auto;margin-top: 50px;" method="get" action="<c:url value="/pages/HotelServlet" />">
			<c:forEach var="bean" items="${roomBean}">
				<Input type='hidden' name='roomid' value='${bean[0]}'><P/>
				<Input type='hidden' name='roomName' value='${bean[1]}'><P/>
				<Input type='hidden' name='price' value='${bean[2]}'><P/>
				<Input type='hidden' name='peoplenum' value='${bean[3]}'><P/>
				<Input type='hidden' name='roomNumbers' value='${bean[4]}'><P/>
				<Input type='hidden' name='status' value='${bean[5]}'><P/>
			</c:forEach>
				<Input type='hidden' name='price_total' value='${price_total}'><P/>
				<Input type='hidden' name='memberid' value='${memebrbean.memberid}'><P/>
				<Input type='hidden' name='orderday' id="orderday"><P/>
			<div id="main_block">
				<div id="ajaxsrwrap" style="background-color:#FFEEC0;border-radius:10px 10px 10px 10px;">
					<article style="width:inherit;height:450px;margin:5px 5px;padding:5px 5px;">
						<div style="width:240px;height:360px;float:left;">
						<img class="hotel_image" src="../images/hotel_images/17258767.png">
						</div>
						<div class="check_hotel_content" style="">
							<h3 class="fontstylebar">${hotelbean.hotelname}</h3>
							<p style="font-style:italic;">${hotelbean.address}</p>
							<p class="reserve_canceldate">預定可取消時間為入住日期3天前</p>
							<div class="spacing-line"> </div>
							<div style="width:160px;height:25px;position:relative;top:25px;">
								<strong style="font-size:1.5em">價格：</strong><br>
								<span style="font-size:12px;">（人數為${peoplenum}位）</span>
							</div>
							<div class="hotel_room_price">
								<strong>${price_total}</strong>
							</div>
						</div>
						<div class="checkinandout">
							<p style="font-size:25px;">入住日期：</p>
							<span style="font-size:20px;">${checkin}（15:00起）</span>
						</div>
						<div class="checkinandout" style="top: 206px;left: -400px;">
							<p style="font-size:25px;">退房日期：</p>
							<span style="font-size:20px;">${checkout}（12:00前）</span>
						</div>
						<button id="checked" type="submit" name='order' value='order'>確認！</button>
					</article>
					<div class="spacing-line"> </div>
				<!--會員資訊-->
					<article style="width:inherit;height:auto;margin:5px 5px;padding:5px 5px;">
						<h3>請確認這張訂單是否是您要訂的房間、日期以及是您的會員資料</h3>
							<span>會員名字：<input class="input_member_info" type="text" name='memberName'/></span><br>
							<span>聯絡手機：<input class="input_member_info" type="text" name='cellphone'/></span><br>
							<span>備註：<textarea maxlength="50" style="vertical-align:text-top;margin-left:50px;resize:none;width:200px;height:50px;" name='spec'> </textarea></span>
						</form>
					</article>
				</div>
			</div>
		

		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="../assets/changephotos/js/rhinoslider-1.05.min.js"></script>
		<script type="text/javascript" src="../assets/changephotos/js/easing.js"></script>
		<script type="text/javascript" src="../assets/changephotos/js/mousewheel.js"></script>
		<script type="text/javascript" src="../js/lightbox.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
			$("#checked").button();
		</script>
		<script type="text/javascript">
			var day = new Date();
			var string = day.getFullYear()+"/"+(day.getMonth()+1)+"/"+day.getDate();
			document.getElementById("orderday").value=string;
		</script>
	</body>

</html>
<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>我的資料</title>
		<meta name="Jeff" content="Student" />
		<!-- Date: 2016-10-07 -->
		<!-- bootstrap -->
		<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/style.css" type="text/css">
		<link rel="stylesheet" href="../css/goldblack.css" type="text/css">
		<link rel="stylesheet" href="../css/member_info.css" type="text/css">

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
						}
		</style>

	</head>
	<body id="home">
		<nav class="navbar  navbar-default" role="navigation">
			<div class="container">
					<jsp:include page="/include/head.jsp" />
			</div><!-- container-fluid -->
		</nav>
</head>
<body>
<%

// if(session.getAttribute("memberBean")==null)
// {
// 	{out.print("<script>alert('請先登入會員！');window.location.href='login.jsp'</script>");
// // 	response.sendRedirect("login.jsp");
// 	}
// }
 
%>
<div id="central">
<form>
<p class="s" style="display:none;">id：</p><span style="display:none;">${memberBean.memberid}</span>
<p class="s">帳號：</p><span>${memberBean.account}</span>
<p class="s">會員名稱：</p><span>${memberBean.lastname}${memberBean.firstname}</span>
<p class="s">性別：</p><span name="sex">${memberBean.sex}</span>
<p class="s">信箱：</p><span>${memberBean.email}</span>
<p class="s">生日：</p><span name="birth">${memberBean.birth}</span>
<p class="s">手機：</p><span>${memberBean.cellphone}</span>
<p class="s">地址：</p><span style="font-size:12px">${memberBean.address}</span>
<input type="button" class="update" value="更新" style="position: relative;left:120px;top:15px;">
</form>
</div>
<div id="jump" style="display:none;">
<jsp:include page="/client/update.jsp" />
</div>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
 		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
	
		<script>
		$(".update").click(function() {
			$("#jump").dialog({
				width : 500,
				height : 500,
				show : {
					effect : "fold",
					duration : 800,
				},
				draggable : false,
				dialogClass: "no-close",		         
				modal : true,
				open: function(event, ui) {
			        $(".ui-dialog-titlebar-close", ui.dialog | ui).hide();
			    }
				});});
		
		
			$(function(){
				var a = $("span[name='sex']").text();
				if(a=='M'){
					$("span[name='sex']").text("男");
				}else if(a=='F'){
					$("span[name='sex']").text("女");
				}
				
				var b = $("span[name='birth']").text();
				b = b.substr(0,10);
				$("span[name='birth']").text(b);
				
				$("#birth").datepicker({
					dateFormat:"yy/mm/dd",
					changeYear: true,
					changeMonth: true,
					yearRange: "-100:+0"
				});
				
				$(".update").button();
			});

		</script>
			
	</body>
</html>
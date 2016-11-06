<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("join")!=null)
	{out.print("<script>alert('註冊成功!請去查看驗證信並重新登入');window.location.href='login.jsp'</script>");
	}
	session.removeAttribute("join");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Welcome G&King</title>
		<meta name="Jeff" content="Student" />
		<!-- Date: 2016-10-07 -->
		<!-- bootstrap -->
		<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap-theme.min.css" type="text/css" />
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.structure.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.theme.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/style.css" type="text/css">
		<link rel="stylesheet" href="../css/goldblack.css" type="text/css">
		<link rel="stylesheet" href="../css/login.css" type="text/css">

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

		<form id="central" action='<c:url value="/client/login.controller" />'  method="get">
		
			<span class="span">使用者帳號：</span>
			<input class="entercolumn"name="account" value="${account}" type="text" placeholder="account" />
			<p style="color:red;">${errors.account} </p><br>
			<span class="span">使用者密碼：</span>
			<input class="entercolumn"name="password" value="${password}" type="password" placeholder="password" />
			<p style="color:red;">${errors.password} </p><br>
			<table>
                <form action='<c:url value="/client/captcha" />'  method="Post">
                <p style="text-align: left;position: relative;left: 20px;">
                	<img src="captcha"  height="50" width="150">
               		<input type="button" value="換一張"  onclick="location.reload()" style="position: relative;top: -10px;">               
                </p>
                </form>
            </table>    
            <span style="position: relative;left: -45px;font-weight:bolder;">驗證碼</span>
            <input type="text"
                name="checkCode" size="20" value="${sessionscope.checkCode}">
                &nbsp;<small>
                <p style="color:red;" size="-3">${errors.CheckCodeEmptyError}</p></small><br>
            
<!-- <fb:login-button scope="public_profile,email" onlogin="checkLoginState();" data-auto-logout-link="true"> -->
<!-- </fb:login-button> -->
			
			<div id="remember">
			<input type="checkbox" name="rememberMe" id="insurance" value="rememberMe"/>
			<label for="insurance">讓我保持登入</label>
			<a class='forget'>忘記密碼</a>
			</div>
			<div style="margin-top:15px;">
				<button id="button" type="submit" class="ui-button ui-corner-all ui-widget" >
					登入
				</button>
				<div class="fb-login-button" onlogin="checkLoginState();"data-max-rows="1" data-size="medium" data-show-faces="false" data-auto-logout-link="true"></div>
			</div>
			<span style="color:red;">,${errors.nostu}</span>
			<div class="session">
				"還沒有帳戶嗎?"
				<a id="signup" href="join.jsp">立刻註冊</a>
			</div>
		</form>
		<div id="jump" style="display:none;">
			<jsp:include page="/client/forget.jsp" />
		</div>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		
		<div id="fb-root"></div>
<script>
	$(".forget").click(function() {
		$("#jump").dialog({
			width : 400,
			height : 150,
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
(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if 
  (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.8&appId=207731066328344";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
 
// This is called with the results from from FB.getLoginStatus().
function statusChangeCallback(response) {
  console.log('statusChangeCallback');
  console.log(response);
  // The response object is returned with a status field that lets the
  // app know the current login status of the person.
  // Full docs on the response object can be found in the documentation
  // for FB.getLoginStatus().
  if (response.status === 'connected') {
    // Logged into your app and Facebook.
    testAPI();
  } else if (response.status === 'not_authorized') {
    // The person is logged into Facebook, but not your app.
    document.getElementById('status').innerHTML = 'Please log ' +
      'into this app.';
  } else {
    // The person is not logged into Facebook, so we're not sure if
    // they are logged into this app or not.
    document.getElementById('status').innerHTML = 'Please log ' +
      'into Facebook.';
  }
}
 
// This function is called when someone finishes with the Login
// Button.  See the onlogin handler attached to it in the sample
// code below.
function checkLoginState() {
  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
}
 
// Here we run a very simple test of the Graph API after login is
// successful.  See statusChangeCallback() for when this call is made.
function testAPI() {
  console.log('Welcome!  Fetching your information.... ');
  FB.api('/me', function(response) {
    console.log('Successful login for: ' + response.name);
    document.getElementById('status').innerHTML =
      'Thanks for logging in, ' + response.name + '!';
  });
 
}
    </script>	
	</body>
</html>
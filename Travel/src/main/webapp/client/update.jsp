<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" type="text/css"/>
		<link rel="stylesheet" href="../assets/style.css" type="text/css">
		<link rel="stylesheet" href="../css/goldblack.css" type="text/css">
		<link rel="stylesheet" href="../css/member_info.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新</title>
</head>
<body>
<div id="central">
<form action='<c:url value="/client/update.controller" />'  method="post">

	<span class="s" style="display:none;">id：</span><input type="text"  style="display:none;" name="memberid"value="${memberBean.memberid}"readonly="readonly"  style="display:none;">
	<span class="s" style="display:none;">帳號：<input type="text"  style="display:none;" name="account"value="${memberBean.account}"readonly="readonly"></span>
	<span class="s" style="display:none;">信箱：<input type="text"  style="display:none;" name="email"value="${memberBean.email}"readonly="readonly"></span>
	<span class="s">密碼：<input type="password" name="password" value="${sessionScope.userpassword}"></span><br>
	<span class="s">手機：<input type="text" maxlength="10" name="cellphone"value="${memberBean.cellphone}"></span><br>
	<span class="s">地址：</span><input type="text" style="width:320px" name="address"size="35" value="${memberBean.address}"><br>
	<input type="submit" value="更新資料" name="prodaction" style="color: black;position: relative;left:120px;top:15px;">
</form>
</div>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
		<script type="text/javascript" src="../assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../assets/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		<script>
			$("input[name='prodaction']").button();		
		</script>
</body>
</html>
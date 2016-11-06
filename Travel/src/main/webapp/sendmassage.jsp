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
		<link rel="stylesheet" href="assets/bootstrap/css/bootstrap-theme.min.css" type="text/css" />
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.min.css"/>
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.structure.min.css"/>
		<link rel="stylesheet" href="assets/jquery-ui-1.12.1.custom/jquery-ui.theme.min.css"/>
		<link rel="stylesheet" href="assets/style.css" type="text/css">


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
	
	<body>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.net.*" %>
<%@ page import = "java.io.*" %>

<%!
String strOnlineSend;
String thisLine;
URL u;
URLConnection uc;
%>

<%
strOnlineSend = "http://api.bizmm.com/SendSMS.php?CID=s85761056&CPW=s2dgiixdl&N=0970173015&M="+URLEncoder.encode("測試API簡訊");
u = new URL(strOnlineSend);
try {
    uc = u.openConnection();
    BufferedReader theHTML = new BufferedReader(new InputStreamReader(uc.getInputStream()));
    thisLine = theHTML.readLine();
    if (thisLine.substring(0, 3).equalsIgnoreCase("00:") ) {
        %>
        MSGID: <%=thisLine.substring(3)%>
        <%
    }
    else {
        %>
        錯誤代碼: <%=thisLine.substring(0, 2)%> 
        <%
    }
}
catch(Exception e) {
    %>
    無法連結網站 <%=e.getMessage()%>
    <%
}
%>
	
</html>
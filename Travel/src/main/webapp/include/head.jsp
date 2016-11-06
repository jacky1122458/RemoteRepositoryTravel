<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<c:url value="/Index.jsp" />"><img src="<c:url value="/images/icon.png" />"  alt="Welcome"></a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">

					<ul class="nav navbar-nav">
						<li>
							<a href="<c:url value="/Index.jsp" />">Home </a>
						</li>
						<li>
							<a href="<c:url value="/showtour1.controller?serch=serch" />">搜尋旅程</a>
						</li>
						<li>
							<a href="<c:url value="/showmyattractions.controller?myatt=myatt"/>">查看景點</a></li>
						</li>
						<c:if test="${empty memberBean }">
						<li>
							<a href="<c:url value="/client/login.jsp" />">會員登入</a>
						</li>
						</c:if>
		<c:choose>
			<c:when test="${!empty memberBean }">
						<li><a style="color:red">歡迎您，${memberBean.lastname}${memberBean.firstname}</a></li>
				<div id="menu" style="float: right;">
					<div class="main">會員專區</div>
					<div class="sub" id="reservation">
						<ul>
							<li><a href="<c:url value="/client/member.jsp" />">個人資訊</a></li>
							<li><a
								href="<c:url value="/order/Hotel_orderForCheckingServlet" />">旅館訂單</a></li>
							<li><a
								href="<c:url value="/showmyorder.controller?myorder=myorder"/>">行程訂單</a></li>
							<li><a href="<c:url value="/myeva.controller?myeva=myeva"/>">旅程評論</a></li>
						</ul>
					</div>
				</div>
				<div style="float: right;">
					<div class="main">
						<a href="<c:url value="/client/logout.jsp" />">登出</a>
					</div>
				</div>
			</c:when>
		</c:choose>
	</ul>
				</div><!-- Wnavbar-collapse -->
				
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
	<style type="text/css">
		.ifile {position:absolute;opacity:0;filter:alpha(opacity=0);}
		</style>
	</head>
	<body>
<div style="width:500px;height:500px;">
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/InsertPhotoServlet" />">
					<div class="search_box_tem">
							<div>
							<label>roomid</label>
							<input type="text" id="roomid" name="roomid" value="1"/>
						</div>
						<div>
							<label>photopath</label>
							<input type="file" id="photopath" name="photopath" size="20"  class="ifile" />
							<input type="text" name="upfile" size="20" readonly>
						</div>
					</div>
					<button id="submit_btn" name="submit_btn" value="insert">
						insert
					</button>
				</form>
			</div>
	</body>
</html>
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
		<!-- favicon -->
	</head>
	<body>
<div style="width:500px;height:500px;">
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/pages/RoomServlet2" />">
					<div class="search_box_tem">
						<div>
							<label>hotel_id</label>
							<input type="text" id="hotelid" name="hotelid" value="1"/>
						</div>
							<div>
							<label>roomid</label>
							<input type="text" id="roomid" name="roomid" value="1"/>
						</div>
						<div>
							<label>roomname</label>
							<input type="text" id="roomname" name="roomname" value="雙人房"/>
						</div>
						<div>
							<label>price</label>
							<input type="text" id="price" name="price" value="20000"/>
						</div>
						<div>
							<label>weekdayrate</label>
							<input type="text" id="weekdayrate" name="weekdayrate" value="4000"/>
						</div>
						<div>
							<label>peoplenum</label>
							<input type="text" id="peoplenum" name="peoplenum" value="2"/>
						</div>
						<div>
							<label>bedtype</label>
							<input type="text" id="bedtype" name="bedtype" value="一張雙人床"/>
						</div>
						<div>
							<label>number</label>
							<input type="text" id="number" name="number" value="3"/>
						</div>
						<div>
							<label>area</label>
							<input type="text" id="area" name="area" value="1"/>
						</div>
						<div>
							<label>status</label>
							<input type="text" id="status" name="status" value="true"/>
						</div>
					</div>
					<button id="submit_btn" name="submit_btn" value="insert">
						insert
					</button>
					<button id="submit_btn"  name="submit_btn" value="update">
						update
					</button>
				</form>
			</div>
	</body>
</html>
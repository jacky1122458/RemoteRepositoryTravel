<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display</title>

</head>
<body>
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/pages/HotelServlet" />">
			memberid<Input type='text' name='memberid' value='${memberid}'><P/>
			orderday<Input type='text' name='orderday' id="orderday"><P/>
    		name<Input type='text' name='name' value='王先生'><P/>
    		cellphone<Input type='text' name='cellphone' value='0933818538'><P/>
    		spec<Input type='text' name='spec' value=''><P/>
    		================================================================
<table>
	<thead>
	<tr>
		<th>roomname</th>
		<th>price</th>
		<th>peoplenum</th>
		<th>room_numbers</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="bean1" items="${rooms}">
			roomid<Input type='text' name='roomid' value='${bean1[0]}'><P/>
		 	roomname<Input type='text' name='roomname' value='${bean1[1]}'><P/>
            price<Input type='text' name='price' value='${bean1[2]}'><P/>
            peoplenum<Input type='text' name='peoplenum' value='${bean1[3]}'><P/>
            room_numbers<Input type='text' name='room_numbers' value='${bean1[4]}'><P/>
            status<Input type='text' name='status' value='true'><P/>
           ================================================================== 
		 	<tr>
		 		<td>${bean1[1]}</td>
		 		<td>${bean1[2]}</td>
		 		<td>${bean1[3]}</td>
		 		<td>${bean1[4]}</td>
		 	</tr>		 	  
			
				
				<c:url value="/pages/photo.view" var="link">
					<c:param name="id" value='${bean1[0]}'/>
				</c:url>
			<tr>
				<td><a href="${link}"><img src="../img/click.png"/></a></td>
			</tr>
	</c:forEach>
		
	</tbody>
</table>
	<button id="order" class="ui-button ui-corner-all ui-widget" name="order" value="order">
						order
	</button>
</form>
<h3><a href="<c:url value="/pages/search.jsp" />">查詢旅館</a></h3>
<script type="text/javascript">
	var day = new Date();
	var string = day.getFullYear()+"/"+(day.getMonth()+1)+"/"+day.getDate();
	document.getElementById("orderday").value=string;
</script>
</body>
</html>
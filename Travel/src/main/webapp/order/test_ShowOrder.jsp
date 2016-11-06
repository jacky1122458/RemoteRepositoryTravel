<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach var="bean" items="${roomBean}">
		roomid<Input type='text' name='roomid' value='${bean[0]}'><P/>
		roomNameroomid<Input type='text' name='roomName' value='${bean[1]}'><P/>
		price<Input type='text' name='price' value='${bean[2]}'><P/>
		peoplenum<Input type='text' name='peoplenum' value='${bean[3]}'><P/>
		roomNumbers<Input type='text' name='roomNumbers' value='${bean[4]}'><P/>
		status<Input type='text' name='status' value='${bean[5]}'><P/>
	</c:forEach>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
session=request.getSession();
   String f=(String)session.getAttribute("forgetok");

if(f!=null&&f!="")
{
session.invalidate();
	{out.print("<script>alert('已發送密碼至您的信箱,請重新登入');window.location.href='login.jsp'</script>");
// 	response.sendRedirect("login.jsp");
	}
}else{out.print("<script>alert('??????????????');window.location.href='index.jsp'</script>");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
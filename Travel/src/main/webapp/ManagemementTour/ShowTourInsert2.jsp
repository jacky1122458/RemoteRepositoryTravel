<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<title>Product</title>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/json2.js"></script>
<script type="text/javascript" src="../js/product.js"></script>
<script type="text/javascript">

function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>



</head>
<body>
<h3>新增</h3>
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/showtourinsert2.controller" />">

	
	<table>
			<thead>
				<tr>
					<th>1<input type="hidden" name="member1" value="1" ></th>
					<th>
								<select name="attion1" size="1" id="y"  > 
								<c:forEach items="${show20}" var="bean">
								<option value="${bean[0]}">${bean[1]}</option> 
								</c:forEach>
								</select> 
					</th>
				</tr>
				<tr>
					<th>2<input type="hidden" name="member2" value="2" ></th>
					<th><select name="attion2" size="1" id="y"  > 
								<c:forEach items="${show20}" var="bean">
								<option value="${bean[0]}">${bean[1]}</option> 
								</c:forEach>
								</select> 
					</th>
				</tr>
				<tr>
					<th>3<input type="hidden" name="member3" value="3" ></th>
					<th><select name="attion3" size="1" id="y"  > 
								<c:forEach items="${show20}" var="bean">
								<option value="${bean[0]}">${bean[1]}</option> 
								</c:forEach> 
								</select> 
					</th>
				</tr>
					</thead>
				</tbody>
	</table>
	
		
			<button name="insert" value="insert">新增</button>
		
	
</form>
</body>
</html>
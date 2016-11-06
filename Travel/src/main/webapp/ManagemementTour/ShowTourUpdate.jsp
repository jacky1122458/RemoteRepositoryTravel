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
<h3>修改</h3>
<form id="search_box" class="search_box_tem" method="get" action="<c:url value="/showtourupdate.controller" />">
		<input type="text" name="tourid" value="${tour[0][0]}">

<table>
	<tr>
		<td>旅程名稱: </td>
		<td><input type="text" name="tourname" value="${tour[0][1]}"></td>
		<td><span class="error">${error.id}</span></td>
	</tr>
	<tr>
		<td>開團人數: </td>
		<td><input type="text" name="member" value="${tour[0][2]}"></td>
		<td></td>
	</tr>
	<tr>
		<td>旅程價錢: </td>
		<td><input type="text" name="price" value="${tour[0][3]}"></td>
		<td><span class="error">${error.price}</span></td>
	</tr>
	<tr>
		<td>集合時間: </td>
		<td><input type="text" name="make" value="${tour[0][4]}"></td>
		<td><span class="error">${error.make}</span></td>
	</tr>
	<tr>
		<td>額外費用: </td>
		<td><input type="text" name="expire" value="${tour[0][5]}"></td>
		<td><span class="error">${error.expire}</span></td>
	</tr>
	<tr>
		<td>年齡限制: </td>
		<td><input type="text" name="max" value="${tour[0][6]}"></td>
		<td><span class="error">${error.max}</span></td>
	</tr>
	<tr>
		<td>是否供餐: </td>
		<td><input type="text" name="fool" value="${tour[0][7]}"></td>
		<td><span class="error">${error.fool}</span></td>
	</tr>
	<tr>
		<td>備註: </td>
		<td><input type="text" name="remark" value="${tour[0][8]}"></td>
		<td><span class="error">${error.remark}</span></td>
	</tr>
	<tr>
		<td>集合地點: </td>
		<td><input type="text" name="meet" value="${tour[0][9]}"></td>
		<td><span class="error">${error.meet}</span></td>
	</tr>
	<tr>
		<td>經度: </td>
		<td><input type="text" name="lat" value="${tour[0][10]}"></td>
		<td><span class="error">${error.lat}</span></td>
	</tr>
	<tr>
		<td>緯度: </td>
		<td><input type="text" name="lng" value="${tour[0][11]}"></td>
		<td><span class="error">${error.lng}</span></td>
	</tr>
	<tr>
		<td>說明: </td>
		<td><input type="text" name="ex" value="${tour[0][13]}"></td>
		<td><span class="error">${error.ex}</span></td>
	</tr>
	<tr>
		<td>狀態: </td>
		<td><input type="text" name="status" value="${tour[0][12]}"></td>
		<td><span class="error">${error.ex}</span></td>
	</tr>
	<tr>
		<td>出團日期: </td>
		<td><input type="text" name="outdate" value="${tour[0][14]}"></td>
		<td><span class="error">${error.outdate}</span></td>
	</tr>
	<tr>
		<td>
			<button name="change" value="change">修改</button>
		</td>
	</tr>
</table>


	<table>
			<thead>
				<tr>
					<th>${resultop[0][0]}<input type="hidden" name="member1" value="${resultop[0][1]}" ></th>
					<th><select name="attion1" size="1" id="y"  > 
								<option value="1">1</option> 
								<option value="2">2</option> 
								<option value="3">3</option> 
						</select> 
					</th>
				</tr>
				<tr>
					<th>${resultop[1][0]}<input type="hidden" name="member2" value="${resultop[1][1]}" ></th>
					<th><select name="attion2" size="1" id="y"  > 
								<option value="1">1</option> 
								<option value="2">2</option> 
								<option value="3">3</option>
						</select> 
					</th>
				</tr>
				<tr>
					<th>${resultop[2][0]}<input type="hidden" name="member3" value="${resultop[2][1]}" ></th>
					<th><select name="attion3" size="1" id="y"  > 
								<option value="1">1</option> 
								<option value="2">2</option> 
								<option value="3">3</option>
						</select> 
					</th>
				</tr>
					</thead>
				</tbody>
	</table>
	
</form>
</body>
</html>
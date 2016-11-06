<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Welcome G&King</title>
		<meta name="Jeff" content="Student" />
		<!-- Date: 2016-10-05 -->
		<!-- bootstrap -->
		<link rel="stylesheet" href="<c:url value="/assets/bootstrap/css/bootstrap.min.css" />" type="text/css"/>
		<link rel="stylesheet" href="<c:url value="/assets/jquery-ui-1.12.1.custom/jquery-ui.min.css" />" type="text/css"/>
		<link rel="stylesheet" href="<c:url value="/assets/style.css" />" type="text/css">
		<link rel="stylesheet" href="<c:url value="/css/goldblack.css" />" type="text/css">
		<link rel="stylesheet" href="<c:url value="/css/hotel_room_detail.css" />" type="text/css">
		<link rel="stylesheet" href="<c:url value="/assets/changephotos/rhinoslider-1.05.css" />" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/assets/lightbox.css" />" type="text/css" />
		
		<!-- favicon -->
		<link rel="shortcut icon" href="<c:url value="/images/favicon.png" />" type="image/x-icon">
		<link rel="icon" href="<c:url value="/images/favicon.png" />" type="image/x-icon">

		<style>
			#home {
				background-image: url("<c:url value="/images/photos/banner.jpg" />");
				background-repeat: repeat;
				background-color: #3C3C3C;
			}
		</style>

	</head>
	<body id="home">
		<nav class="navbar  navbar-default" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<!-- Collect the nav links, forms, and other content for toggling -->
					<jsp:include page="/include/head.jsp" />
			</div><!-- container-fluid -->
		</nav>
		<div id="whole_block">
			<!-- class為bookstrap等同float:left -->
			<div id="side_block" class="pull-left">
				<jsp:include page="/include/searchframe.jsp" />
			</div>
			<div id="main_block" class="pull-right">
				<div id="ajaxsrwrap">
					<div data-block-id="sr_warnings">
						<div class="sr_warnings__content"></div>
					</div>
					<!--旅館內房間-->
					<div class="gallery-container" id="photo_wrapper">
						<ul id="slideshow" class="big_showimage">
							<c:forEach var="bean" items="${hotelphoto}">
                            <li><img src="<c:url value='/HotelPhotoId.show?hotelphotoid=${bean.hotelphotoid}' />"></img>
                            </li>
                            </c:forEach>
						</ul>
					</div>
					<!--小圖放置區-->
					<div id="images-compress-zone">
						<c:forEach var="bean" items="${hotelphoto}">
                        <a target="_blank" href="<c:url value='/HotelPhotoId.show?hotelphotoid=${bean.hotelphotoid}' />" class="hotel_thumbs change_large_on_hover" onclick="return false;"><img src="<c:url value='/HotelPhotoId.show?hotelphotoid=${bean.hotelphotoid}' />" style="width: 36px;height: 36px;"></a>
                        </c:forEach>
					</div>
					 <div id="Mainframe">
                        <ul>
                            <li><a href="#hotel_introducion_hightlight_wrapper">旅館簡介</a></li>
                            <li><a href="#hotel_comment">旅館評價</a></li>
                        </ul>
                        <jsp:include page="/include/hotelInformation.jsp" />
					</div>
				
					<form id="search_rooms" class="search_box_tem" method="post" action="<c:url value="/order/ShowRoomsToOrderSerlet" />">
						<table class="showroom_list_table">
							<thead class="header_of_table" style="visibility:hidden;width:auto;">
								<tr>
									<th class="roomtype_col" style="width:200px;">客房類型</th>
									<th class="roompeople_col" style="width:100px;">客房人數</th>
									<th class="nowprice_col" style="width:130px;">今日價格</th>
									<th class="decideroom_col" style="width:60px">選擇客房</th>
									<th class="reserveroom_col" style="width:110px;">預定客房</th>
								</tr>
							</thead>
							<thead class="header_of_table">
								<tr>
									<th class="roomtype_col" style="width:200px;">客房類型</th>
									<th class="roompeople_col" style="width:100px;">客房人數</th>
									<th class="nowprice_col" style="width:130px;">今日價格</th>
									<th class="decideroom_col" style="width:60px">選擇客房</th>
									<th class="reserveroom_col" style="width:110px;">預定客房</th>
								</tr>
							</thead>
							<tbody>
								
								<tr>
									<td colspan="4" style="padding:0"> </td>								
									<td id="bookNow1" rowspan="400" style="border-right: 0 none !important;min-width:121px;"><!-- start: roomAvailability_roomBook -->
										<div class="bookNowWrap" style="display: block; width: 110px; top: 30px;">
											<div id="booking-summary" style="display: none;">
												<span class="rooms-count"></span>
												<span class="total-price"></span>
												<span class="breakfast-included g-hidden"> <i class=" bicon-coffee mp-icon meal-plan-icon jq_tooltip" title="房價包括早餐。"></i> 包括早餐 </span>
											</div>
											
										<button class="b-button b-button_primary js-rt__summary__reserve-button  no_wrap_cjk hp_rt_input" type="submit" data-title="前往下一步" id="b_tt_holder_3" name="order" value="order" style="position: relative;left: 30px;">
											<span class="b-button__text"> 現在就
												<br>
												預訂 </span>
												<tr>
								</tr>
										</button>
									</div>
										<!-- end: roomAvailability_roomBook -->
									</td>
								</tr>
 							<Input type='hidden' name='orderday' id="orderday"><P/>
                            <Input type='hidden' name='checkin' value='${checkin}'><P/>
                            <Input type='hidden' name='checkout' value='${checkout}'><P/>
                            <Input type='hidden' name='memberid' value=1><P/>
 
 
 
 
                            <c:forEach var="bean1" items="${select1}">
                            <Input type='hidden' name='roomid' value='${bean1[0]}'><P/>
                            <Input type='hidden' name='roomname' value='${bean1[1]}'><P/>
                            <Input type='hidden' name='price' value='${bean1[2]}'><P/>
                            <Input type='hidden' name='peoplenum' value='${bean1[3]}'><P/>
                            <Input type='hidden' name='bedType' value='${bean1[5]}'><P/>
                            <Input type='hidden' name='status' value='true'><P/>
								<tr>
									<td class="room_Type" rowspan="2">
										<span style="display:block;"> <a class="togglelink" href="#RD55587204"> <i class="ui-icon ui-icon-circle-triangle-e"> ::before </i> ${bean1[1]} </a>
											<div style="display:block;">
												<label class="rt_bed_label" style="color:#ff0000"> 床型： </label>
												<ul class="rt_bed_types" style="display:inline-block">
													<li class="rt_bed_type" style="display:inline-block">
														${bean1[5]}
													
													</li>
													<img src="<c:url value="/images/bed_type.png" />" style="margin-left:50px;">
												</ul>
												<div class="small_notice" style="padding:5px 10px;">
												"價格是按每間客房計算的"
													<div class="IncExcPriceNew">
													"房價"
														<span class="IncOrExc">包括</span>
													"：5%增值稅， 10%服務費"
													</div>
												</div>
											</div>
										</span>
									</td>
									
								</tr>
								
								
								<tr class="room_loop_counter1">
									<td class="roomMaxpersons" style="border-bottom:1px #FF0000 solid;text-align:center;">
									<div class="control_person_col" style="display:inline;">
										<span class="person_adults" name="person_adults"> </span>
									</div></td>
									<td class="control_rooms_price" style="font-size:14px;border-bottom:1px #FF0000 solid;text-align:center;"><span class="room_price"> <strong>${bean1[2]}</strong> </span></td>
									<td class="control_rooms_number" style="font-size:14px;border-bottom:1px #FF0000 solid;">
									<div class="roomDefaultUse">
										<input type="text" name='roomNumber' value='${bean1[4]}' style="display:none;">
										<select class="room_limitedbox1" name="selector"  data-price="${bean1[2]}" data-roomnumber="${bean1[4]}" data-peoplenumber="${bean1[3]}" style="padding-left: 25px;">
											<option value="0">--請選擇--</option>
										</select>
									</div></td>
								</tr>
<%-- 								<c:forEach var="bean" items="${bean}"> --%>
<%--                                        <img src='${pageContext.servletContext.contextPath}/pages/ShowRoomPhotoSerlver?roomPhotoId=${bean.roomPhotoId}'/> --%>
<%--                                 </c:forEach>   --%>
								<!-- 暴力分法 ，問題怎樣把以上TR的高度固定-->

									<!-- <tr id="RD55587204" class="room_loop_counter1_extendedRow"
										style="border-collapse: separate;">
										<td colspan:"4" style="display: block;">
											<div class="blocktoggle">
												<a title="close" close_button_roomtable></a>
												<div class="lightbox_left_container">
													<div class="lightbox_gallery">
														<div class="lightbox_review_container">
															<p class="lightbox_review_container_header">整體評分</p>
															<ul class="review_score_breakdown_list">
																<li class="clearfix">
																	<p class="review_score_name">整潔度</p>
																	<p class="review_score_value">7.9</p>
																	<div class="score_bar">
																		<div class="score_bar_value" style="width: 79%"></div>
																	</div>
																</li>
															</ul>
														</div>
														放圖區
														<a
															href="http://localhost:8080/Travel/images/hotelroom_images_small/slider/28919105.jpg"
															data-lightbox="roadtrip"><img
															src="http://localhost:8080/Travel/images/hotelroom_images_small/33469424.jpg"></a>
														<a
															href="http://localhost:8080/Travel/images/hotelroom_images_small/slider/33605626.jpg"
															data-lightbox="roadtrip"><img
															src="http://localhost:8080/Travel/images/hotelroom_images_small/33469426.jpg"></a>
														<a
															href="http://localhost:8080/Travel/images/hotelroom_images_small/slider/33605637.jpg"
															data-lightbox="roadtrip"><img
															src="http://localhost:8080/Travel/images/hotelroom_images_small/33472838.jpg"></a>
														<a
															href="http://localhost:8080/Travel/images/hotelroom_images_small/slider/36104971.jpg"
															data-lightbox="roadtrip"><img
															src="http://localhost:8080/Travel/images/hotelroom_images_small/34928685.jpg"></a>
														<a
															href="http://localhost:8080/Travel/images/hotelroom_images_small/slider/64532825.jpg"
															data-lightbox="roadtrip"><img
															src="http://localhost:8080/Travel/images/hotelroom_images_small/34930657.jpg"></a>

													</div>
												</div>
												<div class="lightbox_right_container">
													<div class="info">
														<strong>客房面積：</strong> "23平方米"
													</div>
													<div class="info_rt_bed_sizes">
														<strong>床型尺寸：</strong> <span rel="180" title="寬 90-130 公分">
															2 張單人床</span>
													</div>
													<p>
														客房提供額外的空間。 <br> <br> 此類型的客房無法提供嬰兒床和加床。
													</p>
													<p class="lightbox_facilities">
														<strong> 客房設施: </strong> 保險箱, 空調, 書桌, 地毯, 衣櫃/衣櫥, 淋浴, 浴缸,
														吹風機, 免費盥洗用品, 洗手間, 浴室, 拖鞋, 衛生紙, 電視, 電話, 衛星頻道, 有線頻道, 冰箱,
														電熱水壺, 喚醒服務／鬧鐘
													</p>
													<div class="lightbox-free-wifi">
														<p>所有客房提供免費 WiFi。</p>
													</div>
												</div>
												<div
													class="lightbox-info-reviews-container lightbox-info-reviews-container--image-gallery">
													<div class="lightbox-info-container"></div>
												</div>
												<div class="clearfix"></div>
												<hr class="clearBoth">
											</div>
										</td>
									</tr> -->
								</c:forEach>
								
							</tbody>
						</table>
						</form>
					</div>

				<!--最後，字體顏色為白字且粗體，並將背景顏色去除-->
				<div class="facilities_hotel" style="width:820px;height:500px;background-color:#FEE4BD;">
					<h3 class="fontstylebar_time" style="width:390px;float:left;">入住時間:${hotelbean.check_in}</h3>
                    <h3 class="fontstylebar_time" style="width:370px;float:left;">退房時間:${hotelbean.check_out}</h3>
                    	<br>
                    	<div style="margin-left:50px;">
                    		<c:if test="${not empty hotelbean.price_bed}"><li>允許加床，酌收${hotelbean.price_bed}</li></c:if>
                    		<c:if test="${empty hotelbean.price_bed}"><li>不允許加床</li></c:if>
                    		<c:if test="${not empty hotelbean.years}"><li>允許${hotelbean.years}以下孩童免費使用現有床鋪</li></c:if>
							<c:if test="${not empty service.complexService}"></c:if>
						</div>
						<hr>
					<h3 class="fontstylebar" style="color:#ff0000">設施與服務</h3>
					<div class="facilitiesChecklistSection">
						<h3 class="fontstylebar">綜合服務</h3>
						<ul>
						<c:forEach var="bean" items="${service.complexService}">
							<li>
							<span class="ui-icon ui-icon-check"> </span>
								${bean.servicename}
							</li>
						</c:forEach>
						</ul>
					</div>
					
                    
					<c:if test="${not empty service.complexFacilities}">
                    <div class="facilitiesChecklistSection">
                        <h3 class="fontstylebar">綜合設施</h3>
                        <ul>
                        <c:forEach var="bean" items="${service.complexFacilities}">
                            <li><span class="ui-icon ui-icon-check"> </span>
                                ${bean.servicename}
                            </li>
                        </c:forEach>
                        </ul>
                    </div>
                    </c:if>
                    <c:if test="${not empty service.clearService}">
                    <div class="facilitiesChecklistSection">
                        <h3 class="fontstylebar">清潔服務</h3>
                        <ul>
                        <c:forEach var="bean" items="${service.clearService}">
                            <li><span class="ui-icon ui-icon-check"> </span>
                                ${bean.servicename}
                            </li>
                        </c:forEach>
                        </ul>
                    </div>
                    </c:if>
                    <c:if test="${not empty service.BusinessFacilities}">
                    <div class="facilitiesChecklistSection">
                        <h3 class="fontstylebar">商業服務</h3>
                        <ul>
                        <c:forEach var="bean" items="${service.BusinessFacilities}">
                            <li><span class="ui-icon ui-icon-check"> </span>
                                ${bean.servicename}
                            </li>
                        </c:forEach>
                        </ul>
                    </div>
                    </c:if>
                    <c:if test="${not empty service.BusinessFacilities}">
                    <div class="facilitiesChecklistSection">
                        <h3 class="fontstylebar">綜合服務</h3>
                        <ul>
                        <c:forEach var="bean" items="${service.BusinessFacilities}">
                            <li><span class="ui-icon ui-icon-check"> </span>
                                ${bean.servicename}
                            </li>
                        </c:forEach>
                        </ul>
                    </div>
                    </c:if>
                    <div class="facilitiesChecklistSection">
                        <h3 class="fontstylebar">寵物</h3>
                        <ul>
                        <c:if test="${not empty service.pet}"><li>
                        <c:forEach var="bean" items="${service.pet}">
                            <li><span class="ui-icon ui-icon-check"> </span>
                                ${bean.servicename}
                            </li>
                        </c:forEach>
                        </c:if>
                        <c:if test="${empty service.pet}"><li><span class="ui-icon ui-icon-check"> </span>不允許攜帶寵物</li></c:if>
                        </ul>
                    </div>
                    <div class="facilitiesChecklistSection">
                        <h3 class="fontstylebar">停車場</h3>
                        <ul>
                        <c:if test="${not empty service.carpark}">
                        <c:forEach var="bean" items="${service.carpark}">
                            <li><span class="ui-icon ui-icon-check"> </span>
                                ${bean.servicename}
                            </li>
                        </c:forEach>
						</c:if>
                        <c:if test="${empty service.carpark}"><li><span class="ui-icon ui-icon-check"> </span>無停車設施</li></c:if>
 
                        </ul>
                    </div>
                    <div class="facilitiesChecklistSection">
                        <h3 class="fontstylebar">語言</h3>
                        <ul>
                        <li><span class="ui-icon ui-icon-check"> </span>${fn:replace(hotelbean.language," " ,"<br />")}</li>
                        </ul>
                    </div>
                    
                    <span class="fontstylebar" style="position:relative;top:200px;">注意事項:${hotelbean.note}</span>
                </div>

			</div>
		</div>
		
		<script type="text/javascript" src="<c:url value="/assets/jquery-ui-1.12.1.custom/external/jquery/jquery.js" />"></script>
		<script type="text/javascript" src="<c:url value="/assets/bootstrap/js/bootstrap.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/assets/jquery-ui-1.12.1.custom/jquery-ui.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/assets/changephotos/js/rhinoslider-1.05.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/assets/changephotos/js/easing.js" />"></script>
		<script type="text/javascript" src="<c:url value="/assets/changephotos/js/mousewheel.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/lightbox.js" />"></script>
		<script type="text/javascript" src="<c:url value="/js/head.js" />"></script>
		
		<script>
			$("#Mainframe").tabs({
       	    	heightStyle : "content"
        	});

        	$(".score_bar_value").progressbar({
            	value : 55
        	});
			var day = new Date();
        	var string = day.getFullYear()+"/"+(day.getMonth()+1)+"/"+day.getDate();
        	document.getElementById("orderday").value=string;
			/*$('select').change(function() { $('input[name="roomNumber"]').val() = $(this).val(); });*/
			/*點選連結，彈出視窗*/
			$(".togglelink").click(function() {
				$(".room_loop_counter1_extendedRow").dialog({
					width : 700,
					height : 500,
					show : {
						effect : "blind",
						duration : 800					},
					draggable : false,
					position : {
						my : "left top",
						at : "bottom",
						of : ".togglelink"
					},
					modal : true,
					create : function() {
						$(".ui-dialog").find(".ui-dialog-titlebar").css({
							'background-image' : 'none',
							'background-color' : 'white',
							'border' : 'none'
						});
					}
				});
			});

			$("#datefrom,#dateto").datepicker({
				dateFormat : "yy-mm-dd",
				minDate : '@minDate'
			});
			$("#datefrom").datepicker("setDate", "new Date()");
			$("#dateform").datepicker("getDate");
			$("#dateto").datepicker("setDate", "+1");

			/*user點選入住日期，退房日期自動加1*/
			$("#datefrom").change(function() {
				var day = $("#datefrom").datepicker("getDate");
				day = new Date(day.valueOf());
				day.setDate(day.getDate() + 1);
				$("#dateto").datepicker("setDate", day).datepicker("option","minDate",day);
			});

			$("#submit_btn").button();

			$("#slideshow").rhinoslider({
				effect : 'transfer',
				controlsKeyboard : false,
				controlsPlayPause : false,
				autoPlay : true,
				showBullets : 'never',
				slidePrevDirection : 'toRight',
				slideNextDirection : 'toLeft',
				showTime: 5000
			});
			 	var a = [];
	            var b = [];
				var c = [];			
	            var l = $(".room_loop_counter1").length;
	            for(var i=0;i<l;i++){    
	            a[i] = $("select[name='selector']:eq("+i+")").data("price");
	            }
	            for(var j=0;j<l;j++){
	            b[j] = $("select[name='selector']:eq("+j+")").data("roomnumber");
	            }
	            for(var k=0;k<l;k++){
	    			c[k] = $("select[name='selector']:eq("+k+")").data("peoplenumber");
	    			}
	            for(var j = 0; j < l; j++){
	            	for(var i = 0; i < c[j]; i++){
	            		 var myData = {
	 	                        string : "<i class='glyphicon glyphicon-user'></i>"
	 	                    };
	            		 $("span[name='person_adults']:eq(" + j + ")").append(myData.string);
	            	}
	            }
	            
	            for (var j = 0; j < l; j++) {
	                for (var i = 1; i <= b[j]; i++) {
	                    var myData = {
	                        string : "<option value=" + i + ">" + i + " (TWD "
	                                + a[j] * i + ")</option>"
	                    };
	                    $("select[name='selector']:eq(" + j + ")").append(
	                            myData.string);
	                }
	 
	            }
		</script>
	</body>

</html>
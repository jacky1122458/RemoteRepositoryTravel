<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<form id="search_box" class="search_box_tem" action="<c:url value="/serachotel2.controller" />" method="post"> <!-- new form -->
			<div id="search"><!-- searchdiv -->
				<div>
					<h3 class="search_box_title"><span>搜尋</span></h3>
				</div>
<!-- 				<form id="search_box" class="search_box_tem">原本searchfrom -->
					<div id="search_box_dest">
						<label for="dest">旅遊地點/旅館名稱</label>
						<input type="text" name="address" value="${param.address}" style="width:200px;height:30px;" />
					</div>
					<div class="search_box_tem">
						<div>
							入住日期：
						</div>
						<div id="search_box_datefrom">
							 <i style="position:absolute;padding: 6px 15px;" class="glyphicon glyphicon-calendar"></i>
							<input id="datefrom" type="text" readonly="readonly" style="width:200px;height:30px;padding-left:50px;" name="checkin" value="${param.checkin}"/>
						</div>
						<div>
							退房日期：
						</div>
						<div id="search_box_dateto">
							<i style="position:absolute;padding: 6px 15px;" class="glyphicon glyphicon-calendar"></i>
							<input id="dateto" type="text" readonly="readonly" style="width:200px;height:30px;padding-left:50px;" name="checkout" value="${param.checkout}"/>
						</div>
						<div id="stay_length">
							<input id="count_stay_length" value="入住X晚">
						</div>
					</div>
					<div id="person_count_kinds" class="search_box_tem">
						<div class="select_bar_tem">
							<label>客房：</label>
							<input type="text" name="roomNum" value="${param.roomNum}" style="display:none;">
							<select id="rooms" name="roomNum" style="width:100px;text-align: left;padding-left: 35px;margin-top:10px;">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
						</div>
						<div id="adults_col" class="select_bar_tem">
							<label>人數：</label>
							<input type="text" name="adultNum" value="${param.adultNum}" style="display:none;"> 
							<select id="adults" name="adultNum" style="width:100px;text-align: left;padding-left: 35px;margin-top:10px;">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select>
						</div>
					</div>
					<input id="submit_btn" class="ui-button ui-corner-all ui-widget" type="submit" value="Search" style="height:40px;color:#000000">
					
<!-- 				</form>原本search from 結束 -->
			</div><!-- searchdivend -->
			<!--以上是 搜尋列表 -->
			<c:if test="${not empty service}">
				<div id="show_google_amps">
						<a href="" id="google.map.temp"><span id="btn_mapshow" data-title="顯示地圖">
						<iframe width="100%" height="300" frameborder="0" src="https://www.google.com/maps?geocode=&q=${hotelbean.lat},${hotelbean.lng}&z=16&output=embed"></iframe>
						</span></a>
						<p></p>
				</div>
			</c:if>
			<div id="search_box_constrain"><!--篩選 -->
				<div>
					<h3 class="search_box_title">篩選條件</h3>
				</div>
<!-- 				<form id="search_box_constrain_form"> --><!-- 原本篩選from -->
					<div id="filter_condition_1" class="filter_tem">
						<i class="ui-icon ui-icon-triangle-1-s"></i><span class="search_box_constrain_conditions">您的預算：</span>
						<br>
						<input id="search_box_constrain_pricetype_conditions_1" type="checkbox" name="price" value="1"/>
						<label for="search_box_constrain_pricetype_conditions_1">TWD 0 - TWD 2500(每晚)</label>
						<br>
						<input id="search_box_constrain_pricetype_conditions_2" type="checkbox" name="price" value="2"/>
						<label for="search_box_constrain_pricetype_conditions_2">TWD 2500 - TWD 4500(每晚)</label>
						<br>
						<input id="search_box_constrain_pricetype_conditions_3" type="checkbox" name="price" value="3"/>
						<label for="search_box_constrain_pricetype_conditions_3">TWD 4500 - TWD 6500(每晚)</label>
						<br>
						<input id="search_box_constrain_pricetype_conditions_4" type="checkbox" name="price" value="4"/>
						<label for="search_box_constrain_pricetype_conditions_4">TWD 6500 +(每晚)</label>
						<br>
					</div>
					<hr>
					<div id="filter_condition_2" class="filter_tem">
						<i class="ui-icon ui-icon-triangle-1-s"></i><span class="search_box_constrain_conditions">旅館類型：</span>
						<br>
						<input id="search_box_constrain_hoteltype_conditions_1" type="checkbox" name="hoteltype" value="1"/>
						<label for="search_box_constrain_hoteltype_conditions_1">飯店</label>
						<br>
						<input id="search_box_constrain_hoteltype_conditions_2" type="checkbox" name="hoteltype" value="2"/>
						<label for="search_box_constrain_hoteltype_conditions_2">旅館</label>
						<br>
						<input id="search_box_constrain_hoteltype_conditions_3" type="checkbox" name="hoteltype" value="3"/>
						<label for="search_box_constrain_hoteltype_conditions_3">汽車旅館</label>
						<br>
						<input id="search_box_constrain_hoteltype_conditions_4" type="checkbox" name="hoteltype" value="4"/>
						<label for="search_box_constrain_hoteltype_conditions_4">青年旅館</label>
						<br>
						<input id="search_box_constrain_hoteltype_conditions_5" type="checkbox" name="hoteltype" value="5"/>
						<label for="search_box_constrain_hoteltype_conditions_5">民宿</label>
						<br>
						<input id="search_box_constrain_hoteltype_conditions_6" type="checkbox" name="hoteltype" value="6"/>
						<label for="search_box_constrain_hoteltype_conditions_6">公寓式</label>
						<br>
						<input id="search_box_constrain_hoteltype_conditions_7" type="checkbox" name="hoteltype" value="7"/>
						<label for="search_box_constrain_hoteltype_conditions_7">膠囊旅館</label>
						<br>

					</div>
					<hr>
					<div id="filter_condition_3" class="filter_tem">
						<i class="ui-icon ui-icon-triangle-1-s"></i><span class="search_box_constrain_conditions">旅館服務：</span>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_1" type="checkbox" name="service" value="1"/>
						<label for="search_box_constrain_facilitytype_conditions_1">含早餐</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_2" type="checkbox" name="service" value="2"/>
						<label for="search_box_constrain_facilitytype_conditions_2">客房服務</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_3" type="checkbox" name="service" value="3"/>
						<label for="search_box_constrain_facilitytype_conditions_3">櫃臺24小時接待</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_4" type="checkbox" name="service" value="4"/>
						<label for="search_box_constrain_facilitytype_conditions_4">可攜帶寵物</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_5" type="checkbox" name="service" value="5"/>
						<label for="search_box_constrain_facilitytype_conditions_5">不須預付訂金</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_6" type="checkbox" name="service" value="6"/>
						<label for="search_box_constrain_facilitytype_conditions_6">訂房免費取消</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_7" type="checkbox" name="service" value="7"/>
						<label for="search_box_constrain_facilitytype_conditions_7">機場接駁車</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_8" type="checkbox" name="service" value="8"/>
						<label for="search_box_constrain_facilitytype_conditions_8">洗衣</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_9" type="checkbox" name="service" value="9"/>
						<label for="search_box_constrain_facilitytype_conditions_9">行李寄存</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_10" type="checkbox" name="service" value="10"/>
						<label for="search_box_constrain_facilitytype_conditions_10">停車場</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_11" type="checkbox" name="service" value="11"/>
						<label for="search_box_constrain_facilitytype_conditions_11">無障礙設施</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_12" type="checkbox" name="service" value="12"/>
						<label for="search_box_constrain_facilitytype_conditions_12">禁菸客房</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_13" type="checkbox" name="service" value="13"/>
						<label for="search_box_constrain_facilitytype_conditions_13">家庭房</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_14" type="checkbox" name="service" value="14"/>
						<label for="search_box_constrain_facilitytype_conditions_14">免費無線網路</label>
						<br>
						<input id="search_box_constrain_facilitytype_conditions_15" type="checkbox" name="service" value="15"/>
						<label for="search_box_constrain_facilitytype_conditions_15">電梯</label>
						<br>
					</div>
					<hr>
<!-- 				</form> --><!-- 原本篩選form結束 -->
			</div><!--篩選div結束 -->
			</form><!-- new form -->
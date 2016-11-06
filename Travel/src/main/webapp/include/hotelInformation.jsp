<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
					<!--旅館評價-->
					<div id="hotel_comment" class="hotel_comment">
						<div class="review_list_score_container">
							<div class="review_list_score_left">
								<h4 class="review_list_score_count">整體評分</h4>
								<p class="review_list_score_count">
<%-- 									分數來自<strong>${avg.total_comment}則評分</strong> --%>
									分數來自<strong>${hotelbean.total_comment}則評分</strong>
								</p>
								<div id="review_list_main_score" class="review_list_score">
<%-- 									${fn:substring(avg.total, 0, 3)} --%>
										${hotelbean.tol_avg}
								</div>								
							</div>
							<!-- 
							<div class="review_list_score_col">
								<ul class="ul_style_oncomment">
									<li class="clearfix one_col">
										<p class="review_score_name">好棒棒:9+</p>
										<div class="score_bar"><div name="score_bar" class="score_bar_value" data-score="21" style="width:180px;height: 21px;">
										</div></div>
										<p class="review_score_value" style="margin:0;">524</p>
									</li>
									<li class="clearfix one_col">
										<p class="review_score_name">好棒棒:9+</p>
										<div class="score_bar"><div name="score_bar" class="score_bar_value" data-score="21" style="width:180px;height: 21px;">
										</div></div>
										<p class="review_score_value" style="margin:0;">524</p>
									</li>
									<li class="clearfix one_col">
										<p class="review_score_name">好棒棒:9+</p>
										<div class="score_bar"><div name="score_bar" class="score_bar_value" data-score="21" style="width:180px;height: 21px;">
										</div></div>
										<p class="review_score_value" style="margin:0;">524</p>
									</li>
									
								</ul>
							</div>
							 -->
							<div class="review_list_score_breakdown_col">
								<ul class="ul_style_oncomment">
									<li class="clearfix one_col">
										<p class="review_score_name">整潔度：</p>
										<div class="score_bar"><div name="score_bar" class="score_bar_value" data-score="${avg.cleanliness*20}" style="width:180px;height: 21px;">
										</div></div>
										<p class="review_score_value" style="margin:0;">${fn:substring(avg.cleanliness, 0, 3)}</p>
									</li>
									<li class="clearfix one_col">
										<p class="review_score_name">舒適度：</p>
										<div class="score_bar"><div name="score_bar" class="score_bar_value" data-score="${avg.comfort*20}" style="width:180px;height: 21px;">
										</div></div>
										<p class="review_score_value" style="margin:0;">${fn:substring(avg.comfort, 0, 3)}</p>
									</li>
									<li class="clearfix one_col">
										<p class="review_score_name">地點：</p>
										<div class="score_bar"><div name="score_bar" class="score_bar_value" data-score="${avg.location*20}" style="width:180px;height: 21px;">
										</div></div>
										<p class="review_score_value" style="margin:0;">${fn:substring(avg.location, 0, 3)}</p>
									</li>
									<li class="clearfix one_col">
										<p class="review_score_name">設施：</p>
										<div class="score_bar"><div name="score_bar" class="score_bar_value" data-score="${avg.facilities*20}" style="width:180px;height: 21px;">
										</div></div>
										<p class="review_score_value" style="margin:0;">${fn:substring(avg.facilities, 0, 3)}</p>
									</li>
									<li class="clearfix one_col">
										<p class="review_score_name">服務：</p>
										<div class="score_bar"><div name="score_bar" class="score_bar_value" data-score="${avg.staff*20}" style="width:180px;height: 21px;">
										</div></div>
										<p class="review_score_value" style="margin:0;">${fn:substring(avg.staff, 0, 3)}</p>
									</li>
									<li class="clearfix one_col">
										<p class="review_score_name">價值比：</p>
										<div class="score_bar"><div name="score_bar" class="score_bar_value" data-score="${avg.cp*20}" style="width:180px;height: 21px;">
										</div></div>
										<p class="review_score_value" style="margin:0;">${fn:substring(avg.cp, 0, 3)}</p>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!--旅館簡介-->	
					<div id="hotel_introducion_hightlight_wrapper" style="background-color:#FFEEC0;">
							<div class="hotel_introduction" style="width:510px;position:relative;line-height:1.4;padding-bottom:1em;">
								<p>
									<span class="hotel_introduction-name-ranked" style="color:#FF0000;font-weight:bold;"> <i class="ui-icon ui-icon-star"> ::before </i> "我們的都市首選" </span>
								</p>
								<p>
									${fn:replace(hotelbean.description," " ,"<br />")}
								</p>

								<div class="room_important_facility">
									<h3 style="font-size: 14px;margin:15px 0;">熱門設施</h3>
								</div>
							</div>
							<div class="hotel_total_score">
								<span class="grade_font_style">${hotelbean.tol_avg}</span>
							</div>
						</div>
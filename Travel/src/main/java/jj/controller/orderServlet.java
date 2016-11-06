package jj.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jj.model.Tour_orderBean;
import jj.model.service.TourManagementService;
import model.MemberBean;

@WebServlet(
		urlPatterns={"/order.controller"}		
)

public class orderServlet  extends HttpServlet {
	TourManagementService tourservice;
	TourManagementService tour_evaluateservice;
	TourManagementService travel_attractionsseservice;
	TourManagementService tour_orderservice;
	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	 tourservice = (TourManagementService) context.getBean("tourManagementService");
	 tour_evaluateservice =	 (TourManagementService) context.getBean("tourManagementService2");
	 travel_attractionsseservice = (TourManagementService) context.getBean("tourManagementService3");
	 tour_orderservice=(TourManagementService) context.getBean("tourManagementService1");
	
	}
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");

	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = (HttpSession) request.getSession();
		
		//開始此表單抓值-------
		List<List> settour = (List<List>) session.getAttribute("settour");
		System.out.println(settour+"settour");
		MemberBean memberBean = (MemberBean)session.getAttribute("memberBean");
		System.out.println("memberid,,,"+memberBean.getMemberid());
		String prodaction = request.getParameter("prodaction");
		String temp1 = request.getParameter("num");
		String temp2 = request.getParameter("name");
		String temp3 = request.getParameter("price");
		String temp4 = request.getParameter("phone");
		String temp5 = request.getParameter("orderdate");
		String temp6 = request.getParameter("outdate");
		//結尾----------------
		System.out.println(temp1);
		System.out.println(temp2);
		System.out.println(temp3);
		System.out.println(temp4);
		System.out.println(temp5);
		System.out.println(temp6);
		System.out.println(prodaction);
		//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		System.out.println(errors+"errors");
		request.setAttribute("error", errors);

		
		//----------------------------------傳值過來轉換
		int getnumber = (int) settour.get(0).get(3);
		int num = 0;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
				int z = Integer.parseInt(temp1);
				if(getnumber>=z && getnumber>=0){
					num=z;
				}else{
					errors.put("num","人數錯誤");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("num","必須輸入人數");
			}
		}
		
		String name =null;
		if(temp2!=null && temp1.trim().length()!=0) {
			name=temp2;
		}else{
			errors.put("name","必須輸入");
		}
		
		String phone =null;
		if(temp4!=null && temp4.trim().length()!=0) {
			phone=temp4;
		}else{
			errors.put("phone","必須輸入");
		}
				
		
		int price = 0;
		if(temp3!=null && temp3.trim().length()!=0) {
			try {
				price = Integer.parseInt(temp3);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("price","須輸價錢");
			}
		}
		
		
		
		java.util.Date thisorderdate = null;
		if(temp5!=null && temp5.trim().length()!=0) {
			try {
				thisorderdate = sFormat.parse(temp5);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		System.out.println(thisorderdate+"thisorderdate");

		java.util.Date thisoutdate = null;
		if(temp6!=null && temp6.trim().length()!=0) {
			try {
				thisoutdate = sFormat.parse(temp6);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(thisoutdate+"thisoutdate");

		
		//-----------------------傳值過來結尾
		//驗證資料	
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/ShowSearch/search_travel_step3.jsp").forward(request,response);
			return;
		}
		
		
		
	

		
//呼叫model			
//根據model執行結果，導向view
		int tourid = (int) settour.get(0).get(0);
		System.out.println(tourid+"list1");
		int getprice = (int) settour.get(0).get(2);
		System.out.println(getprice+"list.前台來得錢");
		int getnumber1 = (int) settour.get(0).get(3);
		System.out.println(getnumber+"list3前台來得團數上限");
		
		
		
		
		Tour_orderBean tourorder = new Tour_orderBean();
		tourorder.setMember_id(memberBean.getMemberid());
		tourorder.setTour_id(tourid);
		tourorder.setOrdername(name);
		tourorder.setNumber_people(num);
		tourorder.setPrice(price);
		tourorder.setPhone(phone);
		tourorder.setDeparture_date(thisoutdate);
		tourorder.setOrder_date(thisorderdate);
		tourorder.setOrder_status(true);
		
		if("送出".equals(prodaction)) {
			
			int sum = (getnumber1-num);
			Tour_orderBean ss = tour_orderservice.insert(tourorder);
			tourservice.update_number(sum, tourid);
			
			
			if(ss!=null){
			request.getRequestDispatcher(
					"/Index.jsp").forward(request, response); 
			}else{
				request.getRequestDispatcher(
					"/ShowSearch/search_travel_step3.jsp").forward(request, response); 
			}
				
	}
		
		//do括號
	}
		//do括號
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request,response);
	}
}

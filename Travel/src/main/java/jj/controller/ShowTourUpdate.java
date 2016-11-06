package jj.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.tuple.entity.DynamicMapEntityTuplizer.BasicEntityNameResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jj.model.TourBean;
import jj.model.Travel_attractionsBean;
import jj.model.service.TourManagementService;

@WebServlet(
		urlPatterns={"/showtourupdate.controller"}		
)
public class ShowTourUpdate extends HttpServlet {
	TourManagementService tourservice;
	TourManagementService tour_evaluateservice;
	TourManagementService travel_attractionsseservice;
	TourManagementService tour_orderservice;
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	 tourservice = (TourManagementService) context.getBean("tourManagementService");
	 tour_evaluateservice =	 (TourManagementService) context.getBean("tourManagementService2");
	 travel_attractionsseservice = (TourManagementService) context.getBean("tourManagementService3");
	 tour_orderservice=(TourManagementService) context.getBean("tourManagementService1");

	
	}
	
	
	


	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();

		//接收資料
		
			//接收資取得管理訂單按鈕
			String  temp=request.getParameter("tourid");
			String  temp1=request.getParameter("tourname");
			String  temp2=request.getParameter("member");
			int tourid = Integer.parseInt(temp);
			String  temp3=request.getParameter("price");
			String  temp4=request.getParameter("make");
			String  temp5=request.getParameter("expire");
			String  temp6=request.getParameter("max");
			
			String  temp7=request.getParameter("fool");
			String  temp8=request.getParameter("remark");
			String  temp9=request.getParameter("meet");
			
			String  temp10=request.getParameter("lat");
			String  temp11=request.getParameter("lng");
			
			String  temp12=request.getParameter("ex");
			String  temp13=request.getParameter("outdate");
			
			String  temp14=request.getParameter("status");
			
			
			boolean statustest;
			if("true".equals(temp14)){
				statustest=true;
			}else{
				statustest=false;
			}
			
			
			
			String  member1=request.getParameter("member1");
			String  member2=request.getParameter("member2");
			String  member3=request.getParameter("member3");
			String  attion1=request.getParameter("attion1");
			String  attion2=request.getParameter("attion2");
			String  attion3=request.getParameter("attion3");
			
			String  change=request.getParameter("change");
		
			System.out.println(attion1);
			System.out.println(attion2);
			System.out.println(attion3);
//呼叫model
//根據model執行結果，導向view
	
		
			//轉換資料
			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("error", errors);
			
			String tourname = null;
			if(temp1!=null && temp1.trim().length()!=0) {
					tourname=temp1;
				}else{
					errors.put("tourname", "不得為空");
			}
			
			
			int member = 0;
			if(temp2!=null && temp2.trim().length()!=0) {
				try {
					member = Integer.parseInt(temp2);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("member", "必須是數字");
				}
			}
			
			int price = 0;
			if(temp3!=null && temp3.trim().length()!=0) {
				try {
					price = Integer.parseInt(temp3);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("price", "必須是數字");
				}
			}

			
			
			String make = null;
			if(temp4!=null && temp4.trim().length()!=0) {
				make=temp4;
			}else{
				errors.put("make", "不得為空");
			}
			
			
			
			String expire = null;
			if(temp5!=null && temp5.trim().length()!=0) {
				expire=temp5;
			}else{
				errors.put("expire", "不得為空");
			}
			
			
			int max = 0;
			if(temp6!=null && temp6.trim().length()!=0) {
				try {
					max = Integer.parseInt(temp6);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("max", "必須是數字");
				}
			}
			
			
			
			
			
			
			
			String fool = null;
			if(temp7!=null && temp7.trim().length()!=0) {
				fool=temp7;
			}else{
				errors.put("fool", "不得為空");
			}
		
			String remark = null;
			if(temp8!=null && temp8.trim().length()!=0) {
				remark=temp8;
			}else{
				errors.put("remark", "不得為空");
			}
		
			String meet = null;
			if(temp9!=null && temp9.trim().length()!=0) {
				meet=temp9;
			}else{
				errors.put("meet", "不得為空");
			}
		
			double lan =0;
			if(temp10!=null && temp10.trim().length()!=0) {
				try {
					lan = Double.parseDouble(temp10);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("lan", "必須是數字");
				}
			}
			
			double lng =0;
			if(temp11!=null && temp11.trim().length()!=0) {
				try {
					lng = Double.parseDouble(temp11);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("lng", "必須是數字");
				}
			}
			
			String ex = null;
			if(temp12!=null && temp12.trim().length()!=0) {
				ex=temp12;
			}else{
				errors.put("ex", "不得為空");
			}
			
			java.util.Date outdate = null;
			if(temp13!=null && temp13.trim().length()!=0) {
				try {
					outdate = sFormat.parse(temp13);
				} catch (ParseException e) {
					e.printStackTrace();
					errors.put("make", "Make必須是日期:yyyy-MM-dd");
				}
			}
			
			
//			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	//驗證資料	
//			if("Insert".equals(prodaction) || "Update".equals(prodaction) || "Delete".equals(prodaction)) {
//				if(id==0) {
//					errors.put("id", "請輸入Id以便於執行"+prodaction);
//				}
//			}
		
			if(errors!=null && !errors.isEmpty()) {
				request.getRequestDispatcher(
						"/ManagemementTour/ShowTourUpdate.jsp").forward(request, response);
				return;
			}


		
			
//驗證資料
//呼叫model
//根據model執行結果，導向view
	
		
		
		System.out.println(statustest+"-------statustest---------");


		

			TourBean bean = new TourBean();
			bean.setTour_id(tourid);
			bean.setTour_name(tourname);
			bean.setTour_restrict(member);
			bean.setTour_price(price);
			bean.setMeeting_time(make);
			bean.setCost_gloze(expire);
			bean.setAge_limit(max);
			bean.setMeals(fool);
			bean.setRemark(remark);
			bean.setMeeting_place(meet);
			bean.setLat(lan);
			bean.setLng(lng);
			bean.setTour_status(statustest);
			bean.setExplanation(ex);
			bean.setDeparture_date(outdate);

		
		
		
		if("change".equals(change)){
			int memberid = Integer.parseInt(member1);
			int memberid1 = Integer.parseInt(member2);
			int memberid2 = Integer.parseInt(member3);
			int attionid = Integer.parseInt(attion1);
			int attionid1 = Integer.parseInt(attion2);
			int attionid2 = Integer.parseInt(attion3);

				System.out.println(memberid+"memberid");
				System.out.println(memberid1);
				System.out.println(memberid2);
				System.out.println("-----------------------------");
				System.out.println(attionid);
				System.out.println(attionid1);
				System.out.println(attionid2);
				
				boolean result = tourservice.update_tour(bean);
			
				
				travel_attractionsseservice.update(tourid,attionid , memberid);
				
	
				travel_attractionsseservice.update(tourid, attionid1, memberid1);
	
				travel_attractionsseservice.update(tourid, attionid2, memberid2);

				
					
					request.getRequestDispatcher(
							"/Index.jsp").forward(request, response);
		 
			}
			
		
		
		 
		
	
			
			
		 
		//do括號
	}
		//do括號
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

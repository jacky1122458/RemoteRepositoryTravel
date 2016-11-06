package jj.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import jj.model.TourBean;
import jj.model.Tour_evaluateBean;
import jj.model.Travel_attractionsBean;
import jj.model.dao.Tour_evaluateDAOHibernate;
import jj.model.service.TourManagementService;
import model.MemberBean;


@WebServlet(
		urlPatterns={"/Evaluatemytour.controller"}		
)
public class EvaluateMyTour extends HttpServlet {
	TourManagementService tourservice;
	TourManagementService tour_evaluateservice;
	TourManagementService travel_attractionsseservice;
	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	 tourservice = (TourManagementService) context.getBean("tourManagementService");
	 tour_evaluateservice =	 (TourManagementService) context.getBean("tourManagementService2");
	 travel_attractionsseservice = (TourManagementService) context.getBean("tourManagementService3");
	
	
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		//取得前一頁傳過來的資料
		List<List> evaluate = (List) session.getAttribute("orderidnumber2");
		int setorderid = (int) evaluate.get(0).get(0);
		int settourid = (int) evaluate.get(0).get(1);
		
		 MemberBean memberBean = (MemberBean)session.getAttribute("memberBean");
		 System.out.println("memberBeanid"+memberBean.getMemberid());
		//取得前一頁傳過來的資料
		System.out.println(evaluate);
		
		String name = request.getParameter("say");
		String temp1 = request.getParameter("num");
		String prodaction =request.getParameter("prodaction");
		
		System.out.println(name+"say");
		System.out.println(temp1+"num");
		System.out.println(prodaction+"prodaction");
		System.out.println(evaluate+"evaluate");
		System.out.println(setorderid+"setorderid,,,,,,,,,,");
		System.out.println(settourid+"settourid,,,,,,,,,,");
		

		 
	
		
		
		
		//轉換資料
				Map<String, String> errors = new HashMap<String, String>();
				request.setAttribute("error", errors);
			
		
		int id = 0;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
					int s = Integer.parseInt(temp1);
					if(s<=5){
							id=s;
					}else{
						errors.put("id", "總分5");
					}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("id", "Id必須是整數");
			}
		}
		
		
		String sayname = null;
		if(name!=null && name.trim().length()!=0) {
			 sayname = name;	
		}else{
			errors.put("namesay", "不得為空");
		}
		
		
		
		
		//驗證資料		
				if(errors!=null && !errors.isEmpty()) {
					request.getRequestDispatcher(
							"/tourevaluate.jsp").forward(request, response);
					return;
				}
		
		
				//呼叫Model, 根據Model執行結果顯示View
				
				
				
				Tour_evaluateBean bean = new Tour_evaluateBean();
				bean.setMember_id(memberBean.getMemberid());
				bean.setTour_id(settourid);
				bean.setOrder_id(setorderid);
				bean.setRating(id);
				bean.setEvaluate(sayname);
				bean.setEvaluate_status(true);
				
				
				if("check".equals(prodaction)) {
					
					
					Tour_evaluateBean ser = tour_evaluateservice.insert(bean);
					System.out.println(ser+"ser--------------------");
					
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

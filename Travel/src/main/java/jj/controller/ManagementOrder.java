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
import jj.model.Tour_orderBean;
import jj.model.Travel_attractionsBean;
import jj.model.dao.Tour_evaluateDAOHibernate;
import jj.model.service.TourManagementService;


@WebServlet(
		urlPatterns={"/managementorder.controller"}		
)
public class ManagementOrder extends HttpServlet {
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
	
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
	
		String managementorder = request.getParameter("managementorder");
		String check = request.getParameter("check");
		String back = request.getParameter("back");
		String temp1 = request.getParameter("inputtext");
		String button = request.getParameter("button");

		//驗證資料
				Map<String, String> errors = new HashMap<String, String>();
				System.out.println(errors+"errors");
				request.setAttribute("error", errors);
				System.out.println(check);
				System.out.println(temp1);
		
					
		int tourid = 0;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
				tourid = Integer.parseInt(temp1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("id","輸入正常數字");
			}
		}else{
			tourid =0;
		}
		
		
		System.out.println(tourid+"tourid,,,,,,,,,");
		
		
		
		if("managementorder".equals(managementorder)){	
			
			
			
			List<Tour_orderBean> search = tour_orderservice.select_all_orderbymanag(0);
			System.out.println(search+"search.................");
			request.setAttribute("show", search);
			
			
			
			
			
			request.getRequestDispatcher(
					"/ShowAllOrder.jsp").forward(request, response);
		}	
	
		
		

		if("check".equals(check)){	
			
			List<Tour_orderBean> search = tour_orderservice.select_all_orderbymanag(tourid);
			List<List> result = tourservice.select_nubmer_byid_zeroINT(tourid);
			System.out.println("result,,,,,2"+result);
			System.out.println("search,,,,,2"+search);
			request.setAttribute("show", search);
			request.setAttribute("shownum",result);
			System.out.println(result);
			request.getRequestDispatcher(
					"/ShowAllOrder.jsp").forward(request, response);
		}	
		
		
		
		
if(button.equals(button)){	
			
			int orderid = Integer.parseInt(button);
			System.out.println(button+"buttonbutton");
			List<List> show = tour_orderservice.select_tour_sms(orderid);
			System.out.println(show+"show-----------message");
			request.setAttribute("sms", show);
			request.getRequestDispatcher(
					"/testsms.jsp").forward(request, response);
	
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

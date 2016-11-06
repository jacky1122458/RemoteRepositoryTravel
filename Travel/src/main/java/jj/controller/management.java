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
		urlPatterns={"/management.controller"}		
)
public class management extends HttpServlet {
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
		
		
		
		String management = request.getParameter("management");
		String change = request.getParameter("change");
		
		
		if("management".equals(management)){	
			List<List> result =tour_evaluateservice.select_manger();
			System.out.println(result);
			session.setAttribute("result", result);
			
			
			
			
			request.getRequestDispatcher(
					"/ShowManagement.jsp").forward(request, response);
	
		}	
		
		
		if("change".equals("change")){	
			List<List> result =tour_evaluateservice.select_manger();
			for(int i=0; i<result.size();i++){
				 Object results = result.get(i).get(0);
				 String sdsd = results.toString();
				 System.out.println(sdsd+"sdsdsdsd+++");
				if(sdsd.equalsIgnoreCase(change)){
					int order_id = Integer.parseInt(sdsd);
					boolean reslut_status = tour_evaluateservice.select_check_update(order_id);
					System.out.println(reslut_status+"reslut_statusreslut_status");
					System.out.println(order_id+"order_idorder_idorder_idorder_id");
					
					if(reslut_status){
						tour_evaluateservice.update_Status(false,order_id);
					}else{
						tour_evaluateservice.update_Status(true,order_id);
					}

					request.getRequestDispatcher(
							"/Index.jsp").forward(request, response);
				}
				
			}
			
			
			
			
			
	
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

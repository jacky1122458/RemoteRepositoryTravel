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


import jj.model.service.AttractionsMangementService;
import jj.model.service.TourManagementService;


@WebServlet(
		urlPatterns={"/showmyallattractions.controller"}		
)
public class ShowMyAllAttractions extends HttpServlet {
	TourManagementService tourservice;
	TourManagementService tour_evaluateservice;
	TourManagementService travel_attractionsseservice;
	TourManagementService tour_orderservice;
	AttractionsMangementService areaDAO;
	AttractionsMangementService attractionsDAO;
	AttractionsMangementService attractions_imgDAO;
	AttractionsMangementService attractions_evaluateDAO;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	 tourservice = (TourManagementService) context.getBean("tourManagementService");
	 tour_evaluateservice =	 (TourManagementService) context.getBean("tourManagementService2");
	 travel_attractionsseservice = (TourManagementService) context.getBean("tourManagementService3");
	 tour_orderservice=(TourManagementService) context.getBean("tourManagementService1");
	
	 
	 
	areaDAO=(AttractionsMangementService) context.getBean("attractionsMangementService");
	attractionsDAO=(AttractionsMangementService) context.getBean("attractionsMangementService2");
	attractions_imgDAO=(AttractionsMangementService) context.getBean("attractionsMangementService3");
	attractions_evaluateDAO=(AttractionsMangementService) context.getBean("attractionsMangementService1");
	
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		
				
		
			
			
			
			
			List<List> show = attractionsDAO.select_byAll();
			
			System.out.println(show);
			
			request.setAttribute("shoattion", show);
			
			
			request.getRequestDispatcher(
					"/search_sceneALL.jsp").forward(request, response);
			
		
		

		 
		//do括號
	}
		//do括號
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

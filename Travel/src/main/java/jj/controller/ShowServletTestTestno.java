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
import jj.model.service.TourManagementService;


@WebServlet(
		urlPatterns={"/showtour.controller"}		
)
public class ShowServletTestTestno extends HttpServlet {
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
//接收資料
		
		String look = request.getParameter("look");
		System.out.println(look);
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
//呼叫model
		
//根據model執行結果，導向view
	
		
		//---------------------------------show起頭
		List<TourBean> bean = tourservice.select_all_web();
		List s=new ArrayList();
		  for (int i = 0; i < bean.size(); i++) {
			  List d = (List<TourBean>) bean.get(i);
			  s.add(d);
//			  System.out.println(d);
			  }
//		  System.out.println(s);
		  request.setAttribute("tour", s);
		 
		  List<List> bean1 = tourservice.select_tourid();
//		  System.out.println(bean1);
		  List sss=new ArrayList();
		  List<List> d = null;
		for (int i = 0; i < bean1.size(); i++) {
				int text = (int) bean1.get(i).get(0);
				 d = tour_evaluateservice.select_tour_rating(text);
				 Double f = (Double) d.get(0).get(0);
				 sss.add(f);
		  }
		request.setAttribute("ss", sss);
//		System.out.println(sss);

		//----------------------------------show結尾
	
		 request.getRequestDispatcher(
					"/showtour.jsp").forward(request, response);
		
		
		 
		 
		 
		 
		//----------------------------------訂單景點起頭
		//幫下面算長度存到陣列
			List name=new ArrayList();
			List<List> bean2 = tourservice.select_tourid();
			for (int i = 0; i < bean2.size(); i++) {
				 Object text = bean2.get(i).get(0);
				name.add(text);
			}
//			System.out.println("name"+name);
			
			//選哪個訂單轉業
			List name1=new ArrayList();
			for(int i =0 ; i<name.size();i++){
				 Object text = bean2.get(i).get(0);
				 String sdsd = text.toString();
				if(sdsd.equalsIgnoreCase(look)){
					List<Travel_attractionsBean> attion = travel_attractionsseservice.select_by_tour_stringid(sdsd);
					request.setAttribute("Travel", attion);
					System.out.println(sdsd);
					request.getRequestDispatcher(
							"/test.jsp").forward(request, response);
				}
			}
			
			
			//----------------------------------訂單景點結尾
		 
		 
		 
		 
		 
		 
		 
		 
			
			
		 
		//do括號
	}
		//do括號
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

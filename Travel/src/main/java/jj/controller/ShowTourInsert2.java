package jj.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import jj.model.AttractionsBean;
import jj.model.TourBean;
import jj.model.Travel_attractionsBean;
import jj.model.service.AttractionsMangementService;
import jj.model.service.TourManagementService;

@WebServlet(
		urlPatterns={"/showtourinsert2.controller"}		
)
public class ShowTourInsert2 extends HttpServlet {
	TourManagementService tourservice;
	TourManagementService tour_evaluateservice;
	TourManagementService travel_attractionsseservice;
	TourManagementService tour_orderservice;
	AttractionsMangementService areaservice ;
	AttractionsMangementService attractions_evaluatesrvice ;
	AttractionsMangementService attractions_service ;
	AttractionsMangementService attractions_img_service ;

	
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	 tourservice = (TourManagementService) context.getBean("tourManagementService");
	 tour_evaluateservice =	 (TourManagementService) context.getBean("tourManagementService2");
	 travel_attractionsseservice = (TourManagementService) context.getBean("tourManagementService3");
	 tour_orderservice=(TourManagementService) context.getBean("tourManagementService1");

		areaservice = (AttractionsMangementService) context.getBean("attractionsMangementService");
		attractions_evaluatesrvice = (AttractionsMangementService) context.getBean("attractionsMangementService1");
		attractions_service = (AttractionsMangementService) context.getBean("attractionsMangementService2");
		attractions_img_service = (AttractionsMangementService) context.getBean("attractionsMangementService3");
		
	}
	
	
	


	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();

		//接收資取得管理訂單按鈕
			String  member1=request.getParameter("member1");
			String  member2=request.getParameter("member2");
			String  member3=request.getParameter("member3");
			String  attion1=request.getParameter("attion1");
			String  attion2=request.getParameter("attion2");
			String  attion3=request.getParameter("attion3");
			String  insert=request.getParameter("insert");
			Object tourid = session.getAttribute("touridid");
			String id = tourid.toString();
			int touridid = Integer.parseInt(id);
			System.out.println(touridid+"touridid");
			System.out.println(attion1);
			System.out.println(attion2);
			System.out.println(attion3);
//呼叫model
//根據model執行結果，導向view
	
		
			//轉換資料
			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("error", errors);
			
			
			
			
	//驗證資料	
//			if("Insert".equals(prodaction) || "Update".equals(prodaction) || "Delete".equals(prodaction)) {
//				if(id==0) {
//					errors.put("id", "請輸入Id以便於執行"+prodaction);
//				}
//			}
		
			if(errors!=null && !errors.isEmpty()) {
				request.getRequestDispatcher(
						"/ManagemementTour/ShowTourInsert.jsp").forward(request, response);
				return;
			}


		
			
		
		//------------------------------------------show起頭
		if("insert".equals(insert)){
			int memberid = Integer.parseInt(member1);
			int memberid1 = Integer.parseInt(member2);
			int memberid2 = Integer.parseInt(member3);
			int attionid = Integer.parseInt(attion1);
			int attionid1 = Integer.parseInt(attion2);
			int attionid2 = Integer.parseInt(attion3);

			travel_attractionsseservice.inset(touridid, memberid, attionid);
			travel_attractionsseservice.inset(touridid, memberid1, attionid1);
			Travel_attractionsBean insertse = travel_attractionsseservice.inset(touridid, memberid2, attionid2);
			
			if(insertse!=null){

				request.getRequestDispatcher(
						"/Index.jsp").forward(request, response);
	 
			}else{

				request.getRequestDispatcher(
						"/ManagemementTour/ShowTourInsert2.jsp").forward(request, response);
	 
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

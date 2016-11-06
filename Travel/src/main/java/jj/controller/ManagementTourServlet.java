package jj.controller;

import java.io.IOException;
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

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jj.model.AttractionsBean;
import jj.model.TourBean;
import jj.model.Tour_evaluateBean;
import jj.model.Tour_orderBean;
import jj.model.Travel_attractionsBean;
import jj.model.service.AttractionsMangementService;
import jj.model.service.TourManagementService;

@WebServlet(
		urlPatterns={"/managementtour.controller"}		
)
public class ManagementTourServlet extends HttpServlet {
	TourManagementService tourservice;
	TourManagementService tour_evaluateservice;
	TourManagementService travel_attractionsseservice;
	TourManagementService tour_orderservice;
	AttractionsMangementService areaservice ;
	AttractionsMangementService attractions_evaluatesrvice ;
	AttractionsMangementService attractions_service ;
	AttractionsMangementService attractions_img_service ;

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
		String managementtour = request.getParameter("managementtour");
		String update = request.getParameter("update");
		String delete = request.getParameter("delete");
		String change = request.getParameter("change");
		String newtour = request.getParameter("new");
		System.out.println(managementtour+",,,,,,,,,,,,,,,,managementtour");
		System.out.println(update+",,,,,,,,,,,,,,,,,,,,,,,,,update");
		System.out.println(delete+",,,,,,,,,,,,,,,,,,,,,,,,,delete");
		System.out.println(change+",,,,,,,,,,,,,,,,,,,,,,,,,change");
		System.out.println(newtour+",,,,,,,,,,,,,,,,,,,,,,,,,newtour");
//驗證資料
//呼叫model
//根據model執行結果，導向view
	
		
		
		


		
		
		
		//------------------------------------------show起頭
		if("managementtour".equals(managementtour)){
			
		List<TourBean> bean = tourservice.select_all_web();
		List s=new ArrayList();
		  for (int i = 0; i < bean.size(); i++) {
			  List d = (List<TourBean>) bean.get(i);
			  s.add(d);
			  System.out.println(d+"dddddd");
			  }
		  System.out.println(s+"我是旅程,,,,,,,,,,,,,,,,");
		  request.setAttribute("tour", s);
		  
System.out.println("我是分隔線========================================");
		  
		 request.getRequestDispatcher(
					"/ShowManagementTour.jsp").forward(request, response);
		 
		}
		
		//----------------------------------show結尾
	
		 
		 
		
		
		//----------------------------------更新景點起頭
				//幫下面算長度存到鄭烈
//					List name=new ArrayList();
//					List<List> bean2 = tourservice.select_tourid();
//					for (int i = 0; i < bean2.size(); i++) {
//						 Object text = bean2.get(i).get(0);
//						name.add(text);
//					}
////					System.out.println("name"+name);
//					
//					//選哪個訂單轉業
//					List name1=new ArrayList();
//					for(int i =0 ; i<name.size();i++){
//						 Object text = bean2.get(i).get(0);
//						 String tourid = text.toString();
//						if(tourid.equalsIgnoreCase(newtour)){
//							List<Travel_attractionsBean> attion = travel_attractionsseservice.select_by_tour_stringid(tourid);
//							List<List> settour = tourservice.select_setTourbean1(tourid);
//							List<Tour_evaluateBean> evaluateservice = tour_evaluateservice.select_by_tour(tourid);
//							System.out.println(evaluateservice+"evaluateserviceevaluateserviceevaluateservice");
//
//							
//						//模擬id為1
//							int x =1;
//						session.setAttribute("memberid",x);
//							//送關聯的景點
//							request.setAttribute("Travel", attion);
//							session.setAttribute("settour",settour);
//							//傳送評論
//							request.setAttribute("evaluate", evaluateservice);
//							System.out.println(tourid+",,,,,,,,,,,,,,,,,,,,,tourid");
//						System.out.println(settour+",,,,,,,,,,,,,,,,,,,,,settour");
//					
//							
//							
//							
//							request.getRequestDispatcher(
//									"/showtourupdate.controller").forward(request, response);
//						}
//					}
					
					
					//----------------------------------更新結尾
		 
			
		//<--------------------新增開始---------------------------->
		if("new".equals(newtour)){
			
			  
			  request.getRequestDispatcher(
						"/ManagemementTour/ShowTourInsert.jsp").forward(request, response);
			 
			}
		//<---------------------新增結尾--------------------->

		
		
		List name=new ArrayList();
		List<List> bean2 = tourservice.select_tourid();
		for (int i = 0; i < bean2.size(); i++) {
			 Object text = bean2.get(i).get(0);
			name.add(text);
		}
		
		System.out.println(name+"name..............");
		//選哪個訂單轉業
		List name2=new ArrayList();
		for(int i =0 ; i<name.size();i++){
			 Object text = bean2.get(i).get(0);
			 String sdsd = text.toString();
			 name2.add(sdsd);
		}
		System.out.println(name2+"name1..............");

		
		//<--------------------更新---------------------------->
				for(int i =0 ; i<name.size();i++){
						 Object text = bean2.get(i).get(0);
						 String sdsd = text.toString();
						if(sdsd.equalsIgnoreCase(update)){
							int id=Integer.parseInt(update);
							List showonetour = tourservice.select_all_by_id(id);
							
							System.out.println(showonetour+"showonetour.........showonetour");
							
							
							
							
//							List<AttractionsBean> result1 = attractions_service.select_id_name();
//							System.out.println(result1);
//							session.setAttribute("show30", result1);
						
							List resultop = travel_attractionsseservice.select_id_name(id);
							request.setAttribute("resultop", resultop);
							
							System.out.println(resultop+"resultopresultopresultop");
							
							
							Travel_attractionsBean bean=new Travel_attractionsBean();
							bean.setTour_id(id);
//							List<Travel_attractionsBean> ss = travel_attractionsseservice.select_by_tour_id(bean);							
//							request.setAttribute("attion", ss);
//							System.out.println(ss+"sss,,,,,,,");
							request.setAttribute("tour",showonetour);
							 
							request.getRequestDispatcher(
										"/ManagemementTour/ShowTourUpdate.jsp").forward(request, response);
						}
					
				}
				//<---------------------更新結尾--------------------->

				
				
				
				
				
				
				//<---------------------刪除--------------------->

				for(int i =0 ; i<name.size();i++){
					 Object text = bean2.get(i).get(0);
					 String sdsd = text.toString();
					if(sdsd.equalsIgnoreCase(delete)){
						int id=Integer.parseInt(delete);
						
						
						
						TourBean bean =new TourBean();
						bean.setTour_id(id);
						TourBean bean1 =new TourBean();
						bean.setTour_id(id);
						tourservice.delete(bean);

//						travel_attractionsseservice.delete(bean1);
						
						
						
						request.getRequestDispatcher(
									"/Index.jsp").forward(request, response);
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

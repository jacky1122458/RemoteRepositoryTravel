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

import jj.model.TourBean;
import jj.model.Tour_evaluateBean;
import jj.model.Tour_orderBean;
import jj.model.Travel_attractionsBean;
import jj.model.service.TourManagementService;

@WebServlet(
		urlPatterns={"/showtour1.controller"}		
)
public class ShowTourServlet extends HttpServlet {
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

		//接收資料
		String look = request.getParameter("look");
		String serch = request.getParameter("serch");
		
		//全部 台北 台中
		String taiatt = request.getParameter("taiatt");
		String conatt = request.getParameter("conatt");
		String ying = request.getParameter("newtai");
		String tn = request.getParameter("tn");
		
		
		
		
		System.out.println(look);
		System.out.println(serch);

		
		
//驗證資料
//呼叫model
//根據model執行結果，導向view
	
		
		
		
		
		
		//------------------------------------------show起頭
		if("serch".equals(serch)){
			
			List<List> sysout = tourservice.select_all_2();
			
			System.out.println("----------------------------------------------");
			System.out.println(sysout+"sysout-------------------------");
			System.out.println("-----------------------------------------------");

			  request.setAttribute("tour",sysout);

//			
//		List<TourBean> bean = tourservice.select_all_web();
//		List s=new ArrayList();
//		  for (int i = 0; i < bean.size(); i++) {
//			  List d = (List<TourBean>) bean.get(i);
//			  s.add(d);
//			  System.out.println(d);
//			  }
//		  System.out.println(s);
//		  request.setAttribute("tour", s);
		  

//		  List<List> bean1 = tourservice.select_tourid();
//		  System.out.println(bean1);
//		  List sss=new ArrayList();
//		  List<List> d = null;
//		for (int i = 0; i < bean1.size(); i++) {
//				int text = (int) bean1.get(i).get(0);
//				 d = tour_evaluateservice.select_tour_rating(text);
//				 Double f = (Double) d.get(0).get(0);
//				 sss.add(f);
//		  }
//		request.setAttribute("ss", sss);
//		System.out.println(sss);
//
		
		
		//取得所有tourid
		List name=new ArrayList();
		List<List> bean2 = tourservice.select_tourid();
		for (int i = 0; i < bean2.size(); i++) {
			 Object text = bean2.get(i).get(0);
			name.add(text);
		}		
		System.out.println("tourid++++"+name);
		
		//取去tourid 根 number值
		List numberpeople=new ArrayList();
		List selectourid=new ArrayList();
		for(int i =0 ; i<name.size();i++){
			 Object text = bean2.get(i).get(0);
			 String tourid = text.toString();
			  List<List> result = tourservice.select_nubmer_byid_zero(tourid);
			  numberpeople.add(result.get(0).get(0));
			  selectourid.add(result.get(0).get(1));
		}
		System.out.println(numberpeople+"我是所有得編號numberpeople 回傳的人數");
		System.out.println(selectourid+"我是所有得編號selectourid 回傳的人數");

		//解迴圈如果=0去更新為false  自動偵測 1 為true
		for(int i =0 ; i<name.size();i++){
			int sum = (int) numberpeople.get(i);
			int toruidsum = (int) selectourid.get(i);
			System.out.println(sum+"sum........");
			System.out.println(toruidsum+"toruidsum........");
			if(sum==0){
				 boolean notok = tourservice.update_status_bytourd_false(toruidsum);
			}else{
				 boolean ok = tourservice.update_status_bytourd_true(toruidsum);
			}
		}
		
		//算人數------------------------------------------
//		List name=new ArrayList();
//		List<List> bean2 = tourservice.select_tourid();
//		for (int i = 0; i < bean2.size(); i++) {
//			 Object text = bean2.get(i).get(0);
//			name.add(text);
//		}
//		List name20=new ArrayList();
//		for(int x= 0; x<name.size();x++){
//		Object text = bean2.get(x).get(0);
//		String sdsd = text.toString();
//		List<List> ssdf = tourservice.select_byid_date(sdsd);		
//		name20.add(ssdf.get(0).get(0));
//		}
//		System.out.println("存完時間"+name20);
//		
//		
//		ArrayList  number_tour=new ArrayList();
//		ArrayList  number_people=new ArrayList();
//		for(int z= 0; z<name.size();z++){
//			Object text = bean2.get(z).get(0);
//			String sdsd = text.toString();
//			
//			//sdsd 等於有得 旅程編號
//			Object day = name20.get(z);
//			String subdate = day.toString().substring(0,11);
//			List<List> number = tour_orderservice.select_tour_number(sdsd, subdate);
//			List<List> numbertal = tourservice.select_number_byid(sdsd);
//			number_tour.add(number.get(0));
//			number_people.add(numbertal.get(0));
//		
//			System.out.println("sddf,"+day);
//			System.out.println("subdate,"+subdate);
//		}
//		System.out.println("number"+number_tour);
//		System.out.println("numbertal"+number_people);
//		
//		
//		int ssd =0;
//		for(int y=0; y<number_tour.size();y++){
//			
//		}
//		System.out.println(ssd);
		//算人數---------------------------------------

		
		
		
		
		
		
		
		
		
		
		
		 request.getRequestDispatcher(
					"/ShowSearch/search_trave.jsp").forward(request, response);
		 
		}
		
		//----------------------------------show結尾
	
		
		
		//-----------------------------------//
				if("2".equals(taiatt)){
					
					List<List> sysout = tourservice.select_all_tai();
					
					System.out.println("----------------------------------------------");
					System.out.println(sysout+"sysout-------------------------");
					System.out.println("-----------------------------------------------");

					  request.setAttribute("tour",sysout);

					  request.getRequestDispatcher(
									"/ShowSearch/search_trave.jsp").forward(request, response);
				}
				
				//-----------------------------------//
		 
				
				//-----------------------------------//
				if("3".equals(conatt)){
					
					List<List> sysout = tourservice.select_all_conatt();
					
					System.out.println("----------------------------------------------");
					System.out.println(sysout+"sysout-------------------------");
					System.out.println("-----------------------------------------------");

					  request.setAttribute("tour",sysout);

					  request.getRequestDispatcher(
									"/ShowSearch/search_trave.jsp").forward(request, response);
				}
				
				//-----------------------------------//
				
				
				if("4".equals(ying)){
					
					List<List> sysout = tourservice.select_all_ying();
					
					System.out.println("----------------------------------------------");
					System.out.println(sysout+"sysout-------------------------");
					System.out.println("-----------------------------------------------");

					  request.setAttribute("tour",sysout);

					  request.getRequestDispatcher(
									"/ShowSearch/search_trave.jsp").forward(request, response);
				}
				
				
				
				if("5".equals(tn)){
					
					List<List> sysout = tourservice.select_all_tn();
					
					System.out.println("----------------------------------------------");
					System.out.println(sysout+"sysout-------------------------");
					System.out.println("-----------------------------------------------");

					  request.setAttribute("tour",sysout);

					  request.getRequestDispatcher(
									"/ShowSearch/search_trave.jsp").forward(request, response);
				}
		//----------------------------------訂單景點起頭
				//幫下面算長度存到鄭烈
					List name=new ArrayList();
					List<List> bean2 = tourservice.select_tourid();
					for (int i = 0; i < bean2.size(); i++) {
						 Object text = bean2.get(i).get(0);
						name.add(text);
					}
//					System.out.println("name"+name);
					
					//選哪個訂單轉業
					List name1=new ArrayList();
					for(int i =0 ; i<name.size();i++){
						 Object text = bean2.get(i).get(0);
						 String sdsd = text.toString();
						if(sdsd.equalsIgnoreCase(look)){
							List<Travel_attractionsBean> attion = travel_attractionsseservice.select_by_tour_stringid(sdsd);
							List<List> settour = tourservice.select_setTourbean1(sdsd);
							List<Tour_evaluateBean> evaluateservice = tour_evaluateservice.select_by_tour(sdsd);
							System.out.println(evaluateservice+"evaluateserviceevaluateserviceevaluateservice");

							
							//模擬id為1
							int x =1;
							session.setAttribute("memberid",x);
						
							//送關聯的景點
							request.setAttribute("Travel", attion);
							session.setAttribute("settour",settour);
							
							//傳送評論
							request.setAttribute("evaluate", evaluateservice);
//							System.out.println(sdsd);
							System.out.println("----------------------------------------------");
							System.out.println(settour+"settoursettoursettoursettour");
							System.out.println("-----------------------------------------------");
							System.out.println(attion+"attionattionattionattionattion");

							
							
							
							request.getRequestDispatcher(
									"/ShowSearch/search_travel_step2.jsp").forward(request, response);
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

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

import model.MemberBean;
import jj.model.TourBean;
import jj.model.Tour_evaluateBean;
import jj.model.Tour_orderBean;
import jj.model.Travel_attractionsBean;
import jj.model.service.TourManagementService;


@WebServlet(
		urlPatterns={"/showmyorder.controller"}		
)
public class Showmyorder extends HttpServlet {
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
		String myorder = request.getParameter("myorder");
		String look = request.getParameter("look");
		String evaluate = request.getParameter("evaluate");

		System.out.println(myorder+"im myorder");
		System.out.println(look+"iam look");
		System.out.println(evaluate+"Sowevaluate");
//驗證資料
		
		
		

		
		
//呼叫model
		
//根據model執行結果，導向view
	
		MemberBean memberBean = (MemberBean)session.getAttribute("memberBean");
		
		
			
	
//		if("evaluate".equals(evaluate)){	
//			
//			List name20=new ArrayList();
//			// 搜尋自己的orderid 有幾個
//			List<List> myorderid_by = tour_orderservice.select_by_member_get_tourid(sse);
//			for (int s = 0; s < myorderid_by.size();s++) {
//				Object text = myorderid_by.get(s).get(0);
//				name20.add(text);
//			}
//			System.out.println("name20,,,,,,,,," + name20);
//				
//				//選哪個訂單轉業
//				List name40=new ArrayList();
//				for(int d =0 ; d<name20.size();d++){
//				 Object text20 = myorderid_by.get(d).get(0);
//				 String sdsd20 = text20.toString();
//			 System.out.println(sdsd+"sdsdsdsd+++");
//				if(sdsd20.equalsIgnoreCase(evaluate)){
//					//取得orderid tourid 訂購人數;
//					List<List> orderidnumber2 = tour_orderservice.select_by_orderid_get_tourid_number(sdsd20);
//					System.out.println("orderidnumber2,,,,,,,,,,"+orderidnumber2);
//					int thisorderid1 = (int)orderidnumber2.get(0).get(0);
//					int thistourid2 = (int) orderidnumber2.get(0).get(1);
//					int thispeople3 = (int) orderidnumber2.get(0).get(2);
//					System.out.println(thisorderid1);
//					System.out.println(thistourid2);
//					System.out.println(thispeople3);
//			
//			
//			  
//			
//			
//					session.setAttribute("evaluate", orderidnumber2);
//					
//			request.getRequestDispatcher(
//						"/tourevaluate.jsp").forward(request, response);
//		}
//	}
//}	
		
		
		
		
		
		
		
		
		if("myorder".equals(myorder)){	

//			System.out.println(sse);
//			List<Tour_orderBean> ss = tour_orderservice.select_by_member(sse);
//			System.out.println(ss+"ssssssssssssss--------------------------");
			 
			
			
//			
//			 List s=new ArrayList();
//			  for (int i = 0; i < ss.size(); i++) {
//				  List sddf = (List) ss.get(i);
//				  s.add(sddf);
////				  System.out.println(sddf);
//			
//			  }
//			  System.out.println("------------------------------------------------------");
//			  System.out.println(s+"ssssssssssssssssssssssssss");
//			  request.setAttribute("mytour", s);
			  
		
			  
			List sadd=new ArrayList();
			List resultorderid = tour_orderservice.select_tourmyorder_newid(memberBean.getMemberid());
				 
			System.out.println(resultorderid);

				
			  for(int x=0;x<resultorderid.size();x++){
				  int es = (int) resultorderid.get(x);
				  
				   List result = tour_orderservice.select_tourmyorder_new(es,memberBean.getMemberid());
				   Object resultorur = result.get(0);
				  sadd.add(resultorur);
				  System.out.println(resultorur+"---------------------result---------------------");
			  }
			
			request.setAttribute("mytour", sadd);
			System.out.println(sadd+"========================sadd==========================");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
				 
				 
			  
			  request.getRequestDispatcher(
						"/search_allreservations_for_travel.jsp").forward(request, response);
		}	
			
		  
			
	
		
		List sadd=new ArrayList();
		List resultorderid = tour_orderservice.select_tourmyorder_newid(memberBean.getMemberid());
	
		System.out.println(resultorderid);
		  for(int x=0;x<resultorderid.size();x++){
			  int es = (int) resultorderid.get(x);
			  
			   List result = tour_orderservice.select_tourmyorder_new(es,memberBean.getMemberid());
			   Object resultorur = result.get(0);
			  sadd.add(resultorur);
			  System.out.println(resultorur+"---------------------result---------------------");
		  }
		
		request.setAttribute("mytour", sadd);


		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  Map<String, String> errors = new HashMap<String, String>();
		  request.setAttribute("error", errors);
			
		  
		  
		
	
	//----------------------------------show結尾

		
		
		
		
		
	 
	 
//		//----------------------------------訂單景點起頭
//		幫下面算長度存到陣列
		List name=new ArrayList();
		// 搜尋自己的orderid 
		List<List> myorderid = tour_orderservice.select_by_member_get_tourid(memberBean);
		for (int i = 0; i < myorderid.size(); i++) {
			Object text = myorderid.get(i).get(0);
			name.add(text);
		}
//		System.out.println("name" + name);
			
			//選哪個訂單轉業
			List name1=new ArrayList();
			for(int i =0 ; i<name.size();i++){
			 Object text = myorderid.get(i).get(0);
			 String sdsd = text.toString();
//			 System.out.println(sdsd+"sdsdsdsd+++");
			

			 
			 
			if(sdsd.equalsIgnoreCase(look)){
				//取得orderid tourid 訂購人數;
				List<List> orderidnumber = tour_orderservice.select_by_orderid_get_tourid_number(sdsd);
				System.out.println("showmy,,,,,,,,,,"+orderidnumber);
				int thisorderid = (int) orderidnumber.get(0).get(0);
				int thistourid = (int) orderidnumber.get(0).get(1);
				int thispeople = (int) orderidnumber.get(0).get(2);
				System.out.println(thistourid);
				System.out.println(thisorderid);
				System.out.println(thispeople);
				//取得字串人數
				//須帶入字串型態 tourid 轉換算 tour的限制人數
				List<List> numpeople = tourservice.select_number_bytourid(thistourid);
				System.out.println("getintnumgetintnum"+numpeople);
				int getintnum = (int) numpeople.get(0).get(0);
				System.out.println("getintnum"+getintnum);
				
				//更新自己訂單狀態為0
				//修改前面旅遊訂單加回
				if(thisorderid!=0){
					boolean dd = tour_orderservice.update_status(false, thisorderid);
					int sum = (getintnum+thispeople);
					boolean update = tourservice.update_number_people_back(sum,thistourid,true);
				}
				
				  
				 request.getRequestDispatcher(
							"/Index.jsp").forward(request, response);
			}
			
			
			
			
			//舉得值給留言
			if(sdsd.equalsIgnoreCase(evaluate)){
				//取得orderid tourid 訂購人數;
				List<List> orderidnumber2 = tour_orderservice.select_by_orderid_get_tourid_number(sdsd);
				System.out.println("orderidnumber2,,,,,,,,,,"+orderidnumber2);
				int setorderid = (int) orderidnumber2.get(0).get(0);
				int settourid = (int) orderidnumber2.get(0).get(1);
				int setpeople = (int) orderidnumber2.get(0).get(2);
				session.setAttribute("orderidnumber2",orderidnumber2);
				session.setAttribute("setorderid", setorderid);
				session.setAttribute("settourid", settourid);
				int id=memberBean.getMemberid();
				session.setAttribute("member", id);
				List checke = tour_evaluateservice.select_check(setorderid, settourid,memberBean.getMemberid());
				
				System.out.println("------------iam setorderid"+setorderid);
				System.out.println("------------iam settourid"+settourid);
				System.out.println("------------iam check"+checke);
				System.out.println(memberBean.getMemberid()+",,,,,,,sse.getMemberid(),,,,,,,,,,,,,");
				
				
				if(!checke.isEmpty()){
					errors.put("redayy", "已經評分");
					request.setAttribute("error", errors);
					request.getRequestDispatcher(
						"/search_allreservations_for_travel.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher(
						"/tourevaluate.jsp").forward(request, response);
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

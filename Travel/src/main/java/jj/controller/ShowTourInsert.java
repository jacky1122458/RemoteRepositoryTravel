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
import jj.model.service.AttractionsMangementService;
import jj.model.service.TourManagementService;

@WebServlet(
		urlPatterns={"/showtourinsert.controller"}		
)
public class ShowTourInsert extends HttpServlet {
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
			String  temp1=request.getParameter("tourname");
			String  temp2=request.getParameter("member");
			
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
			
			String  member1=request.getParameter("member1");
			String  member2=request.getParameter("member2");
			String  member3=request.getParameter("member3");
			String  attion1=request.getParameter("attion1");
			String  attion2=request.getParameter("attion2");
			String  attion3=request.getParameter("attion3");
			String  insert=request.getParameter("insert");
		
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
						"/ManagemementTour/ShowTourInsert.jsp").forward(request, response);
				return;
			}


		
		
			
			TourBean bean = new TourBean();
			
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
			bean.setTour_status(true);
			bean.setExplanation(ex);
			bean.setDeparture_date(outdate);
		
		//------------------------------------------show起頭
		if("insert".equals(insert)){
			
			
			
			TourBean inserttour = tourservice.insert(bean);
			
				if(inserttour !=null){
					
					List<AttractionsBean> result1 = attractions_service.select_id_name();
					  System.out.println(result1);
					  session.setAttribute("show20",result1);
					
					List result = tourservice.select_max_id();
					Object out = result.get(0);
					System.out.println(result+",,,,resultresultresultresult");
					System.out.println(out+",,,,outoutoutout");
					session.setAttribute("touridid",out);
					
					request.getRequestDispatcher(
						"/ManagemementTour/ShowTourInsert2.jsp").forward(request, response);
		 
				}else{
					
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

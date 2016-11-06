package cht.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cht.model.EvaluationService;
import cht.model.HotelReview;
import model.MemberBean;

@WebServlet( urlPatterns={"/Evaluation.controller"} )
public class EvaluationServlet   extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EvaluationService evaluationService;
	
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		evaluationService = (EvaluationService) context.getBean("evaluationService");
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//接收資料
		String temp1 = request.getParameter("cleanliness");
		String temp2 = request.getParameter("comfort");
		String temp3 = request.getParameter("location");
		String temp4 = request.getParameter("facilities");
		String temp5 = request.getParameter("staff");
		String temp6 = request.getParameter("cp");
		String temp7 = request.getParameter("total");
		String advantage = request.getParameter("advantage");
		String defect = request.getParameter("defect");
		
		
		MemberBean memberben = (MemberBean)session.getAttribute("MemberBean");
		int hotelid = (int)session.getAttribute("hotelid");
		int orderid = (int)session.getAttribute("orderid");
		System.out.println("hid'"+hotelid+", oid'"+orderid);
		//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
		int cleanliness = 0;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
				cleanliness = Integer.parseInt(temp1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("cleanliness", "cleanliness必須是整數");
			}
		}
		
		int comfort = 0;
		if(temp2!=null && temp2.trim().length()!=0) {
			try {
				comfort = Integer.parseInt(temp2);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("comfort", "comfort必須是整數");
			}
		}
		
		int location = 0;
		if(temp3!=null && temp3.trim().length()!=0) {
			try {
				location = Integer.parseInt(temp3);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("location", "location必須是整數");
			}
		}
		
		int facilities = 0;
		if(temp4!=null && temp4.trim().length()!=0) {
			try {
				facilities = Integer.parseInt(temp4);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("facilities", "facilities必須是整數");
			}
		}
		
		int staff = 0;
		if(temp5!=null && temp5.trim().length()!=0) {
			try {
				staff = Integer.parseInt(temp5);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("staff", "staff必須是整數");
			}
		}
		
		int cp = 0;
		if(temp6!=null && temp6.trim().length()!=0) {
			try {
				cp = Integer.parseInt(temp6);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("cp", "cp必須是整數");
			}
		}
		
		int total = 0;
		if(temp7!=null && temp7.trim().length()!=0) {
			try {
				total = Integer.parseInt(temp7);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("total", "total必須是整數");
			}
		}
		
		
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/testEvaluation.jsp").forward(request, response);
			return;
		}
		
		//呼叫Model, 根據Model執行結果顯示View
		HotelReview review=null;
		
		if(hotelid !=0 && orderid !=0){
			HotelReview bean = new HotelReview();
			bean.setOrderid(orderid);
			bean.setMemberid(memberben.getMemberid());
			bean.setHotelid(hotelid);
			bean.setDate(new java.util.Date());
			bean.setCleanliness(cleanliness);
			bean.setComfort(comfort);
			bean.setLocation(location);
			bean.setFacilities(facilities);
			bean.setStaff(staff);
			bean.setCp(cp);
			bean.setTotal(total);
			bean.setAdvantage(advantage);
			bean.setDefect(defect);
			bean.setDisplay(true);
			
			review = evaluationService.insert(bean);
		}
		
		System.out.println(review);
		
		
		request.getRequestDispatcher(
				"/chtpages/testIndex.jsp").forward(request, response);
		
		//session.removeAttribute("count");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

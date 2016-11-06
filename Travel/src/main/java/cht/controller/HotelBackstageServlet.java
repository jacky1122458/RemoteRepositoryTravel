package cht.controller;

import java.io.IOException;
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

import cht.model.Hotel;
import cht.model.HotelBackstageService;



@WebServlet( urlPatterns={"/HotelBackstageServlet.controller"} )
public class HotelBackstageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HotelBackstageService hotelbackService;
	
	@Override
	public void init() throws ServletException {
	ApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	hotelbackService = (HotelBackstageService) context.getBean("hotelbackService");
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// = ()session.getAttribute("");
		
		//接收資料
		String temp1 = request.getParameter("hotelid");
		String hotelname = request.getParameter("hotelname");
		String temp2 = request.getParameter("typeid");
		String phone = request.getParameter("phone");
		String temp3 = request.getParameter("class_level");
		String check_in = request.getParameter("check_in");
		String check_out = request.getParameter("check_out");
		String temp4 = request.getParameter("price_bed");
		String temp5 = request.getParameter("years");
		String address = request.getParameter("address");
		String language = request.getParameter("language");
		String description = request.getParameter("description");
		String note = request.getParameter("note");
		String temp6 = request.getParameter("lat");
		String temp7 = request.getParameter("lng");
		String temp8 = request.getParameter("status");
		
		String hotelaction = request.getParameter("hotelaction");
		
		//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
		int hotelid = 0;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
				hotelid = Integer.parseInt(temp1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("hotelid", "hotelid必須是整數");
			}
		}
		
		int typeid = 0;
		if(temp2!=null && temp2.trim().length()!=0) {
			try {
				typeid = Integer.parseInt(temp2);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("typeid", "typeid必須是整數");
			}
		}
		
		int class_level = 0;
		if(temp3!=null && temp3.trim().length()!=0) {
			try {
				class_level = Integer.parseInt(temp3);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("class_level", "class_level必須是整數");
			}
		}
		
		int price_bed = 0;
		if(temp4!=null && temp4.trim().length()!=0) {
			try {
				price_bed = Integer.parseInt(temp4);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("price_bed", "price_bed必須是整數");
			}
		}
		
		int years = 0;
		if(temp5!=null && temp5.trim().length()!=0) {
			try {
				years = Integer.parseInt(temp5);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("years", "years必須是整數");
			}
		}
		
		Double lat =(double)0;
		if(temp6!=null && temp6.trim().length()!=0) {
			try {
				lat = Double.parseDouble(temp6);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("lat", "lat必須是浮點數");
			}
		}
		
		Double lng =(double)0;
		if(temp7!=null && temp7.trim().length()!=0) {
			try {
				lng = Double.parseDouble(temp7);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("lng", "lng必須是浮點數");
			}
		}
		
		
		boolean status = false;
		if(temp8!=null && temp8.trim().length()!=0) {
			status = Boolean.valueOf(temp8);
		}
		
		//呼叫Model, 根據Model執行結果顯示View
		Hotel bean = new Hotel();
		bean.setHotelid(hotelid);
		bean.setHotelname(hotelname);
		bean.setTypeid(typeid);
		bean.setPhone(phone);
		bean.setClass_level(class_level);
		bean.setCheck_in(check_in);
		bean.setCheck_out(check_out);
		bean.setYears(years);
		bean.setAddress(address);
		bean.setLanguage(language);
		bean.setDescription(description);
		bean.setNote(note);
		bean.setLat(lat);
		bean.setLng(lng);
		bean.setStatus(status);
		
		Map<String, Object> reviewAvg = null;
		if(hotelid!=0){
			reviewAvg = hotelbackService.getReviewAvg(bean);
			if(reviewAvg!=null){
				bean.setTotal_comment(reviewAvg.size());
				bean.setTol_avg((Double)reviewAvg.get("total"));
			}else {
				bean.setTotal_comment(0);
				bean.setTol_avg((double)0);
			}
		}
		
		if("Select".equals(hotelaction)) {
			List<Hotel> result = hotelbackService.selectByArea(hotelname);
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"").forward(request, response);
		} else if("Delete".equals(hotelaction)) {
			boolean result = hotelbackService.delete(bean);
			request.setAttribute("delete", result);
			request.getRequestDispatcher(
					"").forward(request, response);
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

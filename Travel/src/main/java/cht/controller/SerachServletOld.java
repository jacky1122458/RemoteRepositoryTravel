package cht.controller;

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

import cht.model.HotelServiceAction;
import cht.model.ReturnHotel;


@WebServlet( urlPatterns={"/serachotel.controller"} )
public class SerachServletOld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HotelServiceAction hotelServiceAction;
	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		hotelServiceAction = (HotelServiceAction) context.getBean("hotelServiceAction");

	}
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//接收資料
		String address = request.getParameter("address");
		String temp1 = request.getParameter("checkin");
		String temp2 = request.getParameter("checkout");
		String temp3 = request.getParameter("roomNum");
		String temp4 = request.getParameter("adultNum");
		
		String[] service = request.getParameterValues("service");
		String temp5 = request.getParameter("hoteltype");
		String temp6 = request.getParameter("price");
		
		session.setAttribute("checkin", temp1);
		session.setAttribute("checkout", temp2);
		
		
		System.out.println("address'"+address);
		System.out.println("checkin'"+temp1);
		System.out.println("checkout'"+temp2);
		System.out.println("number'"+temp3);
		System.out.println("adultNum'"+temp4);
		System.out.println("price'"+temp6);
		System.out.println("hoteltype'"+temp5);
		System.out.println("service'"+service);
		
		
		//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
		java.util.Date checkin = null;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
				checkin = sFormat.parse(temp1);
			} catch (ParseException e) {
				e.printStackTrace();
				errors.put("checkin", "checkin必須是日期:yyyy-MM-dd");
			}
		}else{
			checkin=new java.util.Date();
		}
		
		java.util.Date checkout = null;
		if(temp2!=null && temp2.trim().length()!=0) {
			try {
				checkout = sFormat.parse(temp2);
			} catch (ParseException e) {
				e.printStackTrace();
				errors.put("checkout", "checkout必須是日期:yyyy-MM-dd");
			}
		}else{
			checkout=new java.util.Date();
		}
		
		int number = 0;
		if(temp3!=null && temp3.trim().length()!=0) {
			try {
				number = Integer.parseInt(temp3);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("number", "number必須是整數");
			}
		}
		
		int peoplenum = 0;
		if(temp4!=null && temp4.trim().length()!=0) {
			try {
				peoplenum = Integer.parseInt(temp4);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("peoplenum", "peoplenum必須是整數");
			}
		}
		int type = 0;
		if(temp5!=null && temp5.trim().length()!=0) {
			try {
				type = Integer.parseInt(temp5);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("type", "type必須是整數");
			}
		}
		int price = 0;
		if(temp6!=null && temp6.trim().length()!=0) {
			try {
				price = Integer.parseInt(temp6);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("type", "type必須是整數");
			}
		}
		
		//驗證資料
		if(address!=null && address.equals(""))
		{
			errors.put("address", "請輸入項目");
		}
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/Hotel_list.jsp").forward(request, response);
			return;
		}
		//呼叫Model, 根據Model執行結果顯示View
		List<ReturnHotel> result =null;
		if(type!=0){
			if(service!=null){
				if(price!=0){
					System.out.println("1");
					result = hotelServiceAction.selectHotel(address, checkin, checkout, number, peoplenum, type, price, service);
					request.setAttribute("select", result);
				}else{
					System.out.println("2");
					result = hotelServiceAction.selectHotel(address,checkin,checkout,number,peoplenum,type,service);
					request.setAttribute("select", result);
				}
			}else{
				if(price!=0){
					System.out.println("3");
					result = hotelServiceAction.selectHotel(address, checkin, checkout, number, peoplenum, type, price);
					request.setAttribute("select", result);
				}else{
					System.out.println("4");
					result = hotelServiceAction.selectHotelType(address,checkin,checkout,number,peoplenum,type);
					request.setAttribute("select", result);
				}
			}
		}else if(service!=null){
			if(price!=0){
				System.out.println("5");
				result = hotelServiceAction.selectHotel(address, checkin, checkout, number, peoplenum, service, price);
				request.setAttribute("select", result);
			}else{
				System.out.println("6");
				result = hotelServiceAction.selectHotel(address,checkin,checkout,number,peoplenum,service);
				System.out.println(result);
				request.setAttribute("select", result);
			}
		}else{
			if(price!=0){
				System.out.println("7");
				result = hotelServiceAction.selectHotel(address,checkin,checkout,number,peoplenum,price);
				request.setAttribute("select", result);
			}else{
				System.out.println("8");
				result = hotelServiceAction.selectHotel(address,checkin,checkout,number,peoplenum);
				request.setAttribute("select", result);
			}
		}
//		request.getRequestDispatcher(
//				"/chtpages/hotels.jsp").forward(request, response);
		request.getRequestDispatcher(
				"/Hotel_list.jsp").forward(request, response);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

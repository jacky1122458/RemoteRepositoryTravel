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
import cht.model.SearchHotelService;


@WebServlet( urlPatterns={"/serachotel2.controller"} )
public class SerachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SearchHotelService searchHotelService;
	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		searchHotelService = (SearchHotelService) context.getBean("searchHotelService");

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
		
		int roomNum = 1;
		if(temp3!=null && temp3.trim().length()!=0) {
			try {
				roomNum = Integer.parseInt(temp3);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				//errors.put("roomNum", "roomNum必須是整數");
			}
		}
		
		int peoplenum = 1;
		if(temp4!=null && temp4.trim().length()!=0) {
			try {
				peoplenum = Integer.parseInt(temp4);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				//errors.put("peoplenum", "peoplenum必須是整數");
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
		int priceleval = 0;
		if(temp6!=null && temp6.trim().length()!=0) {
			try {
				priceleval = Integer.parseInt(temp6);
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
					"/Index.jsp").forward(request, response);
			return;
		}
		//呼叫Model, 根據Model執行結果顯示View
		
		
		
		
		List<Map<String,Object>> result =null;
		if(type!=0){
			if(service!=null){
				if(priceleval!=0){
					System.out.println("A1");
					result = searchHotelService.searchAddressTypeServicePrice(address, checkin, checkout, roomNum, peoplenum, service, type, priceleval);
					request.setAttribute("result", result);
				}else{
					System.out.println("A2");
					result = searchHotelService.searchAddressTypeService(address, checkin, checkout, roomNum, peoplenum, service, type);
					request.setAttribute("result", result);
				}
			}else{
				if(priceleval!=0){
					System.out.println("A3");
					result = searchHotelService.searchAddressTypePrice(address, checkin, checkout, roomNum, peoplenum, type, priceleval);
					request.setAttribute("result", result);
				}else{
					System.out.println("A4");
					result = searchHotelService.searchAddressType(address, checkin, checkout, roomNum, peoplenum, type);
					request.setAttribute("result", result);
				}
			}
		}else if(service!=null){
			if(priceleval!=0){
				System.out.println("A5");
				result = searchHotelService.searchAddressServicePrice(address, checkin, checkout, roomNum, peoplenum, service, priceleval);
				request.setAttribute("result", result);
			}else{
				System.out.println("A6");
				result = searchHotelService.searchAddressService(address, checkin, checkout, roomNum, peoplenum, service);
				System.out.println("service"+service[0]);
				System.out.println(result);
				request.setAttribute("result", result);
			}
		}else{
			if(priceleval!=0){
				System.out.println("A7");
				result = searchHotelService.searchAddressPrice(address,checkin,checkout,roomNum,peoplenum,priceleval);
				request.setAttribute("result", result);
			}else{
				System.out.println("A8");
				result = searchHotelService.searchHotelResult(address, checkin, checkout, roomNum, peoplenum);
				request.setAttribute("result", result);
			}
		}
		
		if(result==null){
			if(type!=0){
				if(service!=null){
					if(priceleval!=0){
						System.out.println("N1");
						result = searchHotelService.searchNameTypeServicePrice(address, checkin, checkout, roomNum, peoplenum, service, type, priceleval);
						request.setAttribute("result", result);
					}else{
						System.out.println("N2");
						result = searchHotelService.searchNameTypeService(address, checkin, checkout, roomNum, peoplenum, service, type);
						request.setAttribute("result", result);
					}
				}else{
					if(priceleval!=0){
						System.out.println("N3");
						result = searchHotelService.searchNameTypePrice(address, checkin, checkout, roomNum, peoplenum, type, priceleval);
						request.setAttribute("result", result);
					}else{
						System.out.println("N4");
						result = searchHotelService.searchNameType(address, checkin, checkout, roomNum, peoplenum, type);
						request.setAttribute("result", result);
					}
				}
			}else if(service!=null){
				if(priceleval!=0){
					System.out.println("N5");
					result = searchHotelService.searchNameServicePrice(address, checkin, checkout, roomNum, peoplenum, service, priceleval);
					request.setAttribute("result", result);
				}else{
					System.out.println("N6");
					result = searchHotelService.searchNameService(address, checkin, checkout, roomNum, peoplenum, service);
					System.out.println(result);
					request.setAttribute("result", result);
				}
			}else{
				if(priceleval!=0){
					System.out.println("N7");
					result = searchHotelService.searchNamePrice(address, checkin, checkout, roomNum, peoplenum, priceleval);
					request.setAttribute("result", result);
				}else{
					System.out.println("N8");
					result = searchHotelService.searchName(address, checkin, checkout, roomNum, peoplenum);
					request.setAttribute("result", result);
				}
			}
		}
		
		
		request.getRequestDispatcher(
				"/Hotel_list.jsp").forward(request, response);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

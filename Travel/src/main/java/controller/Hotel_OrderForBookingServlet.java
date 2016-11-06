package controller;

import java.io.IOException;
import java.sql.Date;
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
import model.Hotel_orderBean;
import model.Hotel_orderService;
import model.MemberBean;
import model.Order_detailService;
import model.Order_detailsBean;
import model.Year_roomsService;

@WebServlet("/pages/HotelServlet")
public class Hotel_OrderForBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Hotel_OrderForBookingServlet() {
    }
    private Hotel_orderService hotel_orderService;
    private Order_detailService order_detailService;
    private Year_roomsService year_roomsService;
    public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		hotel_orderService = (Hotel_orderService) context.getBean("hotel_orderService");
		order_detailService = (Order_detailService) context.getBean("order_detailsService");
		year_roomsService = (Year_roomsService) context.getBean("year_roomsService");
	}
    private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		if((MemberBean)session.getAttribute("memberBean")==null){
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
		//接收資料	
		String orderday = request.getParameter("orderday");
		MemberBean memberbean = (MemberBean) session.getAttribute("memberBean");
		String name = request.getParameter("memberName");
		String cellphone = request.getParameter("cellphone");
		String spec = request.getParameter("spec");
		String[] temp0 = request.getParameterValues("roomid");
		String[] roomname = request.getParameterValues("roomName");
		String[] temp2 = request.getParameterValues("price");
		String[] temp3 = request.getParameterValues("peoplenum");
		String[] temp4 = request.getParameterValues("roomNumbers");
		String[] temp5 = request.getParameterValues("status");
		String price_total_temp = request.getParameter("price_total");
		String order = request.getParameter("order");
		System.out.println("price_total_temp="+price_total_temp);
		//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		java.util.Date orderday1 = null;
		java.util.Date checkout = null;
		java.util.Date checkin1 = null;
		java.sql.Date day1 = null;
		java.sql.Date day2 = null;
		java.sql.Date day3 = null;
		int roomid = 0;
		int memberid = 0;
		int peoplenum = 0;
		int true_price = 0;
		int orderid = 0;
		int room_numbers = 0;
		boolean status = false;
		int price_total = 0;
		if(price_total_temp!=null && price_total_temp.trim().length()!=0){
			try {
				price_total = Integer.parseInt(price_total_temp);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("price_total", "請輸入總價");
			}
		}
		
		if(orderday!=null && orderday.trim().length()!=0){
			try {
				orderday1 = sFormat.parse(orderday);
				long time1 = orderday1.getTime();
				day1 = new java.sql.Date(time1);
			} catch (ParseException e) {
				e.printStackTrace();
				errors.put("orderday", "請輸入日期");
			}
		}
		if((String) session.getAttribute("checkin")!=null){
			try {
				checkin1 = sFormat.parse((String) session.getAttribute("checkin"));
				Long time2=checkin1.getTime();
				day2 = new Date(time2);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("checkin1", "請輸入數量");
			}
		}
			
			try {
				checkout = sFormat.parse((String)session.getAttribute("checkout"));
				Long time2=checkout.getTime();
				day3 = new Date(time2);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("checkin1", "請輸入數量");
			}
			try {
				memberid = memberbean.getMemberid();
				System.out.println("memberid="+memberid);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("memberid", "請輸入數量");
			}
		String checkout1 = sFormat.format(checkout);
		System.out.println("day1="+day1);
		System.out.println("day2="+day2);
		System.out.println("checkout="+checkout);
		System.out.println(price_total);
//		if(session.getAttribute("checkin")==null){
//			request.getRequestDispatcher(
//					"/Index.jsp").forward(request, response);		
//		}
		if("order".equals(order)){
		Hotel_orderBean bean1  = new Hotel_orderBean();
		bean1.setOrderdate(day1);
		bean1.setCheckin(day2);
		bean1.setCheckout(day3);
		bean1.setMemberid(memberid);
		bean1.setPrice_total(price_total);
		orderid = hotel_orderService.insert(bean1);
		bean1.setOrderid(orderid);
		List<Hotel_orderBean> result1 = hotel_orderService.select_ForMember(bean1);
		System.out.println(result1);
		request.setAttribute("result1", result1);
		request.setAttribute("orderid",orderid);
		}
		for(int i=0;i<roomname.length;i++){
		if(temp0!=null && temp0.length!=0) {
			try {
				roomid = Integer.parseInt(temp0[i]);
				System.out.println("roomid="+roomid);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("roomid", "請輸入數量");
			}
		}
		
		if(temp2!=null && temp2.length!=0) {
			try {
				
				true_price = Integer.parseInt(temp2[i]);
					System.out.println("true_price="+true_price);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("true_price", "請輸入數量");
			}
		}
		if(temp3!=null && temp3.length!=0) {
			try {
				peoplenum = Integer.parseInt(temp3[i]);
				System.out.println("peoplenum="+peoplenum);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("peoplenum", "請輸入數量");
			}
		}
		if(temp4!=null && temp4.length!=0) {
			try {
				room_numbers = Integer.parseInt(temp4[i]);
				System.out.println("roomNumber="+room_numbers);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("room_numbers", "請輸入數量");
			}
		}
		if(temp5!=null && temp5.length!=0) {
			try {
				status = Boolean.parseBoolean(temp5[i]);
				System.out.println("status="+status);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("status", "請輸入狀態");
			}
		}
		//驗證資料	
//		if("order".equals(order)) {
//		}
		if(errors!=null && !errors.isEmpty()) {
			System.out.println("errors="+errors);
			request.getRequestDispatcher(
					"/pages/test.jsp").forward(request, response);
			return;
		}
	
		if("order".equals(order)){
				Order_detailsBean bean2 = new Order_detailsBean();
				bean2.setOrderid(orderid);
				bean2.setRoomid(roomid);
				bean2.setName(name);
				bean2.setPrice(true_price);
				bean2.setPeoplenum(peoplenum);
				bean2.setNumber(room_numbers);
				bean2.setCellphone(cellphone);
				bean2.setSpec(spec);
				bean2.setStatus(status);
				Order_detailsBean order_detail = order_detailService.insert(bean2);
				System.out.println(order_detail);
				year_roomsService.update_subtraction(room_numbers, checkin1, checkout1, roomid);

				
			}
			
			 }
		
//		 session.removeAttribute("checkin");
		 System.out.println((String) session.getAttribute("checkin"));
//		 request.getRequestDispatcher(
//					"/order/test_Oredr.jsp").forward(request, response);
		response.sendRedirect("/Travel/order/Hotel_orderForCheckingServlet");
	}

}


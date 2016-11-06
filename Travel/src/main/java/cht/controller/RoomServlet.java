package cht.controller;

import java.io.IOException;
import java.text.ParseException;
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

import cht.model.Card;
import cht.model.Hotel;
import cht.model.HotelPhoto;
import cht.model.HotelReview;
import cht.model.HotelServiceAction;
import cht.model.ReturnHotel;
import cht.model.Service;
import model.RoomService;

@WebServlet( urlPatterns={"/room.controller"} )
public class RoomServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomService roomservice;
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		roomservice = (RoomService) context.getBean("roomService");
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession();
		//接收資料
		String temp1 = request.getParameter("checkin");
		String temp2 = request.getParameter("checkout");
		String temp3 = request.getParameter("number");
		String temp4 = request.getParameter("peoplenum");
		String temp5 = request.getParameter("hotelid");
		
		
		
//		System.out.println("roomServlet'hotelid:"+temp5);
//		System.out.println("roomservice':checkin:"+temp1);
		
		
		//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
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
		int hotelid = 0;
		if(temp5!=null && temp5.trim().length()!=0) {
			try {
				hotelid = Integer.parseInt(temp5);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("peoplenum", "peoplenum必須是整數");
			}
		}
		
		//驗證資料	
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/testindex.jsp").forward(request, response);
			return;
		}
		//呼叫Model, 根據Model執行結果顯示View
		//List<List> result = roomservice.selectRooms(hotelid, peoplenum, number, temp1, temp2);
//		Hotel hotel = roomservice.getHotel(hotelid);
//		List<Service> service = roomservice.getHotelService(hotelid);
//		List<Card> card = roomservice.getHotelCard(hotelid);
//		List<HotelPhoto> photo = roomservice.getHotelPhoto(hotelid);
//		List<HotelReview> review = roomservice.getHotelReview(hotelid);
//		request.setAttribute("hotel", hotel);
//		request.setAttribute("service", service);
//		request.setAttribute("card", card);
//		request.setAttribute("photo", photo);
//		request.setAttribute("review", review);
	
//		for(int i=0;i<result.size();i++){
//			List result1 = result.get(i);
//			System.out.println("result1"+result1);
//			request.setAttribute("rooms", result1);
//		}
		request.getRequestDispatcher(
				"/pages/test.jsp").forward(request, response);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

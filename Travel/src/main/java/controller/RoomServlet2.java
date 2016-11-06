package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import model.Hotel_orderBean;
import model.RoomBean;
import model.RoomService;

@WebServlet("/pages/RoomServlet2")
public class RoomServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoomServlet2() {
    }
    private RoomService roomService;
    public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		roomService = (RoomService) context.getBean("roomService");
	}
	
    private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收資料	
		
		String temp5 = request.getParameter("hotelid");
		String temp6 = request.getParameter("roomid");
		String roomname = request.getParameter("roomname");
		String temp8 = request.getParameter("price");
		String temp9 = request.getParameter("weekdayrate");
		String temp10 = request.getParameter("peoplenum");
		String bedtype = request.getParameter("bedtype");
		String temp12 = request.getParameter("number");
		String temp13 = request.getParameter("area");
		String temp14 = request.getParameter("status");
		String search = request.getParameter("submit_btn");
		//轉換資料
				Map<String, String> errors = new HashMap<String, String>();
				request.setAttribute("error", errors);
				
				java.util.Date checkin= null;
				int hotelid = 0;
				if(temp5!=null && temp5.trim().length()!=0) {
					try {
						hotelid = Integer.parseInt(temp5);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						errors.put("hotelid", "請輸入Hotelid");
					}
				}
				int roomid = 0;
				if(temp6!=null && temp6.trim().length()!=0) {
					try {
						roomid = Integer.parseInt(temp6);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						errors.put("roomid", "請輸入roomid");
					}
				}
				int price=0;
				if(temp8!=null && temp8.trim().length()!=0) {
					try {
						price = Integer.parseInt(temp8);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						errors.put("price", "請輸入price");
					}
				}
				int weekdayrate=0;
				if(temp9!=null && temp9.trim().length()!=0) {
					try {
						weekdayrate = Integer.parseInt(temp9);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						errors.put("weekdayrate", "請輸入weekdayrate");
					}
				}
				int peoplenum=0;
				if(temp10!=null && temp10.trim().length()!=0) {
					try {
						peoplenum = Integer.parseInt(temp10);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						errors.put("peoplenum", "請輸入peoplenum");
					}
				}
				int number=0;
				if(temp12!=null && temp12.trim().length()!=0) {
					try {
						number = Integer.parseInt(temp12);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						errors.put("number", "請輸入number");
					}
				}
				int area=0;
				if(temp13!=null && temp13.trim().length()!=0) {
					try {
						area = Integer.parseInt(temp13);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						errors.put("area", "請輸入area");
					}
				}
				boolean status=false;
				if(temp14!=null && temp14.trim().length()!=0) {
					try {
						status = Boolean.parseBoolean(temp14);
					} catch (NumberFormatException e) {
						e.printStackTrace();
						errors.put("status", "請輸入status");
					}
				}
//驗證資料	
				if("insert".equals(search)||"update".equals(search)) {
					if(hotelid==0) {
						errors.put("hotelid", "請輸入hotelid以便於執行"+search);
					}
					if(roomname==null) {
						errors.put("roomname", "請輸入roomname以便於執行"+search);
					}
					if(price==0) {
						errors.put("price", "請輸入price以便於執行"+search);
					}
					if(weekdayrate==0) {
						errors.put("weekdayrate", "請輸入weekdayrate以便於執行"+search);
					}	
					if(peoplenum==0) {
						errors.put("peoplenum", "請輸入peoplenum以便於執行"+search);
					}
					if(number==0) {
						errors.put("number", "請輸入number以便於執行"+search);
					}
					if(bedtype==null) {
						errors.put("bedtype", "請輸入bedtype以便於執行"+search);
					}
					if(area==0) {
						errors.put("area", "請輸入area以便於執行"+search);
					}
				}
				if(errors!=null && !errors.isEmpty()) {
					System.out.println(errors);
					request.getRequestDispatcher(
							"/pages/search.jsp").forward(request, response);
					return;
				}
				if("insert".equals(search)){
					RoomBean bean2 = new RoomBean();
					bean2.setHotelid(hotelid);
					bean2.setRoomname(roomname);
					bean2.setPrice(price);
					bean2.setWeekdayrate(weekdayrate);
					bean2.setPeoplenum(peoplenum);
					bean2.setBedtype(bedtype);
					bean2.setNumber(number);
					bean2.setArea(area);
					bean2.setStatus(status);
					RoomBean result = roomService.insert(bean2);
					System.out.println("result"+result);
					request.setAttribute("select", result);
					request.getRequestDispatcher(
							"/pages/ForUs.jsp").forward(request, response);
				}		
				if("update".equals(search)){
					RoomBean bean2 = new RoomBean();
					bean2.setHotelid(hotelid);
					bean2.setRoomid(roomid);
					bean2.setRoomname(roomname);
					bean2.setPrice(price);
					bean2.setWeekdayrate(weekdayrate);
					bean2.setPeoplenum(peoplenum);
					bean2.setBedtype(bedtype);
					bean2.setNumber(number);
					bean2.setArea(area);
					bean2.setStatus(status);
					RoomBean result = roomService.update(bean2);
					System.out.println("result"+result);
					request.setAttribute("select", result);
					request.getRequestDispatcher(
							"/pages/ForUs.jsp").forward(request, response);
				}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

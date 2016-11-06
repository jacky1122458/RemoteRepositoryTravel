package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

import cht.model.Collect;
import cht.model.Hotel;
import cht.model.HotelPhoto;
import cht.model.HotelServiceAction;
import cht.model.Service;
import cht.model.id.CollectId;
import model.MemberBean;
import model.RoomService;

@WebServlet("/pages/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private RoomService roomService;
    private HotelServiceAction hotelServiceAction;
    public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		roomService = (RoomService) context.getBean("roomService");
		hotelServiceAction = (HotelServiceAction)context.getBean("hotelServiceAction");
	}
	
    private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		//接收資料	
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String temp3 = request.getParameter("number");
		String temp4 = request.getParameter("adultNum");
		String temp5 = request.getParameter("hotelid");
		String search = request.getParameter("submit_btn");
		
		MemberBean memberBean = (MemberBean) session.getAttribute("memberBean");
		
		session.setAttribute("checkin",checkin);
		session.setAttribute("checkout",checkout);
		
		//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
		int roomnumber = 0;
		if(temp3!=null && temp3.trim().length()!=0) {
			try {
				roomnumber = Integer.parseInt(temp3);
				System.out.println(roomnumber);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("roomnumber", "請輸入數量");
					}
			}
		
		int adults = 0;
		if(temp4!=null && temp4.trim().length()!=0) {
			try {
				adults = Integer.parseInt(temp4);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("adults", "請輸入數量");
					}
			}
		
		int hotelid = 0;
		if(temp5!=null && temp5.trim().length()!=0) {
			try {
				hotelid = Integer.parseInt(temp5);
			} catch (NumberFormatException e) {
					e.printStackTrace();
					errors.put("hotelid", "請輸入Hotelid");
			}
		}
		
		//System.out.println("轉換後的hotelid'"+hotelid);
		
		//驗證資料
//		if("search".equals(search)) {
//			if(checkin==null) {
//				errors.put("checkin", "請輸入checkin以便於執行"+search);
//			}
//			if(checkout==null) {
//				errors.put("checkout", "請輸入checkout以便於執行"+search);
//			}
//			if(hotelid==0) {
//				errors.put("hotelid", "請輸入hotelid以便於執行"+search);
//			}
//		}
//		
//		if(errors!=null && !errors.isEmpty()) {
//			System.out.println(errors);
//			request.getRequestDispatcher("/pages/search.jsp")
//			.forward(request, response);
//			return;
//		}
		//new Hotel bean
		Hotel bean1 = new Hotel();
		bean1.setHotelid(hotelid);
		
		
		
		List<Integer> roomid = hotelServiceAction.getRoomid(hotelid);
		//System.out.println("查詢到的Roomid'"+roomid);
		
		List<List> result = roomService.selectRooms(hotelid, adults, roomnumber, checkin, checkout, roomid);
		
//		for(int i=0;i<result.size();i++){
//			List result1 = result.get(i);
			
		System.out.println("篩選到的RoomBean'"+result);
		request.setAttribute("select1", result);
		
//		}
		
		
		//Hotel-------------------------------
		Hotel hotelbean = hotelServiceAction.getHotel(hotelid);
		session.setAttribute("hotelbean", hotelbean);
		
		//photo
		List<HotelPhoto> hotelphoto = hotelServiceAction.getHotelPhoto(hotelid);
		request.setAttribute("hotelphoto", hotelphoto);
		//System.out.println("得到的PHOTOBEAN'"+hotelphoto);
		
		//評價平均數
		Map<String, Object> avg = (Map<String, Object>) hotelServiceAction.getReviewAvg(hotelid);
		request.setAttribute("avg", avg);
		//System.out.println("得到的avg'cleanliness:"+avg.get("cleanliness"));
		
		
		
		//service
		List<Service> hotelService = hotelServiceAction.getHotelService(hotelid);
		if(hotelService!= null){
			
			List<Service> complexFacilities = new ArrayList<>();
			List<Service> complexService = new ArrayList<>();
			List<Service> BusinessFacilities = new ArrayList<>();
			List<Service> carpark = new ArrayList<>();
			List<Service> pet = new ArrayList<>();
			List<Service> clearService = new ArrayList<>();
			
			for(Service service : hotelService){
				switch(service.getServicename()){
				case "攜帶寵物":
					pet.add(service);
					break;
				case "停車場":
					carpark.add(service);
					break;
				case "含早餐":
				case "客房服務":
				case "櫃台24小時接待":
				case "不需訂金":
				case "訂房免費取消":
				case "行李寄存":
				case "外幣兌換":
					complexService.add(service);
					break;
				case "機場接駁車":
				case "無障礙設施":
				case "健身中心":
				case "游泳池":
				case "SPA":
				case "家庭房":
				case "吸菸區":
				case "全面禁菸":
					complexFacilities.add(service);
					break;
				case "洗衣":
				case "每日清潔服務":
				case "熨斗":
					clearService.add(service);
					break;
				case "免費無線網路":
				case "傳真/覆印":
				case "會議/宴會":
				case "可加床":
					BusinessFacilities.add(service);
					break;
					
				}
			}
			
			Map<Object, Object> service = new HashMap<>();
			service.put("complexFacilities", complexFacilities);
			service.put("clearService", clearService);
			service.put("BusinessFacilities", BusinessFacilities);
			service.put("complexService", complexService);
			service.put("carpark", carpark);
			service.put("pet", pet);
			request.setAttribute("service", service);
			
			
		}
		request.setAttribute("hotelService", hotelService);
		//System.out.println("得到的hotelService'"+hotelService);
		
		request.getRequestDispatcher(
				"/pages/hotel_room_detail.jsp").forward(request, response);
						
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

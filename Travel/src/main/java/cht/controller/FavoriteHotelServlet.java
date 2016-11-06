package cht.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cht.model.CollectService;
import cht.model.Hotel;
import cht.model.HotelServiceAction;
import cht.model.dao.CollectDAOHibernate;
import cht.model.id.CollectId;
import model.MemberBean;
import model.RoomService;
@WebServlet("/favoriteHotel.controller")
public class FavoriteHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CollectService collectService;
	public FavoriteHotelServlet(CollectService collectService){
		this.collectService = collectService;
	}
	
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		collectService = (CollectService) context.getBean("collectService");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		MemberBean memberBean = (MemberBean) session.getAttribute("memberBean");
		Hotel hotel = (Hotel) request.getAttribute("hotelbean");
		
		//new CollectId bean
		CollectId collectid =null;
		if(memberBean != null){
			collectid = new CollectId();
			collectid.setHotelid(hotel.getHotelid());
			collectid.setMemberid(memberBean.getMemberid());
		}
		
		//加入收藏
		boolean favoriteHotel = collectService.insertFavoriteHotel(collectid);
		request.setAttribute("favoriteHotel", favoriteHotel);
		
		request.getRequestDispatcher(
				"/pages/hotel_room_detail.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}

package cht.model.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cht.model.Hotel;
import cht.model.dao.HotelDAOHibernate;

@WebServlet("/testHotel.controller")
public class testHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HotelDAOHibernate hotelDAO;
	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		hotelDAO = (HotelDAOHibernate) context.getBean("hotelDAO");

	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Hotel> hotels = hotelDAO.select();
		request.setAttribute("hotels", hotels);
		request.getRequestDispatcher(
				"/chtpages/testHotels.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

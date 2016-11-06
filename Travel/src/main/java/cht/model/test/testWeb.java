package cht.model.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cht.model.Hotel;
import cht.model.ReturnHotel;
import cht.model.dao.HotelDAOHibernate;
import cht.model.dao.ReturnHotelDAOHibernate;
import cht.model.misc.HibernateUtil;
import model.Hotel_orderBean;
import model.MemberBean;
@WebServlet( urlPatterns={"/testWeb.view"} )
public class testWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReturnHotelDAOHibernate returnhotelDao;
	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		returnhotelDao = (ReturnHotelDAOHibernate) context.getBean("returnhotelDao");
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String method = request.getMethod();
		System.out.println("method="+method+", "+request.getRequestURI());
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
//		Hotel hotel = hotelDao.selectById(1);
//		out.println("Hotel:"+hotel);
//		MemberBean memberbean = hotelDao.getSession().get(MemberBean.class, 3);
//		out.println(memberbean);
//		out.println(memberbean.getOrderbeans());
		//Hotel_orderBean orderBean = returnhotelDao.getSession().get(Hotel_orderBean.class, 1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date first = null;
		java.util.Date last = null;
		try {
			first = (java.util.Date) sdf.parse("2016/10/10");
			last = (java.util.Date) sdf.parse("2016/10/10");
		} catch (ParseException e) { e.printStackTrace(); }
		
		List<ReturnHotel> bean = (List<ReturnHotel>) returnhotelDao.selectByAddress("高雄", 1, 1, first, last);
		Hotel hotel = returnhotelDao.getSession().get(Hotel.class, 4);
		
		out.println(bean);
		out.println(hotel.getDescription());
		out.close();
		
	}


}

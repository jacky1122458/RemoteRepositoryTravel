package cht.model.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cht.model.Hotel;
import cht.model.HotelPhoto;
import cht.model.dao.HotelDAOHibernate;
import javassist.bytecode.Descriptor.Iterator;

@WebServlet(urlPatterns={"/testPhoto.view"} )
public class testPhotoServlet extends HttpServlet {
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

		// 接收資料
		String temp1 = request.getParameter("hotelid");
		System.out.println(temp1);
		// 轉換資料
		int hotelid = 0;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
				hotelid = Integer.parseInt(temp1);
			} catch (NumberFormatException e) { e.printStackTrace(); }
		}
		System.out.println(hotelid);
		// 查詢資料
		Set<HotelPhoto> photoSet = hotelDAO.getHotelphoto(hotelid);
		List<HotelPhoto> result = new ArrayList();
		for(HotelPhoto bean:photoSet){
			result.add(bean);
		}
		request.setAttribute("photos", result);
		System.out.println(result);
		request.getRequestDispatcher(
				"/chtpages/testPhoto.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

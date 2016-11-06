package cht.model.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cht.model.HotelPhoto;
import cht.model.dao.HotelPhotoDAOHibernate;

@WebServlet(urlPatterns={"/testInsertphoto.view"} )
public class testInsertPhoto  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HotelPhotoDAOHibernate hotelphotoDAO;
	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		hotelphotoDAO = (HotelPhotoDAOHibernate) context.getBean("hotelphotoDAO");

	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 接收資料
		String temp1 = request.getParameter("hotelid");
		String description = request.getParameter("description");
		
		// 轉換資料
		int hotelid = 0;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
				hotelid = Integer.parseInt(temp1);
				} catch (NumberFormatException e) { e.printStackTrace(); }
		}
		
		HotelPhoto bean = new HotelPhoto();
		bean.setHotelid(hotelid);
		bean.setDescription(description);
		
		// 查詢資料
		HotelPhoto result = hotelphotoDAO.insert(bean);
		System.out.println(result);
		
		request.getRequestDispatcher(
				"/chtpages/testInsertPhoto.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}

package cht.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cht.model.HotelPhoto;
import cht.model.dao.HotelPhotoDAOHibernate;

@WebServlet(urlPatterns={"/PhotoDescript.show"} )
public class PhotoDescription  extends HttpServlet{
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

		
		ServletOutputStream out = null;
		// 接收資料
		String descript = request.getParameter("descript");
		String temp1 = request.getParameter("hotelid");
		
		// 轉換資料
		int hotelid = 0;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
				hotelid = Integer.parseInt(temp1);
				} catch (NumberFormatException e) { e.printStackTrace(); }
		}
		
		// 查詢資料
		HotelPhoto photo =null;
		photo = hotelphotoDAO.select(hotelid, descript);
		if(photo==null){
			photo = hotelphotoDAO.getOnePhoto(hotelid);
		}
		byte[] img =null;
		if(photo!=null){
			img = photo.getPhoto();
			response.setContentType("image/jpeg");
			out = response.getOutputStream();
			try{
				out.write(img);
			}catch (IOException e){ e.printStackTrace(); }
		}
		System.out.println("testPhoto");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

package jj.Photo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jj.model.Attractions_imgBean;
import jj.model.dao.Attractions_imgDAOHibernate;
import jj.model.service.AttractionsMangementService;

@WebServlet(urlPatterns={"/PhotoId.show"} )
public class PhotoIdServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AttractionsMangementService attractions_img_service;
	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		 attractions_img_service = (AttractionsMangementService) context.getBean("attractionsMangementService3");

	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ServletOutputStream out = null;
		
		// 接收資料
		String temp1 = request.getParameter("hotelphotoid");
		System.out.println(temp1);
		
		// 轉換資料
		int photoId = 0;
		if(temp1!=null && temp1.trim().length()!=0) {
			try {
				photoId = Integer.parseInt(temp1);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					}
		}
	
		
		// 查詢資料
		Attractions_imgBean photo= attractions_img_service.select_photo(photoId);
		byte[] img = photo.getAttractions_img();
		response.setContentType("image/jpeg");
		out = response.getOutputStream();
		try{
			out.write(img);
		}catch (IOException e){ e.printStackTrace(); }
		
		System.out.println(img+"imgimgimg");
		System.out.println(out+"out");
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

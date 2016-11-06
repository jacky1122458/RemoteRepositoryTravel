package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.RoomPhotoBean;
import model.dao.RoomPhotoDAOHibernate;


@WebServlet("/pages/ShowRoomPhotoSerlver")
public class ShowRoomPhotoSerlver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowRoomPhotoSerlver() {
  
    }
    private RoomPhotoDAOHibernate roomPhotoDAO;

   	@Override
   	public void init() throws ServletException {
   		ApplicationContext context = 
   				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
   		roomPhotoDAO = (RoomPhotoDAOHibernate) context.getBean("roomPhotoDAO");
   	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream output = null;
		String temp1 = request.getParameter("roomPhotoId");
		System.out.println("roomPhotoId="+temp1);
		int roomPhotoId = 0;
		if(temp1!=null && temp1.trim().length()!=0 ){
			try {
				roomPhotoId = Integer.parseInt(temp1);
			} catch (NumberFormatException e) {
				
			}
		}
//		RoomPhotoBean bean = roomPhotoDAO.selectTruePhoto(roomPhotoId);
//		byte[] photo = bean.getPhoto();
//		response.setContentType("image/jpeg");
//		output = response.getOutputStream();
//		try {
//			output.write(photo);
//		} catch (Exception e) {
//			
//		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}

package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.RoomPhotoBean;
import model.RoomService;
import model.dao.RoomPhotoDAOHibernate;
@WebServlet("/pages/photo.view")

public class PhotoServlet extends HttpServlet {
	 private RoomPhotoDAOHibernate roomPhotoDAO;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		roomPhotoDAO = (RoomPhotoDAOHibernate) context.getBean("roomPhotoDAO");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String temp1 = request.getParameter("roomid");
		int roomid = 0 ;
		if(temp1!=null && temp1.trim().length()!=0){
			roomid = Integer.parseInt(temp1);
		}
//		List<RoomPhotoBean> bean = roomPhotoDAO.select(roomid);
//		request.setAttribute("bean", bean);
//		System.out.println(bean);
//		request.getRequestDispatcher("/pages/roomphoto.jsp").forward(request, response);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

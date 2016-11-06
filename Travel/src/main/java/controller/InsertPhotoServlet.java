package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.RoomBean;
import model.RoomService;
import model.dao.RoomPhotoDAOHibernate;

@WebServlet("/InsertPhotoServlet")
public class InsertPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private RoomPhotoDAOHibernate roomPhotoDAO;
	 public void init() throws ServletException {
			ApplicationContext context = 
					WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			roomPhotoDAO = (RoomPhotoDAOHibernate) context.getBean("roomPhotoDAO");
		}

    public InsertPhotoServlet() {       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收資料
		String temp1 = request.getParameter("roomid");
		String[] photoPath = request.getParameterValues("photoPath");
		String insert = request.getParameter("submit_btn");
		System.out.println(photoPath);
		//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		int roomid=0;
		if(temp1!=null && temp1.trim().length()!=0){
			try {
				roomid = Integer.parseInt(temp1);
				System.out.println(roomid);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("roomid", "請輸入房間編號");
			}
		}
		//驗證資料
		if("insert".equals(insert)) {
			if(roomid==0) {
				errors.put("roomid", "請輸入roomid以便於執行"+insert);
			}	
		}
		if(errors!=null && !errors.isEmpty()) {
			System.out.println(errors);
			request.getRequestDispatcher(
					"/pages/search.jsp").forward(request, response);
			return;
		}
		if("insert".equals(insert)){
			for(int i=0;i<photoPath.length;i++){
				try {
					roomPhotoDAO.insert(roomid, photoPath);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//				request.getRequestDispatcher(
//						"/pages/test.jsp").forward(request, response);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

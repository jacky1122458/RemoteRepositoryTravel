package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.MemberBean;
import model.dao.Hotel_orderBeanDAOHibernate;
import model.dao.Order_detailsDAOHibernate;
import model.dao.Year_roomsDAOHibernate;


@WebServlet("/order/UpateOrderDateServlet")
public class UpateOrderDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Hotel_orderBeanDAOHibernate dao1;
	private Order_detailsDAOHibernate dao2;
	private Year_roomsDAOHibernate dao3;
    public UpateOrderDateServlet() {
    }
    public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		dao1 = (Hotel_orderBeanDAOHibernate) context.getBean("hotel_orderBeanDAO");
		dao2 = (Order_detailsDAOHibernate) context.getBean("order_detailsDAO");
		dao3 = (Year_roomsDAOHibernate) context.getBean("year_roomsDAO");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String temp1 = request.getParameter("orderid");
		System.out.println(checkin);
		System.out.println(checkout);
		System.out.println(temp1);
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		MemberBean bean1 = (MemberBean)session.getAttribute("memberBean");
		if((MemberBean)session.getAttribute("memberBean")==null){
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		int orderid =0;
		if(temp1!=null && temp1.trim().length()!=0){
			orderid = Integer.parseInt(temp1);
		}
		java.util.Date checkinday = null;
		if(checkin!=null && checkin.trim().length()!=0){
			try {
				checkinday = sdf.parse(checkin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		java.util.Date checkoutday = null;
		if(checkout!=null && checkout.trim().length()!=0){
			try {
				checkoutday = sdf.parse(checkout);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<Integer> roomid = dao1.selectRoomid(orderid);
		Date checkinday1 = dao1.select_checkin(orderid);
		System.out.println(checkinday);
		Date checkoutday1 = dao1.select_checkout(orderid);
		String checkout2=sdf.format(checkoutday1);
		System.out.println(checkoutday);
		int number = dao1.update(orderid, checkinday, checkoutday);
		if(number!=0){
		for(int i=0;i<roomid.size();i++){
			dao3.update_add(orderid, roomid.get(i), checkinday1, checkout2);
		}		
		int aa=0;
		System.out.println(number+"這這");
		
			aa=dao2.update(orderid, checkin, checkout);
		
		if(aa!=0){	
			System.out.println("這"+aa);
			for(int i=0;i<roomid.size();i++){
				List<Integer> numbers = dao2.selectRoomNumbers(orderid, roomid.get(i));
				//System.out.println("numbers"+numbers.get(i));
				dao3.update_subtraction(numbers.get(0), checkinday, checkout, roomid.get(i));
			}
		}
		}
		request.getRequestDispatcher("/order/Hotel_orderForCheckingServlet").forward(request, response);
 	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doGet(request, response);
	}

}
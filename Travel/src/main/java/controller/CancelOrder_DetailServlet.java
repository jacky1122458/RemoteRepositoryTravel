package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

import model.Order_detailService;
import model.Order_detailsBean;
import model.Year_roomsService;

@WebServlet("/order/CancelOrder_DetailServlet")
public class CancelOrder_DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
    public CancelOrder_DetailServlet() {
    }
    private Order_detailService order_detailService;
    private Year_roomsService year_roomsService;
    public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		order_detailService = (Order_detailService) context.getBean("order_detailsService");
		year_roomsService = (Year_roomsService) context.getBean("year_roomsService");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp1 = request.getParameter("orderid");
		String temp2 = request.getParameter("status");
		String[] temp3 = request.getParameterValues("roomid");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String cancel = request.getParameter("cancel");
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
		int orderid = 0;
		if(temp1!=null && temp1.trim().length()!=0){
			try {
				orderid = Integer.parseInt(temp1);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("orderid", "請輸入數字");
			}
		}
		java.util.Date checkin1 =null;
		if(checkin!=null && checkin.trim().length()!=0){
			try {
				checkin1 = sFormat.parse(checkin);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("orderid", "請輸入數字");
			}
		}
		java.util.Date checkout1 =null;
		if(checkout!=null && checkout.trim().length()!=0){
			try {
				checkout1 = sFormat.parse(checkout);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("orderid", "請輸入數字");
			}
		}
		boolean status = false;
		if(temp2!=null){
			try {
				status = Boolean.parseBoolean(temp2);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("status", "請輸入數字");
			}
		}
		int roomid =0;
		for(int i =0;i<temp3.length;i++){
			if(temp3!=null && checkin.trim().length()!=0){
				try {
					roomid = Integer.parseInt(temp3[i]);
				} catch (Exception e) {
					e.printStackTrace();
					errors.put("roomid", "請輸入數字");
				}
			}
		
		System.out.println(roomid);
	
		Order_detailsBean bean = new Order_detailsBean();
		bean.setOrderid(orderid);
		bean.setRoomid(roomid);
		bean.setStatus(status);
		int result = order_detailService.cancel_order(bean);
		year_roomsService.update_add(bean, checkin1, checkout);
		System.out.println("result="+result);
		}
		response.sendRedirect("/Travel/order/Hotel_orderForCheckingServlet");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

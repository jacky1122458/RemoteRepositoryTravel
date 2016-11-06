package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@WebServlet("/order/Order_detilCheckingServlet")
public class Order_detilCheckingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
    public Order_detilCheckingServlet() {
    }
    private Order_detailService order_detailService;
    public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		order_detailService = (Order_detailService) context.getBean("order_detailsService");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp1 = request.getParameter("orderid");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
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
	
		
		Order_detailsBean bean = new Order_detailsBean();
		bean.setOrderid(orderid);
		List<List> result = order_detailService.select(bean);
		System.out.println("result="+result);
		request.setAttribute("checkin",checkin);
		request.setAttribute("checkout", checkout);
		request.setAttribute("result", result);
		request.setAttribute("orderid",orderid);
		request.getRequestDispatcher(
				"/order/true_order_detail2.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

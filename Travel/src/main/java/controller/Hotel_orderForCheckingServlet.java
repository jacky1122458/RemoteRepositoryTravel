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
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import model.Hotel_orderBean;
import model.Hotel_orderService;
import model.MemberBean;


@WebServlet("/order/Hotel_orderForCheckingServlet")
public class Hotel_orderForCheckingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Hotel_orderService hotel_orderService;
    public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		hotel_orderService = (Hotel_orderService) context.getBean("hotel_orderService");
	}
    public Hotel_orderForCheckingServlet() {
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		MemberBean bean1 = (MemberBean)session.getAttribute("memberBean");
		if((MemberBean)session.getAttribute("memberBean")==null){
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
			Hotel_orderBean bean = new Hotel_orderBean();
			bean.setMemberid(bean1.getMemberid());
			 List<List> result = hotel_orderService.select_ForMemberByMemberid(bean);
				System.out.println("result="+result);	
			 		for(int i=0;i<result.size();i++){
						List result1 = result.get(i);
						System.out.println("result1"+result1);
						request.setAttribute("result", result1);
						
					}
					request.getRequestDispatcher(
							"/order/true_order.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

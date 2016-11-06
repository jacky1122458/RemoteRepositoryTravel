package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;

@WebServlet("/order/ShowRoomsToOrderSerlet")
public class ShowRoomsToOrderSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShowRoomsToOrderSerlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String[] roomid = request.getParameterValues("roomid");
		String[] roomName = request.getParameterValues("roomname");
		String[] price = request.getParameterValues("price");
		String[] peoplenum = request.getParameterValues("peoplenum");
		String[] roomNumber = request.getParameterValues("selector");
		String[] status = request.getParameterValues("status");
		request.setCharacterEncoding("UTF-8");
		if((MemberBean)session.getAttribute("memberBean")==null){
			response.sendRedirect("/Travel/client/login.jsp");
			return;
		}
		System.out.println(roomid[0]);
		List roomBean = null;		
		List roomBean_toNext =new ArrayList();
		int a=0;
		for(int i=0;i<roomNumber.length;i++){
			a=a+Integer.parseInt(roomNumber[i]);
		}
		if(a==0){
			request.getRequestDispatcher("/Index.jsp").forward(request, response);
			return;
		}
		
		
		int temp_price = 0;
		int price_total = 0;
		for(int i=0;i<roomNumber.length;i++){
			if(Integer.parseInt(roomNumber[i])!=0){
				roomBean =new ArrayList();
					temp_price=Integer.parseInt(price[i])*Integer.parseInt(roomNumber[i]);
					price_total = price_total + temp_price;
					roomBean.add(roomid[i]);
					roomBean.add(roomName[i]);
					System.out.println(roomName[i]);
					roomBean.add(temp_price);
					roomBean.add(peoplenum[i]);
					roomBean.add(roomNumber[i]);
					roomBean.add(status[i]);
				roomBean_toNext.add(roomBean);
			}
		}
		System.out.println(price_total);
		System.out.println("roomBean_toNext="+roomBean_toNext);
		request.setAttribute("roomBean", roomBean_toNext);
		request.setAttribute("price_total", price_total);
		request.getRequestDispatcher("/order/ShowOrder.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

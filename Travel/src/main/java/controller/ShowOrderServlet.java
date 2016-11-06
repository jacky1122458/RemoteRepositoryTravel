package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowOrderServlet() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] temp0 = request.getParameterValues("roomid");
		String[] roomname = request.getParameterValues("roomname");
		String[] temp2 = request.getParameterValues("price");
		String[] temp3 = request.getParameterValues("peoplenum");
		String[] temp4 = request.getParameterValues("room_numbers");
		String[] temp5 = request.getParameterValues("status");
		String order = request.getParameter("order");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doGet(request, response);
	}

}

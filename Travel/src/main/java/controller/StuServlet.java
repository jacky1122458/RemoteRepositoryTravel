package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.support.WebApplicationContextUtils;

import model.MemberBean;
import model.MemberService;
import model.MemberBean;
import model.MemberService;

/**
 * Servlet implementation class StuServlet
 */
@WebServlet(urlPatterns="/client/stu.controller")
public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService;
	
	public void init() throws ServletException{
		memberService=(MemberService)WebApplicationContextUtils.getWebApplicationContext(this.getServletContext()).getBean("memberService");
	
	}  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Map<String, String> stuerrors = new HashMap<String, String>();
		String	stu=(String)session.getAttribute("stu");
		MemberBean bean=(MemberBean)session.getAttribute("stubean");
		System.out.println("bean"+bean);
		if(bean!=null)
        {
			int id=bean.getMemberid();
			String s=request.getParameter("stu");
			session.setAttribute("s", s);
	//		System.out.println("1"+stu);
	//		System.out.println("2"+s);
			if(stu.equals(s)){
				System.out.println("驗證成功");
				memberService.update(bean.getStatus(), id);
	
				response.sendRedirect("/Travel/client/sucess.jsp");

		}
		}else{
			System.out.println("驗證失敗");
			request.getRequestDispatcher(
					"/client/stu.jsp").forward(request, response);
			return;
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

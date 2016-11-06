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

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.MemberBean;
import model.MemberService;
import model.SignInService;
import mosel.util.GmailSendMailviaTLS;



@WebServlet("/client/ForgetServlet")
public class ForgetServlet extends HttpServlet {
	private MemberService memberService;
	
	 @Override
		public void init() throws ServletException {
			ApplicationContext context = 
					WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			memberService = (MemberService) context.getBean("memberService");
			
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Map<String,String> forgets=new HashMap<String,String>();
		request.setAttribute("forget", forgets);
		String account=request.getParameter("account");
		String email=request.getParameter("email");
		String temp=""+(int)((Math.random()+1)*10000);
		
		
		if(account==null || account.length()==0) {
			forgets.put("account", "請輸入帳號");
		}
		if(email==null || email.length()==0) {
			forgets.put("email", "請輸入信箱");
		}
		if(forgets!=null&&!forgets.isEmpty()){
			request.getRequestDispatcher("/client/forget.jsp").forward(request, response);
			return;
		}

		MemberBean bean=memberService.selectAccount(account);
		
		if(bean==null){
			forgets.put("nobean", "無此帳號");
			request.getRequestDispatcher("/client/forget.jsp").forward(request, response);
			return;
		}else{
		if(!(bean.getEmail().equals(email))){
			forgets.put("email","信箱不對" );
			request.getRequestDispatcher("/client/forget.jsp").forward(request, response);
			return;
			}
		if(forgets!=null&&!forgets.isEmpty()){
			request.getRequestDispatcher("/client/forget.jsp").forward(request, response);
			return;
		}else{
			bean.setPassword(temp.getBytes());
			String password =new String(bean.getPassword()) ;
			String toEmailAddress=email;
			String subject="你好"+account;
			String contnet="您的密碼:"+password+"請重新登入:"+request.getScheme()+":/"+request.getServerName()+":"+request.getServerPort()+"/"+request.getContextPath()+"/client/login.jsp";
			
			GmailSendMailviaTLS.sendEmail(toEmailAddress,subject,contnet);
			session.setAttribute("forgetok", password);
			request.getRequestDispatcher(
					"/client/forgetok.jsp").forward(request, response);
		}
		}
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

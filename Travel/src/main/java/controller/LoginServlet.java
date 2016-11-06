package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import model.MemberBean;
import model.MemberService;
import model.SignInBean;
import model.SignInService;
@WebServlet(urlPatterns="/client/login.controller")
//@WebServlet( urlPatterns={"/login.controller"} )
public class LoginServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService;
	private SignInService signService;
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		memberService = (MemberService) context.getBean("memberService");
		signService = (SignInService) context.getBean("signinService");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String rm = request.getParameter("rememberMe");
		
		String checkCode = request.getParameter("checkCode");
        String compareCheckCode = request.getSession().getAttribute("randomString") == null ? "" :(String) request.getSession().getAttribute("randomString");
 
		
		Map<String,String> errors=new HashMap<String,String>();
		request.setAttribute("errors", errors);
		if(account==null || account.length()==0) {
			errors.put("account", "請 輸 入 正 確 帳 號");
		}
		if(password==null || password.length()==0) {
			errors.put("password", "請 輸 入 正 確 密 碼");
		}
		
		//檢核驗證碼
        if(checkCode== null || !compareCheckCode.equals(checkCode) ){
                    if(!"111".equals(checkCode)){//方便登入,開發者只需輸入111,則驗證碼可過
                        errors.put("CheckCodeEmptyError", "驗證碼錯誤或未輸入");
                    }
                }
        
		if(errors!=null&&!errors.isEmpty()){
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
		
//		//**********Remember Me**************************** 
		Cookie cookieUser = null;
		Cookie cookiePassword = null;
		Cookie cookieRememberMe = null;
		
		if (rm != null) {   // rm存放瀏覽器送來之RememberMe的選項
			
			cookieUser = new Cookie("account", account);
			cookieUser.setMaxAge(30*60*60);
			cookieUser.setPath(request.getContextPath());
		
			// 稍微編碼(不算是加密)
			String encodePassword = DatatypeConverter.printBase64Binary(password.getBytes());
			cookiePassword = new Cookie("password", encodePassword);
			cookiePassword.setMaxAge(30*60*60);
			cookiePassword.setPath(request.getContextPath());
			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(30*60*60);
			cookieRememberMe.setPath(request.getContextPath());
		
		} else {
			
			cookieUser = new Cookie("account", account);
			cookieUser.setMaxAge(0);   // MaxAge==0 表示要請瀏覽器刪除此Cookie
			cookieUser.setPath(request.getContextPath());
			String encodePassword = DatatypeConverter.printBase64Binary(password.getBytes());
			cookiePassword = new Cookie("password", encodePassword);
			cookiePassword.setMaxAge(0);
			cookiePassword.setPath(request.getContextPath());
			cookieRememberMe = new Cookie("rm", "false");
			cookieRememberMe.setMaxAge(30*60*60);
			cookieRememberMe.setPath(request.getContextPath());
			
		}
		
		response.addCookie(cookieUser);
		response.addCookie(cookiePassword);
		response.addCookie(cookieRememberMe);
		
		
		//--------------------------------------------------
		MemberBean bean = memberService.login(account, password);
		
		if(bean==null){
			errors.put("nostu", "帳號或密碼錯誤");
			}else{
	        if(bean.getStatus()==false){
	            
	            errors.put("nostu","資料尚未驗證" );
	            }}
	        if(errors!=null&&!errors.isEmpty()){
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
			
		}else{
			SignInBean sb = signService.select(bean.getMemberid());
			if(sb==null){
			sb=new SignInBean();
			sb.setMemberid(bean.getMemberid());
			sb.setSigndate(new java.util.Date());
			signService.insertToLog(sb);
			
			}else{
				signService.updateToLog(bean.getMemberid(), new java.util.Date());
				
			}
			
			
			HttpSession session=request.getSession();
			
            String userpassword = new String(bean.getPassword());
            
            session.setAttribute("memberBean",bean);
            session.setAttribute("userpassword",userpassword);
            session.setAttribute("sessionid", session.getId());
            String path=request.getContextPath();
            System.out.println(path);
            response.sendRedirect(path+"/Index.jsp");
			
		}
		
		
//		List<Map> EvaHotelbeans = 
//				memberService.checkEvaluation(bean);
//		request.setAttribute("EvaHotelHotel", EvaHotelbeans);
		
//		request.getRequestDispatcher(
//				"/chtpages/testIndex.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

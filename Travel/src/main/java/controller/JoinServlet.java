package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import mosel.util.GmailSendMailviaTLS;

@WebServlet("/client/join.controller")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService;
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	@Override
	public void init() throws ServletException {
	ApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	memberService = (MemberService) context.getBean("memberService");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errors = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> oks = new HashMap<String, String>();
        // 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
        request.setAttribute("error", errors);  //顯示錯誤訊息
        session.setAttribute("ok", oks);      //顯示正常訊息
        
        ////接收資料
        String temp0 = request.getParameter("id");
    	String account = request.getParameter("account");
    	String temp1=request.getParameter("password");
    	String lastname=request.getParameter("lastname");
    	String firstname=request.getParameter("firstname");
    	String sex=request.getParameter("sex");
    	String email=request.getParameter("email");
    	String temp2=request.getParameter("birth");
    	String cellphone=request.getParameter("cellphone");
    	String address=request.getParameter("address");
    	String prodaction = request.getParameter("prodaction");
    	
    	//轉換資料
    	int memberid = 0;
    	if(temp0!=null && temp0.trim().length()!=0) {
    		try {
    			memberid = Integer.parseInt(temp0);
    			
    		} catch (NumberFormatException e) { 
    			e.printStackTrace();
    			errors.put("id", "Id必須是整數");
    			}
    	}
    	
    	byte[] password = null ;
    	if(temp1!=null && temp1.trim().length()!=0 ) {
    		
    		try {
    			password = temp1.getBytes();
    			} catch (NumberFormatException e) {
    				e.printStackTrace();
    				errors.put("password", "密碼輸入錯誤");
    				}
    		}else{
    			errors.put("password", "密碼需輸入");
    			
    		}
    	
    	java.util.Date birth = null;
    	if(temp2!=null && temp2.trim().length()!=0) {
    		
    		try {
    			birth = sFormat.parse(temp2);
    			
    		} catch (ParseException e) {
    			e.printStackTrace();
    			errors.put("birth", "生日格式必須是日期:yyyy-MM-dd");
    			
    		}
    		
    	}else{ errors.put("birth", "生日需輸入"); }
    	String e = "/^[a-zA-Z_0-9-]+(\\.[a-zA-Z_0-9-]+)*@ [a-zA-Z_0-9-]+(\\.[a-zA-Z_0-9-]+)+$/";
    	String c = "/^09[0-9]{8}$/";
    	//驗證資料	
    	if("送出表單".equals(prodaction) ) {
    		if(account.length()==0||account=="") {
    			errors.put("account", "帳號為必填");	
    		}
    		if(lastname.length()==0||lastname=="") {
    			errors.put("lastname", "此欄為必填");
    		}
    		if(firstname.length()==0||firstname=="") {
    			errors.put("firstname", "此欄為必填");
    		}
    		if(email.length()==0||email=="") {
    			errors.put("email", "此欄為必填");
    		}else if(email.matches(e)){
                errors.put("email", "此欄為必填且必須為真正，啟動會員需驗證");
            }
            
            if(cellphone.length()==0||cellphone=="") {
                errors.put("cellphone", "此欄為必填");
            }else if(cellphone.matches(c)){
                errors.put("cellphone", "此欄為必填");
            }
            if(address.length()==0||address=="") {
                errors.put("address", "此欄為必填");
            }
        }
    	
    	if(memberService.selectEmail(email)!=null){
    		errors.put("email", "此信箱已註冊過");
    	}
    	if(memberService.selectAccount(account)!=null){
    		errors.put("account", "此帳號已被註冊");
    	}
    	
    	if(errors!=null && !errors.isEmpty()) {
    		request.getRequestDispatcher("/client/join.jsp").forward(request, response);
    		return;
    	}
    	
    	//呼叫Model, 根據Model執行結果顯示View
    	MemberBean bean = new MemberBean();
    	bean.setMemberid(memberid);
    	bean.setAccount(account);
    	bean.setPassword(password);
    	bean.setLastname(lastname);
    	bean.setFirstname(firstname);
    	bean.setSex(sex);
    	bean.setEmail(email);
    	bean.setBirth(birth);
    	bean.setCellphone(cellphone);
    	bean.setAddress(address);
    	
    	if("送出表單".equals(prodaction)) {
    		MemberBean result = memberService.join(bean);
    		if(result==null) {
    			errors.put("action", "新增資料失敗");
    			request.getRequestDispatcher(
    					"/client/join.jsp").forward(request, response);
    			
    		} else {
    			session.setAttribute("join", result);
    			session.setAttribute("stubean", result);
                String s=""+(int)(Math.random()*10000);
                System.out.println(s);
                
                String toEmailAddress=email;
                String subject="你好"+account;
                String contnet="您的認證碼:"+s+"點擊:"+request.getScheme()+":/"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/client/stu.jsp;jsessionid="+session.getId();
            
                session.setAttribute("stu", s);
                GmailSendMailviaTLS.sendEmail(toEmailAddress,subject,contnet);
//                request.getRequestDispatcher(
//                        "/Index.jsp").forward(request, response);
                response.sendRedirect("/Travel/client/login.jsp");
    			}
    	}
    	
	}
}

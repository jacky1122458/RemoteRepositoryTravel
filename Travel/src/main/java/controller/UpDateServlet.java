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

import org.springframework.web.context.support.WebApplicationContextUtils;

import model.MemberBean;
import model.MemberService;

@WebServlet("/client/update.controller")
public class UpDateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private MemberService service;
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");

	public void init() throws ServletException{
		service=(MemberService)WebApplicationContextUtils.getWebApplicationContext(this.getServletContext()).getBean("memberService");
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Map<String,String> merrors=new HashMap<String, String>();
		
		HttpSession session=request.getSession();
		request.setAttribute("merror", merrors);
		
		//接收資料
		String temp0 = request.getParameter("memberid");
		String temp=request.getParameter("password");
		String email=request.getParameter("email");
		String cellphone=request.getParameter("cellphone");
		String address=request.getParameter("address");
		String prodaction = request.getParameter("prodaction");
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		//轉換資料
		int memberid = 0;
		if(temp0!=null && temp0.trim().length()!=0) {
			try {
				memberid = Integer.parseInt(temp0);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				merrors.put("id", "Id必須是整數");
			}
		}
		byte[] password = null ;
        if(temp!=null && temp.trim().length()!=0 ) {
            try {
                password = temp.getBytes();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                merrors.put("password", "密碼錯誤");
            }
 
        }else{
            merrors.put("password", "password不得為空");
        }
		
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		//驗證資料	

        if(email.length()==0||email=="") {
            merrors.put("email", "請輸入email以便於執行"+prodaction);
        }
    
        
        if(cellphone.length()==0||cellphone=="") {
            merrors.put("cellphone", "請輸入cellphone以便於執行"+prodaction);
        }
        if(address.length()==0||address=="") {
            merrors.put("address", "請輸入address以便於執行"+prodaction);
        }
		
		if(merrors!=null && !merrors.isEmpty()) {
			request.getRequestDispatcher(
					"/client/update.jsp").forward(request, response);
			return;
		}
		
		
		//呼叫Model, 根據Model執行結果顯示View
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		MemberBean bean = service.selectid(memberid);
	    
        bean.setPassword(password);
        bean.setEmail(email);

        bean.setCellphone(cellphone);
        bean.setAddress(address);
        MemberBean result = service.update(bean);
		
		if (result == null) {
			merrors.put("action", "修改資料失敗");

		} else {
			session.setAttribute("memberBean", result);

			session.setAttribute("update", result);
			session.setAttribute("userpassword", new String(result.getPassword()));
			request.getRequestDispatcher("/client/member.jsp").forward(request, response);

		}
			
	}
}
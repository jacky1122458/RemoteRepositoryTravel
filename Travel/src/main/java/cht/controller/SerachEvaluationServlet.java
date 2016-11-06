package cht.controller;

import java.io.IOException;
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

import cht.model.EvaluationService;
import cht.model.HotelReview;
import model.MemberBean;
import model.SerachEvaluationService;

@WebServlet( urlPatterns={"/SerachEvaluation.controller"} )
public class SerachEvaluationServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private SerachEvaluationService serachEvaluationService;
	public void init() throws ServletException {
		ApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		serachEvaluationService = (SerachEvaluationService) context.getBean("serachEvaluationService");
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//接收資料
		MemberBean memberBean =(MemberBean)session.getAttribute("memberBean");
		
		//呼叫Model, 根據Model執行結果顯示View
		List<HotelReview> revicwResult = serachEvaluationService.SerachMemberEvalutaion(memberBean);
		
		List<Map<String,Object>> toEvalution = serachEvaluationService.getEvalutationInformation(memberBean);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

package model;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public class SignInService {
	private SignInDAO dao;
	public SignInService(SignInDAO dao) {
		this.dao = dao;
	}
	


	public  SignInBean select(int memberid) {
		 SignInBean result = null;
		if (memberid != 0) {
			
			SignInBean bean = dao.select(memberid);
			
			if(bean!=null){
				result = bean;
			}
		}
		
		return result;
	}

	public void insertToLog(SignInBean bean) {
			dao.insert(bean);
			System.out.println("-----");
	}
	public void updateToLog(int memberid,java.util.Date signdate){
		dao.update(memberid, signdate);
	}
//	public void doLog(List<SignInBean> bean) {
//		if(bean.isEmpty()){
//		SignInBean bean1 = new SignInBean();
//		bean1.setMemberid(mb.getMemberid());
//		bean1.setSigndate(new java.util.Date());
//		
//			dao.insert(bean1);
//			
//		}else{
//			int memberid=mb.getMemberid();
//			Date signdate=new java.util.Date();
//			dao.update(memberid, signdate);
//	}
	}


	

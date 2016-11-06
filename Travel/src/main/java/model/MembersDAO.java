package model;

import java.util.Date;
import java.util.List;

public interface MembersDAO {
	
	//前台
	MemberBean selectAccount(String account);
	MemberBean update(byte[] password, String email, String cellphone, String address,
	        Date modate, Integer memberid);
	MemberBean insert(MemberBean bean);
	 
	 
	//後台
	MemberBean selectMemberid(int memberid);
	List<MemberBean> select();
	List<MemberBean> select(boolean status);
	MemberBean update(boolean status,Integer memberid);
	
	boolean delete(int memberid);
	MemberBean selectEmail(String email);
	
}

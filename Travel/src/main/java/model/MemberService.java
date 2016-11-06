package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import cht.model.Hotel;
import model.dao.Hotel_orderBeanDAOHibernate;
import model.dao.MemberBeanDAOHibernate;
@Transactional
public class MemberService {
	private MemberBeanDAOHibernate memberDAO;
	public MemberService(MemberBeanDAOHibernate memberDAO){
		this.memberDAO = memberDAO;
	}
	
	public MemberBean login(String account,String password){
		MemberBean bean=memberDAO.selectAccount(account);
		if(bean!=null){
			if(password!=null&&password.length()!=0){
				byte[] pass=password.getBytes();
				byte[] temp =bean.getPassword();
				if(Arrays.equals(pass, temp)){
					return bean;
				}
			}
		}
		return null;
	}
	
	public MemberBean join(MemberBean bean){
		MemberBean result=null;
		if(bean!=null){
			bean.setCreatdate(new java.util.Date());
			bean.setStatus(false);
			result=memberDAO.insert(bean);
			
		}
		return result;
		
	}
	
	
	public MemberBean selectid(int memberid){
		MemberBean result=null;
		if(memberid!=0){
			result=memberDAO.selectMemberid(memberid);
		}
		return result;
	}
	
	public List<MemberBean> select(MemberBean bean) {
		List<MemberBean> result = null;
		if(bean.getMemberid()!=0) {
			MemberBean temp = memberDAO.selectMemberid(bean.getMemberid());
			if(temp!=null) {
				result = new ArrayList<MemberBean>();
				result.add(temp);
			}else {
				result = memberDAO.select(); 
			}
		} else {
			result = memberDAO.select(); 
			}
		return result;
	}
	
	public MemberBean update(MemberBean bean) {
		MemberBean result=null;
		if(bean!=null){
			result=memberDAO.update(bean.getPassword(), bean.getEmail(), bean.getCellphone(), bean.getAddress(), bean.getModate(), bean.getMemberid());
		}return bean;
	}
	
	public List<MemberBean> select(boolean status) {
		List<MemberBean> result = null;
		if(status==true) {
			List<MemberBean> t = memberDAO.select(true);
			
				result = new ArrayList<MemberBean>(t);
				
			}else {
				List<MemberBean> f = memberDAO.select(false);
				result=new ArrayList<MemberBean>(f);
			}
		 
		return result;
	}
	
	public MemberBean update(boolean status, Integer memberid){
		MemberBean bean=memberDAO.selectMemberid(memberid);
		if(bean.getStatus()==false)
			memberDAO.update(true, memberid);
		else
			memberDAO.update(false, memberid);
		return bean;
		
	}
	public MemberBean selectAccount(String account){
		   MemberBean result=null;
		if(account!=""&&account!=null){
			result=memberDAO.selectAccount(account);
		}
		
		return result;
	}
	
	public MemberBean selectEmail(String email){
		   MemberBean result=null;
		if(email!=""&&email!=null){
			result=memberDAO.selectEmail(email);
		}
		
		return result;
	}
	
	//checkEvaluation
	public List<Map> checkEvaluation(MemberBean bean){
		
		//取得Hotel
		long oneDay = 86400000; //一天
		int day = 20;
		java.util.Date first = new java.util.Date();
		java.util.Date last = new java.util.Date(first.getTime()-(oneDay*day));
		
		List<Hotel> Hotels =null;
		if(bean!=null){
			Hotels = memberDAO.getHotelToEvaluation(bean.getMemberid(), first, last);
		}
		List<Map> results = null;
//		Map result = new HashMap();
//		if(Hotels!=null){
//			results = new ArrayList();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			for(Hotel hotel : Hotels){
//				Hotel_orderBean orderBean = null;
//				orderBean = memberDAO.getOrderBeanByHotelid(bean.getMemberid(), hotel.getHotelid());
//				if(orderBean.getHotelreview() == null){	//是否評價過
//					//memberDAO.getSession().evict(hotel);
//					result.put("hotel",hotel);
//					result.put("orderBean",orderBean);
//					results.add(result); 
//				}
//			}
//			return results;
//		}
		
		
		return results;
	}
	
//	public Hotel_orderBean getHotelChickDay(MemberBean member, Hotel hotel){
//		Hotel_orderBean result = null;
//			if(member!=null && hotel!=null){
//				result = memberDAO.getOrderBeanByHotelid(member.getMemberid(), hotel.getHotelid());
//			}
//		return result;
//	}
}

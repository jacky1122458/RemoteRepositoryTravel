package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cht.model.Hotel;
import model.Hotel_orderBean;
import model.MemberBean;
import model.MembersDAO;
import model.SignInBean;

public class MemberBeanDAOHibernate implements MembersDAO{
	private SessionFactory sessionFactory = null;
	public MemberBeanDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public MemberBean selectAccount(String account) {
		Query query=this.getSession().createQuery("from MemberBean where account= :account");
		query.setString("account",account);
		MemberBean mb = (MemberBean)query.uniqueResult();
		return mb;
	}
	
	@Override
	public MemberBean selectEmail(String email) {
		Query query=this.getSession().createQuery("from MemberBean where email= :email");
		query.setString("email",email);
		MemberBean mb = (MemberBean)query.uniqueResult();
		return mb;
	}
	
	@Override
	public MemberBean selectMemberid(int memberid) {
		return (MemberBean)this.getSession().
				get(MemberBean.class, memberid);	
	}
	
	@Override
	public MemberBean update(byte[] password, String email, String cellphone, String address,
            Date modate, Integer memberid) {
		
		MemberBean result = (MemberBean)
				this.getSession().get(MemberBean.class, memberid);
		
		if(result!=null) {
			result.setPassword(password);
			result.setEmail(email);
			result.setCellphone(cellphone);
			result.setAddress(address);
			try {
				modate = new java.util.Date();
				long time = modate.getTime();
				java.sql.Date mdate = new java.sql.Date(time);
				result.setModate(mdate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return result;
		
	}
	
	
	 @Override
	public MemberBean insert(MemberBean bean) {
		MemberBean result = (MemberBean) this.getSession().get(MemberBean.class,
				bean.getMemberid());

		if (result == null) {
			int id = (int) this.sessionFactory.getCurrentSession().save(bean);
//			SignInBean signInBean = new SignInBean();
//			signInBean.setMemberid(id);
//			signInBean.setSigndate(new Date());
//			this.getSession().save(signInBean);
			return bean;
		}
		return null;
	}
	
	@Override
	public List<MemberBean> select() {
		Query query=this.getSession().createQuery("from MemberBean");
		return(List<MemberBean>)query.list();
	}
	
	@Override
	public List<MemberBean> select(boolean status) {
		Query query=this.getSession().createQuery("from MemberBean where status=?");
		query.setBoolean(0,status);
		return(List<MemberBean>)query.list();
	}
	
	@Override
	public MemberBean update(boolean status, Integer memberid) {
		MemberBean result = (MemberBean)
				this.getSession().get(MemberBean.class, memberid);
		if(result!=null) {
			result.setStatus(status);
		}
		return result;
	}
	
	@Override
	public boolean delete(int memberid) {
		return false;
	}
	
	//HotelOrder
	public List<Hotel_orderBean> getOrderBean(int memberid, java.util.Date first, java.util.Date last){
		Query query = this.getSession().createQuery("From Hotel_orderBean Where memberid= ? and checkout BETWEEN ? and ? ");
		query.setInteger(0, memberid);
		query.setDate(1, first);
		query.setDate(2, last);
		return (List<Hotel_orderBean>) query.list();
	}
	//HotelToEvaluation
	public List<Hotel> getHotelToEvaluation(int memberid ,java.util.Date first, java.util.Date last){
		Query query = this.getSession()
				.createQuery("select h From Hotel h join h.rooms r join r.detailsbean det join det.ho ho where ho.memberid = ? and ho.checkout BETWEEN ? and ? ");
		query.setInteger(0, memberid);
		query.setDate(1, last);
		query.setDate(2, first);
		return (List<Hotel>)query.list();
	}
	
	public Hotel_orderBean getOrderBeanByHotelid(int memberid, int hotelid){
		Query query = this.getSession()
				.createQuery("select ho From Hotel h join h.rooms r join r.detailsbean det join det.ho ho where ho.memberid = ? and h.hotelid = ? order by ho.checkin desc");
		query.setInteger(0, memberid);
		query.setInteger(1, hotelid);
		query.setMaxResults(1);
		return (Hotel_orderBean)query.uniqueResult();
	}
}

package cht.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cht.model.HotelReview;
import cht.model.misc.HibernateUtil;

public class HotelReviewDAOHibernate {
	
	private SessionFactory sessionFactory = null;
	public HotelReviewDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	//members
	public List<HotelReview> selectByMemberId(int memberid){
		//Query query = this.getSession().createQuery("select new list (hr,h) from HotelReview hr join hr.hotel h where hr.hotelreviewID.memberid = ?");
		Query query = this.getSession().createQuery("From HotelReview where hotelreviewID.memberid = ?");
		query.setInteger(0, memberid);
		return (List<HotelReview>) query.list();
	}
	//hotels
	public List<HotelReview> selectByHotelId(int hotelId){
		//Query query = this.getSession().createQuery("select new list (hr,m.account) from HotelReview hr join hr.member m where hr.hotelreviewID.hotelid = ?");
		Query query = this.getSession().createQuery("From HotelReview where hotelreviewID.hotelid = ?");
		query.setInteger(0, hotelId);
		return (List<HotelReview>) query.list();
	}
	
	//hotelreviewId
	public HotelReview select(int Orderid){
		return (HotelReview) this.getSession().get(HotelReview.class, Orderid);
	}
	//all
	public List<HotelReview> select(){
		Query query = this.getSession().createQuery("From HotelReview");
		return (List<HotelReview>) query.list();
	}
	//新增
	public HotelReview insert(HotelReview bean){
		HotelReview result = this.select(bean.getOrderid());
		if(result==null){
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
	//修改
	public HotelReview update(HotelReview Bean){
		HotelReview result = (HotelReview) 
				this.getSession().get(HotelReview.class, Bean.getOrderid());
		if(result!=null){
			//Bean = new HotelReview();
			this.getSession().update(result);
		}
		return result;
	}
	
	//刪除
	public boolean delete (int Orderid){
		HotelReview bean = (HotelReview)
				this.getSession().get(HotelReview.class, Orderid);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
	public List<List> getEvalutation(int memberid, java.util.Date last, java.util.Date first){
		Query query = this.getSession().createQuery("select new List(h, ho) From Hotel_orderBean ho join ho.od od join od.roombean r join r.hb h where ho.evaluatstatus = 0 and od.Status = 1 and memberid = :memberid and  ho.checkin BETWEEN :last and :first");
		query.setDate("last", last);
		query.setDate("first", first);
		query.setInteger("memberid", memberid);
		return (List<List>)query.list();
	}
	
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			HotelReviewDAOHibernate dao = new HotelReviewDAOHibernate(HibernateUtil.getSessionFactory());
			
			HotelReview	result;
			

//			System.out.println(dao.selectByMemberId(1));//memberid
//			System.out.println(dao.selectByHotelId(3));	//hotelid
			System.out.println(dao.select());
			
			
			
			HotelReview bean = new HotelReview();
			bean.setCleanliness((short) 2);
			bean.setComfort((short) 2);
			bean.setLocation((short) 2); 
			bean.setFacilities((short) 2); 
			bean.setStaff((short) 2);
			bean.setCp((short) 2);
			bean.setTotal((short) 2);
			bean.setAdvantage("very good");
			bean.setDefect("");
			bean.setDisplay(false);
			
//			System.out.println(dao.insert(bean));	//insert
//			System.out.println(dao.update(bean));	//updata
//			System.out.println(dao.delete(id));		//delete
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}

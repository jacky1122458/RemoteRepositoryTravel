package cht.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cht.model.HotelCard;
import cht.model.id.HotelCardId;
import cht.model.misc.HibernateUtil;

public class HotelCardDAOHibernate {
	
	private SessionFactory sessionFactory = null;
	public HotelCardDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	//新增
	public HotelCard insert(HotelCard bean){
		HotelCard result = this.getSession().get(HotelCard.class, bean.getHotelcardId());
		if(result==null){
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
	
	//刪除
	public boolean delete (HotelCard bean){
		HotelCard hotelCard = (HotelCard)
				this.getSession().get(HotelCard.class, bean.getHotelcardId());
		if(hotelCard!=null){ 
			this.getSession().delete(hotelCard);
			return true;
		}
		return false;
	}
	
	
	//all
	public List<HotelCard> select(){
		Query query = this.getSession().createQuery("From HotelCard");
		return (List<HotelCard>) query.list();
	}
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			HotelCardDAOHibernate dao = new HotelCardDAOHibernate(HibernateUtil.getSessionFactory());
			
			HotelCardId hotelcardId = new HotelCardId();
			hotelcardId.setHotelid(1);
			hotelcardId.setCardtype("maestro");
			HotelCard bean = new HotelCard();
			bean.setHotelcardId(hotelcardId);
			
//			System.out.println(dao.insert(bean));	//insert
//			System.out.println(dao.delete(bean));	//delete
			System.out.println(dao.select());		//all
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}

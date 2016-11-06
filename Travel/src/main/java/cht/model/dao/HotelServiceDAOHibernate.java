package cht.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cht.model.Card;
import cht.model.HotelService;
import cht.model.id.HotelServiceId;
import cht.model.misc.HibernateUtil;

public class HotelServiceDAOHibernate {
	private SessionFactory sessionFactory = null;
	public HotelServiceDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//all
	public List<HotelService> select(){
		Query query = this.getSession().createQuery("From HotelService");
		return (List<HotelService>)query.list();
	} 
	
	//新增
	public HotelService insert(HotelService bean){
		HotelService result = this.getSession().get(HotelService.class, bean.getHotelServiceId());
		if(result==null){
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
	
	//刪除
	public boolean delete (HotelServiceId hotelServiceId){
		HotelService hotelservice = (HotelService)
				this.getSession().get(HotelService.class, hotelServiceId);
		if(hotelservice!=null){ 
			this.getSession().delete(hotelservice);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			HotelServiceDAOHibernate dao = new HotelServiceDAOHibernate(HibernateUtil.getSessionFactory());
			
			
			HotelServiceId Id = new HotelServiceId();
			Id.setHotelid(2);
			Id.setServiceid(10);
			
			HotelService bean =new HotelService();
			bean.setHotelServiceId(Id);
			
			System.out.println(dao.select());		//all
//			System.out.println(dao.insert(bean));	//insert
//			System.out.println(dao.delete(Id));		//delete
			
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}


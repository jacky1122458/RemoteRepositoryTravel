package cht.model.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cht.model.Hotel;
import cht.model.HotelType;
import cht.model.misc.HibernateUtil;

public class HotelTypeDAOHibernate {
	
	private SessionFactory sessionFactory = null;
	public HotelTypeDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public HotelType select(int typeid){
		return (HotelType) this.getSession().get(HotelType.class, typeid);
	}
	public HotelType select(String typename){
		Query query = this.getSession().createQuery("From HotelType where typename like ? ");
		query.setString(0, "%"+typename+"%");
		return (HotelType) query.uniqueResult();
	}
	public List<HotelType> select(){
		Query query = this.getSession().createQuery("From HotelType");
		return (List<HotelType>) query.list();
	}
	//新增
	public HotelType insert(HotelType bean){
		HotelType result = this.select(bean.getTypename());
		if(result==null){
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
	//修改
	public HotelType update(HotelType bean){
		HotelType result = (HotelType) 
				this.getSession().get(HotelType.class, bean.getTypeid());
		if(result!=null){
			this.getSession().update(result);
		}
		return result;
	}
	
	//刪除
	public boolean delete (int Hotelid){
		HotelType bean = (HotelType)
				this.getSession().get(HotelType.class, Hotelid);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	//getHotel
	public Set<Hotel> getHotels(int typeid){
		return (Set<Hotel>)select(typeid).getHotels();
	}
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			HotelTypeDAOHibernate dao = new HotelTypeDAOHibernate(HibernateUtil.getSessionFactory());
			

			
			System.out.println(dao.select(1));		//id
//			System.out.println(dao.select("飯店"));	//type
//			System.out.println(dao.select());		//all
//			System.out.println(dao.getHotels(1));	//hotels
			
//			HotelType bean = new HotelType();
//			bean.setTypename("黑店");
//			System.out.println(dao.insert(bean));	//insert
			
//			System.out.println(dao.delete(bean.getTypeid()));	//刪除
			
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}

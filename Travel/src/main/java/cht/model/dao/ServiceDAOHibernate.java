package cht.model.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cht.model.Hotel;
import cht.model.Service;
import cht.model.misc.HibernateUtil;

public class ServiceDAOHibernate {
	
	private SessionFactory sessionFactory = null;
	public ServiceDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	//id
	public Service select(int serviceid){
		return (Service) this.getSession().get(Service.class, serviceid);
	}
	public List<Service> select(){
		Query query = this.getSession().createQuery("From Service");
		return (List<Service>) query.list();
	}
	//新增
	public Service insert(Service bean){
		Service result = this.select(bean.getServiceid());
		if(result==null){
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
	//修改
	public Service update(Service bean){
		Service result = (Service) 
				this.getSession().get(Service.class, bean.getServiceid());
		if(result!=null){
			this.getSession().update(bean);
		}
		return result;
	}
	
	//刪除
	public boolean delete (int serviceid){
		Service bean = (Service)
				this.getSession().get(Service.class, serviceid);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
	public Set<Hotel> getHotels(int serviceid){
		return (Set<Hotel>) select(serviceid).getHotels();
	}
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			ServiceDAOHibernate dao = new ServiceDAOHibernate(HibernateUtil.getSessionFactory());
			
			System.out.println(dao.select(1));		//id
//			System.out.println(dao.select());		//all
//			System.out.println(dao.getHotels(1));	//getHotels
			
//			Service bean = new Service();
//			bean.setServicename("送旅館");
			
//			System.out.println(dao.insert(bean)); //insert
			
//			System.out.println(dao.delete(bean.getServiceid())); //delete
			
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}

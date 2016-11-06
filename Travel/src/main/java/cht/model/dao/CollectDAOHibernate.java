package cht.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cht.model.Card;
import cht.model.Collect;
import cht.model.id.CollectId;
import cht.model.misc.HibernateUtil;

public class CollectDAOHibernate {
	private SessionFactory sessionFactory = null;
	public CollectDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//新增
	public Collect insert(Collect bean){
		Collect result = this.getSession().get(Collect.class, bean.getCollectId());
		if(result==null){
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
	
	//刪除
	public boolean delete (Collect bean){
		Collect Collect = (Collect)
				this.getSession().get(Collect.class, bean.getCollectId());
		if(Collect!=null){ 
			this.getSession().delete(Collect);
			return true;
		}
		return false;
	}
	
	//all
	public List<Card> select(){
		Query query = this.getSession().createQuery("From Collect");
		return (List<Card>)query.list();
	} 
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			CollectDAOHibernate dao = new CollectDAOHibernate(HibernateUtil.getSessionFactory());
			
			
			CollectId id =new CollectId();
			id.setHotelid(1);
			id.setMemberid(4);
			Collect bean = new Collect();
			bean.setCollectId(id);
			
			System.out.println(dao.select());		//all
//			System.out.println(dao.insert(bean));	//insert
//			System.out.println(dao.delete(bean));	//delete
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}

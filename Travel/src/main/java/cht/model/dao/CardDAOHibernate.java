package cht.model.dao;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cht.model.Card;
import cht.model.misc.HibernateUtil;

public class CardDAOHibernate {
	private SessionFactory sessionFactory = null;
	public CardDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//select
	public Card select(String cardtype){
		return (Card) this.getSession().get(Card.class,cardtype);
	}
	//all
	public List<Card> select(){
		Query query = this.getSession().createQuery("From Card");
		return (List<Card>)query.list();
	} 
	
	//delete
	public boolean delete(String cardtype){
		Card bean = this.getSession().get(Card.class, cardtype);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
	//新增
	public Card insert(Card bean){
		FileInputStream fis =null;
		BufferedInputStream bis =null;
		File file = null;
		
		file = new File(bean.getCardtype());
		byte[] imageData = new byte [(int)file.length()];

		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);

			while (bis.available() > 0) {
				bis.read(imageData);
			}
			bean.setCardtype(bean.getCardtype().substring(bean.getCardtype().lastIndexOf("/")+1));
			bean.setCardphoto(imageData);
			this.getSession().save(bean);
			
			} catch (Exception e) { 
				e.printStackTrace();
			} finally{
				try {
					if(bis!=null){ bis.close();}
					if(fis!=null){ fis.close();}
				} catch (IOException e) { e.printStackTrace();}
			}

		return bean;
	}
	
	
	
	public static void main(String[] args) throws IOException{
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			CardDAOHibernate dao = new CardDAOHibernate(HibernateUtil.getSessionFactory());
			
			
//			System.out.println(dao.select("supercard.jpg"));	//select
//			System.out.println(dao.select());		//all
			System.out.println(dao.delete("jcb"));	//delete
			
//			Card bean = new Card();
//			//insert
//			bean.setCardtype("C:/image/supercard.jpg");
//			Card result = dao.insert(bean);
//			System.out.println(result);
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}

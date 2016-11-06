package jj.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jj.model.AttractionsBean;
import jj.model.TourBean;
import jj.model.TourDAO;
import jj.model.Travel_attractionsBean;
import jj.model.Travel_attractionsDAO;

public class Travel_attractionsDAOHibernate implements Travel_attractionsDAO {

	private SessionFactory sessionFactory;
	public Travel_attractionsDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		
		try {
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			
		
			Travel_attractionsDAOHibernate dao = (Travel_attractionsDAOHibernate)context.getBean("travel_attractionsDAO");
			Travel_attractionsBean bean = new Travel_attractionsBean();
			
			List<Travel_attractionsBean> s = dao.select_by_tour_id(1);
			System.out.println(s);
//			bean.setTour_id(3);
//			bean.setSequence(3);
//			bean.setAttractions_id(6);
//			dao.insert(bean);
			
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	//id搜尋
	@Override
	public List<Travel_attractionsBean> select_by_tour_id(int tour_id) {
		String a ="select new list (A.tour_id,A.attractions_id,A.sequence) from Travel_attractionsBean as  A  where A.tour_id=:tour_id order by A.sequence ASC";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id", tour_id);
		return (List<Travel_attractionsBean>)query.list();
	}
	//id搜尋
	@Override
	public List<Travel_attractionsBean> select_setTourbean(int tour_id) {
		String a ="select new list (C) from Travel_attractionsBean as  A join A.attractionsid as B join A.tourid as C where A.tour_id=1 order by A.sequence ASC";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id", tour_id);
		return (List<Travel_attractionsBean>)query.list();
	}
	
	
	//id搜尋
	@Override
	public List<Travel_attractionsBean> selectatttion_tour_id(int tour_id) {
		String a ="select new list (A.sequence,B.id,B.name,B.attractions_type,B.openinghours,B.introduction,B.lat,B.lng,B.webaddress) from Travel_attractionsBean as  A join A.attractionsid as B join A.tourid as C where A.tour_id=:tour_id order by A.sequence ASC";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id", tour_id);
		return (List<Travel_attractionsBean>)query.list();
	}
	
	@Override
	public Travel_attractionsBean insert(Travel_attractionsBean bean) {
		Session session = this.sessionFactory.getCurrentSession();
	    session.save(bean);
	    return bean;		
	}
	@Override
	public Travel_attractionsBean insert(int tourid, int squeuence, int attionid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean update(int tour_id, int sequence, int attractions_id) {
		String a="update from Travel_attractionsBean set sequence=:sequence  where tour_id=:tour_id and   attractions_id=:attractions_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("sequence", sequence);
		query.setParameter("attractions_id", attractions_id);
		query.setParameter("tour_id", tour_id);
		query.executeUpdate();
		return false ;
	}
	
	
	public  List select_id_name(int tour_id){
		String a ="select new list (B.name,A.attractions_id,A.sequence) from Travel_attractionsBean as  A join A.attractionsid as B where A.tour_id=:tour_id order by A.sequence ASC";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id", tour_id);
		return query.list();
	}

	
	
	public boolean delete(int id) {
		Travel_attractionsBean bean = (Travel_attractionsBean)this.sessionFactory.getCurrentSession().get(Travel_attractionsBean.class,id);
		if(bean!=null) {
			this.sessionFactory.getCurrentSession().delete(bean);
			return true;
		}
		return false;		
}
}




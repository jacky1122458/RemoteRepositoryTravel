package jj.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import model.MemberBean;
import jj.model.TourBean;
import jj.model.Tour_evaluateBean;
import jj.model.Tour_evaluateDAO;
import jj.model.Tour_orderBean;

public class Tour_evaluateDAOHibernate implements Tour_evaluateDAO {
	private SessionFactory sessionFactory;
	public Tour_evaluateDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		
		try {
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			
		
			Tour_evaluateDAOHibernate dao = (Tour_evaluateDAOHibernate)context.getBean("tour_evaluateDAO");
			Tour_evaluateBean bean = new Tour_evaluateBean();

			
			
			
			
			
//			 bean.setOrder_id(8);
//			 bean.setMember_id(4);
//			 bean.setTour_id(9);
//			 bean.setEvaluate("測試");
//			 bean.setRating(4);
//			 bean.setEvaluate_status(false);
//			 dao.insert(bean);
			
			
			
//			List<Tour_evaluateBean> s = dao.select_by_tour(1);
//			System.out.println(s);
			
			List<List> s = dao.select_tour_rating(9);
			System.out.println(s);
			
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	//檢查有沒有這個值
	@Override
	public List select_check(int order_id,int tour_id,int member_id) {
		String a= "select A.order_id from Tour_evaluateBean as A where A.order_id=:order_id and A.tour_id=:tour_id  and A.member_id=:member_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("order_id",order_id);
		query.setParameter("tour_id",tour_id);
		query.setParameter("member_id",member_id);
		return (List)query.list();
	}
	//檢查狀態是什麼更新
	@Override
	public List<List> select_check_update(int order_id) {
		String a= "select new list(A.evaluate_status) from Tour_evaluateBean as A where A.order_id=:order_id and A.evaluate_status=1";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("order_id",order_id);
		return (List<List>) query.list()  ;
	}
	

	
	
	
	//秀出所有訂單給管理
	@Override
	public List<Tour_evaluateBean> select() {
		String a= "select new list(A.order_id ,B.account ,B.firstname+B.lastname,C.tour_name,A.evaluate,A.rating,A.evaluate_status) from Tour_evaluateBean as A join A.memberid as B join  A.tourid as C";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		return (List<Tour_evaluateBean>) query.list();
	}
	//給後台
	@Override
	public List<List> select_back() {
		String a= "select new list(A.order_id ,B.account ,B.firstname+B.lastname,C.tour_name,A.evaluate,A.rating,A.evaluate_status) from Tour_evaluateBean as A join A.memberid as B join  A.tourid as C";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		return (List<List>) query.list();
	}
	@Override
	public List<Tour_evaluateBean> select(int member_id) {
		String a ="select new list(A.order_id ,B.account ,B.firstname+B.lastname,C.tour_name,A.evaluate,A.rating,A.evaluate_status) from Tour_evaluateBean as A join A.memberid as B join  A.tourid as C where A.member_id =:member_id ";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("member_id", member_id);
		return (List<Tour_evaluateBean>) query.list();
	}
	
	@Override
	public List<Tour_evaluateBean> select_my(int member_id) {
		String a ="select new list(A.order_id ,B.account ,B.firstname+B.lastname,C.tour_name,A.evaluate,A.rating) from Tour_evaluateBean as A join A.memberid as B join  A.tourid as C where A.member_id =:member_id  ";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("member_id", member_id);
		return (List<Tour_evaluateBean>) query.list();		
	}
	
	//搜尋自己評論
	@Override
	public List<Tour_evaluateBean> select_mysef(MemberBean bean) {
		String a ="select new list(A.order_id ,B.account ,B.firstname+B.lastname,C.tour_name,A.evaluate,A.rating) from Tour_evaluateBean as A join A.memberid as B join  A.tourid as C where A.member_id =:member_id  ";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("member_id", bean.getMemberid());
		return (List<Tour_evaluateBean>) query.list();		
	}
	
	
	
	//搜尋狀態1給評論
	@Override
	public List<Tour_evaluateBean> select_by_tour(int tour_id) {
		String a ="select new list(A.order_id ,B.firstname+B.lastname,C.tour_name,A.evaluate,A.rating) from Tour_evaluateBean as A join A.memberid as B join  A.tourid as C where A.tour_id =:tour_id and A.evaluate_status=1 order by A.order_id desc";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id", tour_id);
		return (List<Tour_evaluateBean>) query.list();
	}
	
	@Override
	public Tour_evaluateBean insert(Tour_evaluateBean bean) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(bean);		
		return bean;
	}
	
	//依訂單編號改 狀態
	@Override
	public boolean update_Status(boolean evaluate_status, int order_id) {
		String a ="update from Tour_evaluateBean set evaluate_status=:evaluate_status where order_id=:order_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("evaluate_status", evaluate_status);
		query.setParameter("order_id",order_id);
		int i = query.executeUpdate();
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public boolean update1(String evaluate, int rating, int order_id) {
		String a ="update from Tour_evaluateBean set evaluate=:evaluate , rating=:rating  where order_id=:order_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("evaluate", evaluate);
		query.setParameter("rating", rating);
		query.setParameter("order_id",order_id);
		int i = query.executeUpdate();
		if(i == 1){
			return true;
		}else{
			return false;
		}
		
}
	//計算分數給旅程
	@Override
	public List select_tour_rating(int tour_id) {
		String a ="select new list(avg(A.rating)) from Tour_evaluateBean as A where A.tour_id=:tour_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id", tour_id);
		return (List<List>)query.list();
	}


}

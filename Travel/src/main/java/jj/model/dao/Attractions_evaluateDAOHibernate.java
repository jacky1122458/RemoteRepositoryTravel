package jj.model.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jj.model.Attractions_evaluateBean;
import jj.model.Attractions_evaluateDAO;

public class Attractions_evaluateDAOHibernate implements Attractions_evaluateDAO {

	private SessionFactory sessionFactory;
	public Attractions_evaluateDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		try {
			Attractions_evaluateDAOHibernate dao = (Attractions_evaluateDAOHibernate)context.getBean("attractions_evaluateDAO");
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			
			
			Attractions_evaluateBean bean = new Attractions_evaluateBean();
				
//			bean.setMember_id(4);
//			bean.setAttractions_id(1);
//			bean.setAttractions_rating(3);
//			bean.setAttractions_evaluate("普普通通啦");
//			bean.setAttractions_status(true);
//			dao.insert(bean);
			
			 List<Attractions_evaluateBean> y = dao.select_ALL();
			 System.out.println(y);

//			dao.userupdate_status(4, "不好玩阿",2, 1);
		
//			List<Attractions_evaluateBean> s = dao.select_member_id(2);
//			System.out.println(s);
			
//			List<Attractions_evaluateBean> d = dao.select_Attractions_sum(1);
//			System.out.println(d);
			
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	//後台全部不管01
	@Override
	public List<Attractions_evaluateBean> select_ALL() {
		String a ="SELECT NEW list(C.account,C.firstname+C.lastname,B.name,A.attractions_evaluate,A.attractions_rating,A.attractions_status) from Attractions_evaluateBean as A join A.attractionsid as B join A.memberid as C";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		return (List<Attractions_evaluateBean>) query.list();
	}
	//後台全部依據Member_id
	public List<Attractions_evaluateBean>select_ALL(int member_id){
		String b ="SELECT NEW list(C.account,C.firstname+C.lastname,B.name,A.attractions_evaluate,A.attractions_rating) from Attractions_evaluateBean as A join A.attractionsid as B join A.memberid as C where  A.member_id=:member_id   ";
		Query query = sessionFactory.getCurrentSession().createQuery(b);
		query.setParameter("member_id", member_id);
		return (List<Attractions_evaluateBean>) query.list();
	}
	
	
	//新增
	@Override
	public Attractions_evaluateBean insert(Attractions_evaluateBean bean) {
		Session session = this.sessionFactory.getCurrentSession();
		bean.getMember_id();
		bean.getAttractions_id();
		bean.getAttractions_rating();
		bean.getAttractions_evaluate();
		bean.isAttractions_status();
		session.save(bean);
		return bean;	
	}
	
	
	//修改自己評分
	@Override
	public void userupdate_status(int Attractions_rating, String Attractions_evaluate,
			int member_id,int attractions_id) {
		String c ="update Attractions_evaluateBean set attractions_rating =:Attractions_rating,attractions_evaluate=:Attractions_evaluate where member_id=:member_id and attractions_id=:attractions_id ";
		Query query = sessionFactory.getCurrentSession().createQuery(c);
		query.setParameter("Attractions_rating", Attractions_rating);
		query.setParameter("Attractions_evaluate", Attractions_evaluate);
		query.setParameter("member_id", member_id);
		query.setParameter("attractions_id", attractions_id);
		query.executeUpdate();
	}
	
	//後台修改狀態
	@Override
	public boolean rootupdate_status(boolean attractions_status,int member_id,int attractions_id) {
		String d ="update Attractions_evaluateBean set attractions_status=:attractions_status where member_id=:member_id and attractions_id=:attractions_id";
		Query query = sessionFactory.getCurrentSession().createQuery(d);
		query.setParameter("attractions_status", attractions_status);
		query.setParameter("member_id", member_id);
		query.setParameter("attractions_id", attractions_id);
		int i=query.executeUpdate();
		if(i==1){
			return true;
		}else{
			return false;
		}
	}
	

	

	
	//我的評價
	@Override
	public List<Attractions_evaluateBean> select_member_id(int member_id) {
		String a ="SELECT NEW list(C.firstname+C.lastname,B.name,A.attractions_evaluate,A.attractions_rating) from Attractions_evaluateBean as A join A.attractionsid as B join A.memberid as C where A.member_id=:member_id and A.attractions_status=1;";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("member_id", member_id);
		return (List<Attractions_evaluateBean>) query.list();
	}

	
	//單一景點評價
	@Override
	public List<Attractions_evaluateBean> select_Attractions_evaluate_id(int attractions_id) {
		String a ="SELECT NEW list(C.firstname+C.lastname,B.name,A.attractions_evaluate,A.attractions_rating) from Attractions_evaluateBean as A join A.attractionsid as B join A.memberid as C where A.attractions_id=:attractionsid";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("attractionsid", attractions_id);
		return (List<Attractions_evaluateBean>) query.list();
	}

	
	//計算評價分數 依景點
	@Override
	public List<Attractions_evaluateBean> select_Attractions_sum(int attractions_id) {
		String a ="SELECT avg(A.attractions_rating) from Attractions_evaluateBean as A join A.attractionsid as B join A.memberid as C where A.attractions_id =:attractions_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("attractions_id", attractions_id);
		return (List<Attractions_evaluateBean>) query.list();		

	}
}

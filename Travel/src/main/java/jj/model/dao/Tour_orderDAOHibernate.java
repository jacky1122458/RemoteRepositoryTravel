package jj.model.dao;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jj.model.Tour_orderBean;
import jj.model.Tour_orderDAO;

public class Tour_orderDAOHibernate implements Tour_orderDAO {
	private SessionFactory sessionFactory;
	public Tour_orderDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		
		try {
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			
		
			Tour_orderDAOHibernate dao = (Tour_orderDAOHibernate)context.getBean("tour_orderDAO");
			Tour_orderBean bean = new Tour_orderBean();
			
			java.util.Date day1 = null;
			java.util.Date day2 = null;
			try {
				day1 = DateFormat.getDateInstance().parse("2016/9/1");
				day2=DateFormat.getDateInstance().parse("2016/11/8");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long time1 = day1.getTime();
			long time2 = day2.getTime();
			Date date1 = new java.sql.Date(time1);
			Date date2 = new java.sql.Date(time2);

			bean.setMember_id(4);
			bean.setTour_id(9);
			bean.setNumber_people(1);
			bean.setPrice(2000);
			bean.setOrdername("林王子");
			bean.setPhone("0975345765");
			bean.setOrder_date(date1);
			bean.setDeparture_date(date2);
			bean.setOrder_status(false);
			dao.insert(bean);
	
//			dao.update(true,6);
		
//			List<Tour_orderBean> s = dao.select_by_member(4);
//			System.out.println(s);
			
			
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	
	//搜尋我得訂單 Sow
	@Override
	public List<Tour_orderBean> select_by_member(int member_id) {
		String a="select new list (A.order_id,B.account,B.firstname+B.lastname,A.ordername,A.price,A.phone,A.tour_id,C.tour_name,A.number_people,A.order_date,A.departure_date,A.order_status)  from Tour_orderBean as A join A.memberBean as B join A.tourBean as C where A.member_id=:member_id and order_status=1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("member_id",member_id);
		return (List<Tour_orderBean>)query.list();	
	}
	//用mid 拿tourid
	@Override
	public List<List> select_by_member_get_tourid1(int member_id) {
		String a="select new list (A.tour_id)  from Tour_orderBean as A join A.memberBean as B join A.tourBean as C where A.member_id=:member_id and order_status=1  ";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("member_id",member_id);
		return (List<List>)query.list();	
	}
	//搜尋我得訂單 Sow
	@Override
	public List<Tour_orderBean> select_by_member_tourid(int member_id,int tour_id) {
		String a="select new list (A.order_id,B.account,B.firstname+B.lastname,A.ordername,A.price,A.phone,A.tour_id,C.tour_name,A.number_people,A.order_date,A.departure_date,A.order_status,(select A.attractionsid.name from Travel_attractionsBean as  A  where A.tour_id=:tour_id and A.sequence=1),(select A.attractionsid.name from Travel_attractionsBean as  A  where A.tour_id=:tour_id and A.sequence=2),(select A.attractionsid.name from Travel_attractionsBean as  A  where A.tour_id=:tour_id and A.sequence=3))  from Tour_orderBean as A join A.memberBean as B join A.tourBean as C  where A.member_id=:member_id and order_status=1";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("member_id",member_id);
		query.setParameter("tour_id",tour_id);
		return (List<Tour_orderBean>)query.list();	
		
	}
	//搜尋我得訂單id
		@Override
		public List<List> select_by_member_get_tourid(int member_id) {
			String a="select new list (A.order_id)  from Tour_orderBean as A WHERE A.member_id=:member_id and A.order_status=1";
			Query query = sessionFactory.getCurrentSession().createQuery(a);
			query.setParameter("member_id",member_id);
			return (List<List>)query.list();	
		}
	
		//搜尋我得訂單id tourid numberid
				@Override
				public List<List> select_by_orderid_get_tourid_number(int order_id) {
					String a="select new list (A.order_id,A.tour_id,A.number_people)  from Tour_orderBean as A WHERE A.order_id=:order_id and A.order_status=1";
					Query query = sessionFactory.getCurrentSession().createQuery(a);
					query.setParameter("order_id",order_id);
					return (List<List>)query.list();	
				}
		
		
	@Override
	public List<Tour_orderBean> select_all(int member_id) {
		String a="select new list ( A.order_id,B.account,B.firstname+B.lastname,C.tour_name,A.number_people,A.order_date,A.departure_date,A.order_status ) from Tour_orderBean as A join A.memberBean as B join A.tourBean as C where A.member_id=:member_id ";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("member_id", member_id);
		return (List<Tour_orderBean>)query.list();		
	}
	@Override
	public List<Tour_orderBean> select_all() {
		String a="select new list ( A.order_id,B.account,B.firstname+B.lastname,C.tour_name,A.number_people,A.order_date,A.departure_date,A.order_status ) from Tour_orderBean as A join A.memberBean as B join A.tourBean as C";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		return (List<Tour_orderBean>)query.list();		
	}
	//搜尋所有得訂購
	@Override
	public List<Tour_orderBean> select_all_orderbymanag() {
		String a="select new list ( A.order_id,B.account,B.firstname+B.lastname,A.ordername,C.tour_name,A.number_people,A.order_date,A.departure_date,A.order_status ) from Tour_orderBean as A join A.memberBean as B join A.tourBean as C";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		return (List<Tour_orderBean>)query.list();		
	}   
	//搜尋所有得訂購byid 給後台
	@Override
	public List<Tour_orderBean> select_all_orderbymanagbyid(int tour_id) {
		String a="select new list ( A.order_id,B.account,B.firstname+B.lastname,A.ordername,C.tour_name,A.number_people,A.order_date,A.departure_date,A.order_status ) from Tour_orderBean as A join A.memberBean as B join A.tourBean as C where A.tour_id=:tour_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id",tour_id);
		return (List<Tour_orderBean>)query.list();		
	}   
	@Override
	public boolean update(boolean order_status, int order_id) {
		String a="update Tour_orderBean set order_status=:order_status where order_id=:order_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("order_status", order_status);
		query.setParameter("order_id", order_id);
		int i=query.executeUpdate();
		if(i==1){
			return true;
		}
	return false;
	}
	
	//新增訂單
	@Override
	public Tour_orderBean insert(Tour_orderBean bean) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(bean);
		return bean ;
	}
	
	//搜尋已定人數給 TOUR
	public List<List> select_tour_number(int tourid,java.util.Date departure_date) {
		String a="select sum(A.number_people)  from Tour_orderBean as A  where A.tour_id=:tourid AND A.order_status=1 and A.departure_date=:departure_date ";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tourid", tourid);
		query.setParameter("departure_date", departure_date);
		return (List<List>)query.list();
	}
	//搜尋訂單人資訊 給簡訊
	public List<List> select_tour_sms(int order_id) {
		String a="select new list (A.order_id,B.account,B.firstname+B.lastname,A.ordername,A.price,A.phone,A.tour_id,C.tour_name,A.number_people,A.order_date,A.departure_date)  from Tour_orderBean as A join A.memberBean as B join A.tourBean as C where A.order_id=:order_id ";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("order_id", order_id);
		return (List<List>)query.list();
	}
	
	//用odrid分辨我的訂單
	public List<List> select_tourmyorder_new(int order_id,int member_id) {
		String a="select new list (A.order_id,B.account,(B.firstname+B.lastname),A.ordername,A.price,A.phone,A.tour_id,C.tour_name,A.number_people,A.order_date,A.departure_date,A.order_status,(select A.attractionsid.name from Travel_attractionsBean as  A  where A.tour_id=(select tour_id  from Tour_orderBean where order_id=:order_id) and A.sequence=1),(select A.attractionsid.name from Travel_attractionsBean as  A  where A.tour_id=(select tour_id  from Tour_orderBean where order_id=:order_id) and A.sequence=2),(select A.attractionsid.name from Travel_attractionsBean as  A  where A.tour_id=(select tour_id  from Tour_orderBean where order_id=:order_id) and A.sequence=3))  from Tour_orderBean as A join A.memberBean as B join A.tourBean as C  where A.order_status=1 AND A.member_id =:member_id and order_id=:order_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("member_id",member_id);
		query.setParameter("order_id",order_id);
		return (List<List>)query.list();
	}
	//用memberid 找orderid 給我的訂單↑
	public List<List> select_tourmyorder_newid(int member_id) {
		String a="select a.order_id from Tour_orderBean as a  where a.member_id=:member_id and a.order_status=1";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("member_id",member_id);
		return (List<List>)query.list();
	}
	
	
	
}
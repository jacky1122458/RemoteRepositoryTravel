package model.dao;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.Hotel_orderBean;
import model.Order_detailsBean;
public class Hotel_orderBeanDAOHibernate {
	private SessionFactory sessionFactory;
	public Hotel_orderBeanDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		try {
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			Hotel_orderBeanDAOHibernate dao =(Hotel_orderBeanDAOHibernate)context.getBean("hotel_orderBeanDAO");
			Hotel_orderBean bean1 = new Hotel_orderBean();
			bean1.setMemberid(1);
			bean1.setPrice_total(3500);
			java.sql.Date date1 = null;
			java.sql.Date date2 = null;
			java.sql.Date date3 = null;
			try {
				java.util.Date day1 = DateFormat.getDateInstance().parse("2016/10/1");
				java.util.Date day2 = DateFormat.getDateInstance().parse("2016/10/10");
				java.util.Date day3 = DateFormat.getDateInstance().parse("2016/10/15");
				long time1 = day1.getTime();
				long time2 = day2.getTime();
				long time3 = day3.getTime();
				date1 = new java.sql.Date(time1);
				date2 = new java.sql.Date(time2);
				date3 = new java.sql.Date(time3);
			} catch (Exception e) {
				
			}
			bean1.setOrderdate(date1);
			bean1.setCheckin(date2);
			bean1.setCheckout(date3);
//			dao.insert(bean1);
//			List<Hotel_orderBean> bean = dao.select();
//			 List<Hotel_orderBean> bean2 = dao.select();
//			 for(Hotel_orderBean a :bean2){
//				 System.out.println(a);
//			 }
			
			int result = dao.update(1,date2,date3);
			 System.out.println(result);
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	public int insert(Hotel_orderBean bean1) {
		Session session = this.sessionFactory.getCurrentSession();
		int a = (int) session.save(bean1);
		return a;
	}
	public List<Hotel_orderBean> select_ALL(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Hotel_orderBean");
		
		return (List<Hotel_orderBean>)query.list();
		
	}
	public List<List> select_byMemberid(int memberid){
		Query query = this.sessionFactory.getCurrentSession().createQuery("select new list(ho.orderid,h.hotelname,ho.memberid,ho.price_total,ho.orderdate,ho.checkin,ho.checkout,od.Status,h.address,h.hotelid) from Hotel_orderBean as ho join ho.od as od join od.roombean as r join r.hb as h where memberid=:memberid group by ho.orderid,ho.memberid,ho.price_total,ho.orderdate,ho.checkin,ho.checkout,od.Status,h.hotelname,h.address,h.hotelid order by ho.orderid desc");
		query.setParameter("memberid", memberid);
		 List<List> data1=(List<List>)query.list();
		 System.out.println("aaaaaaaaaa"+data1);
		return data1;
	}
	public List<Hotel_orderBean> select_byOrderidAndMemberid(int orderid,int memberid){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Hotel_orderBean where orderid=:orderid and memberid=:memberid");
		query.setParameter("orderid", orderid);
		query.setParameter("memberid", memberid);
		return (List<Hotel_orderBean>)query.list();
	}
	public Hotel_orderBean select_byOrderid(int orderid){
		
		return (Hotel_orderBean)this.sessionFactory.getCurrentSession().get(Hotel_orderBean.class, orderid);
	}
	//以下10/25新增
	public int update(int orderid,java.util.Date checkinday,java.util.Date checkoutday){
		Hotel_orderBeanDAOHibernate dao = new Hotel_orderBeanDAOHibernate(sessionFactory);
		List<Integer> roomid = dao.selectRoomid(orderid);
		Date checkin1 = dao.checkinDay(checkinday, orderid);
		Date checkout1 = dao.checkoutDay(checkoutday, orderid);
		if(checkin1!=null && checkout1!=null){
			int price_total = dao.price_total(checkinday, checkoutday, orderid);
			String update1 = "update Hotel_orderBean set checkin=:checkin1 ,checkout=:checkout1,price_total=:price_total where orderid=:orderid";
			Query query = this.sessionFactory.getCurrentSession().createQuery(update1);
			query.setParameter("checkin1", checkin1);
			query.setParameter("checkout1", checkout1);
			query.setParameter("price_total", price_total);
			query.setParameter("orderid",orderid);
			int b = query.executeUpdate();
			return b;
		}
		return 0;
	}
	public List<Integer> selectRoomid(int orderid){
		Query query = this.sessionFactory.getCurrentSession().createQuery("select roomid from Order_detailsBean where orderid = :orderid");
		query.setParameter("orderid",orderid);
		return(List<Integer>)query.list();
	}
	public List selectForRoomPrice(int roomid){
		Query query = this.sessionFactory.getCurrentSession().createQuery("select price from RoomBean where roomid=:roomid");
		query.setParameter("roomid", roomid);
		return (List)query.list();
	}
	public java.util.Date checkinDay(java.util.Date checkinday,int orderid){
		Hotel_orderBeanDAOHibernate dao = new Hotel_orderBeanDAOHibernate(sessionFactory);
		List<Integer> roomid = dao.selectRoomid(orderid);
		String a ="select yearday from Year_roomsBean where yearday=:checkinday and roomid= :roomid and (select yr.room_numbers from Year_roomsBean as yr where yr.yearday=:checkinday and yr.roomid=:roomid)>0";
		Query query = null ;
		int b = 0;
		int i=0;
		for(i=0;i<roomid.size();i++){
			query = this.sessionFactory.getCurrentSession().createQuery(a);
			query.setParameter("checkinday", checkinday);
			query.setParameter("roomid",roomid.get(i));
			if(query.list()!=null){
				b++;
			}
		}
		if(i==b){
			return (Date) query.uniqueResult();
		}
		return null;
	}
	public java.util.Date checkoutDay(java.util.Date checkoutday,int orderid){
		Hotel_orderBeanDAOHibernate dao = new Hotel_orderBeanDAOHibernate(sessionFactory);
		List<Integer> roomid = dao.selectRoomid(orderid);
		String a ="select yearday from Year_roomsBean where yearday=:checkoutday and roomid= :roomid and (select yr.room_numbers from Year_roomsBean as yr where yr.yearday=:checkoutday and yr.roomid=:roomid)>0";
		Query query = null ;
		int b = 0;
		int i=0;
		for(i=0;i<roomid.size();i++){
			query = this.sessionFactory.getCurrentSession().createQuery(a);
			query.setParameter("checkoutday", checkoutday);
			query.setParameter("roomid",roomid.get(i));
			if(query.list()!=null){
				b++;
			}
		}
		if(i==b){
			return (Date) query.uniqueResult();
		}
		return null;
	}
	public int price_total(java.util.Date checkinday,java.util.Date checkoutday,int orderid){
		Hotel_orderBeanDAOHibernate dao = new Hotel_orderBeanDAOHibernate(sessionFactory);
		List<Integer> roomid = dao.selectRoomid(orderid);
		int true_price = 0;
		Day day = new Day();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String checkin = sdf.format(checkinday);
		String checkout = sdf.format(checkoutday);
		int a = day.howManyDays(checkin, checkout);
		for(int i=0;i<roomid.size();i++){
			Query query =this.sessionFactory.getCurrentSession().createQuery("select r.price*"+a+" from RoomBean as r where roomid=:roomid");
			query.setParameter("roomid", roomid.get(i));
			int temp_price=(int)query.uniqueResult();
			true_price = true_price+temp_price;
		}
		return true_price;
	}
	public java.util.Date select_checkin(int orderid){
		Query query =this.sessionFactory.getCurrentSession().createQuery("select checkin from Hotel_orderBean where orderid=:orderid");
		query.setParameter("orderid", orderid);
		return (Date)query.uniqueResult();
	}
	public java.util.Date select_checkout(int orderid){
		Query query =this.sessionFactory.getCurrentSession().createQuery("select checkout from Hotel_orderBean where orderid=:orderid");
		query.setParameter("orderid", orderid);
		return (Date)query.uniqueResult();
	}
	
}

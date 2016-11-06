package model.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cht.model.misc.SQLStr;
import model.Hotel_orderBean;
import model.Order_detailsBean;
import model.RoomBean;
import model.Year_roomsBean;
import model.misc.testInsertdate;

public class Year_roomsDAOHibernate {
	private SessionFactory sessionFactory;
	static String orderday ="2016/10/1";
	static String chinkinday = "2016/10/2";
	static String chinkoutday = "2016/10/4";
	public Year_roomsDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		getsession.getCurrentSession().beginTransaction();
		Session session = getsession.getCurrentSession();
		try {
//			Hotel_orderBeanDAOHibernate dao =(Hotel_orderBeanDAOHibernate)context.getBean("hotel_orderBeanDAO");
//			Hotel_orderBean bean1 = new Hotel_orderBean();
//			bean1.setMemberid(1);
//			bean1.setPrice_total(3000);
//			Order_detailsDAOHibernate dao1 = (Order_detailsDAOHibernate)context.getBean("order_detailsDAO");
//			Order_detailsBean bean3 = new Order_detailsBean();
//			Order_detailsBean bean4 = new Order_detailsBean();
//			Order_detailsBean bean5 = new Order_detailsBean();
//			Order_detailsBean [] bean2 = {bean3,bean4,bean5};
//			int orderid=0;
//			try {
//				orderid = dao.insert(bean1);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			int[] roomid ={1,2};
//			int[] price ={1000,2000};
//			int[] peoplenum = {2,3};
//			int[] number ={1,2};
//			String [] Spec ={"早餐要好吃",""};
//			for(int i=0;i<roomid.length;i++){
//			bean2[i].setOrderid(orderid);
//			bean2[i].setRoomid(roomid[i]);
//			bean2[i].setName("aa");
//			java.sql.Date date1 = null;
//			java.sql.Date date2 = null;
//			java.sql.Date date3 = null;
//			java.util.Date day1 = null;
//			java.util.Date day2 = null;
//			java.util.Date day3 = null;
//			try {
//				day1 = DateFormat.getDateInstance().parse(orderday);
//				day2 = DateFormat.getDateInstance().parse(chinkinday);
//				day3 = DateFormat.getDateInstance().parse(chinkoutday);
//				long time1 = day1.getTime();
//				long time2 = day2.getTime();
//				long time3 = day3.getTime();
//				date1 = new java.sql.Date(time1);
//				date2 = new java.sql.Date(time2);
//				date3 = new java.sql.Date(time3);
//			} catch (Exception e) {
//				
//			}
//		
//			bean2[i].setOrderdate(date1); 
//			bean2[i].setCheckin(date2);
//			bean2[i].setCheckout(date3);
//			bean2[i].setPrice(price[i]);
//			bean2[i].setPeoplenum(peoplenum[i]);
//			bean2[i].setNumber(number[i]);	 
//			bean2[i].setCellphone("0933818538");
//			bean2[i].setSpec(Spec[i]);
//			bean2[i].setStatus(true);
//			dao1.insert(bean2[i]);
//			Year_roomsDAOHibernate dao2 =(Year_roomsDAOHibernate)context.getBean("year_roomsDAO");
//			dao2.update_subtraction(number[i], day2, day3, roomid[i]);
	

//			}
//			Order_detailsDAOHibernate dao1 = (Order_detailsDAOHibernate)context.getBean("order_detailsDAO");
//			dao1.cancel_order(53, false);
			Year_roomsDAOHibernate dao2 =(Year_roomsDAOHibernate)context.getBean("year_roomsDAO");
			RoomBean bean = new RoomBean();
			bean.setRoomid(8);
			bean.setNumber(3);
			try {
				dao2.insert(bean, 2016, 11, 30, session);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			for(int i=0;i<roomid.length;i++){
//				dao2.update_add(53, roomid[i], day2, day3);
//			}
		
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}

	public void update_subtraction(int number,java.util.Date checkinday,String checkoutday,int roomid){
	String update_subtraction = "UPDATE Year_roomsBean SET room_numbers = room_numbers-? where yearday BETWEEN ? and ? and roomid= ?";
	Day day = new Day();
	Date checkout2 = day.getSpecifiedDayBefore(checkoutday);
	Query query = sessionFactory.getCurrentSession().createQuery(update_subtraction);
		query.setParameter(0,number);
		query.setParameter(1, checkinday);
		query.setParameter(2, checkout2);
		query.setParameter(3, roomid);
		query.executeUpdate();
	}
	public void update_add(int orderid,int roomid,java.util.Date checkinday,String checkoutday){
		String add = "UPDATE Year_roomsBean SET room_numbers = room_numbers+(select number from Order_detailsBean where orderid = :orderid and roomid =:roomid) where yearday BETWEEN :checkinday and :checkout2 and roomid= :roomid";
		Day day = new Day();
		Date checkout2 = day.getSpecifiedDayBefore(checkoutday);
		Query query = sessionFactory.getCurrentSession().createQuery(add);
		query.setParameter("orderid",orderid);
		query.setParameter("roomid", roomid);
		query.setParameter("checkinday", checkinday);
		query.setParameter("checkout2", checkout2);
		query.executeUpdate();
	}
	public int insert(RoomBean bean,int year,int month,int day,Session session) throws ParseException{
		int n=0;
		for(int i=1;i<=day;++i){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = (java.util.Date) sdf.parse(year+"-"+month+"-"+i);
			
			Year_roomsBean data = new Year_roomsBean();
			data.setRoomid(bean.getRoomid());
			data.setYearday(date);
			data.setRoom_numbers(bean.getNumber());
			n=(Integer)session.save(data);
		}
		return n;
	}
	
	public Year_roomsBean get(int roomid, java.util.Date checkin, java.util.Date checkout){
		Query query = this.getSession().createQuery("From Year_roomsBean yr where roomid = ? and yr.yearday BETWEEN ? and ? order by yr.yearday desc");
		query.setMaxResults(1);
		return (Year_roomsBean)query.uniqueResult();
	}
	

}

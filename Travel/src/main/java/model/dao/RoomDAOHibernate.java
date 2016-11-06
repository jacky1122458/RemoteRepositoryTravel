package model.dao;


import java.text.*;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.RoomBean;

public class RoomDAOHibernate {
	private SessionFactory sessionFactory;
	public RoomDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		try {
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			RoomDAOHibernate dao =(RoomDAOHibernate)context.getBean("roomDAO");
			java.sql.Date date2 = null;
			java.sql.Date date3 = null;
			java.util.Date day2 = null;
			String day3 = null;
			try {
				day2 = DateFormat.getDateInstance().parse("2016/11/10");
				day3 = "2016/11/13";
				long time2 = day2.getTime();
				//long time3 = day3.getTime();
				date2 = new java.sql.Date(time2);
				//date3 = new java.sql.Date(time3);
			} catch (Exception e) {
				
			}
//			List<List> put = dao.select_By_HotelId(day2, day3,2, 2,3);
//			for(List a:put){
//				System.out.println(a);
//			}
//			RoomBean bean = new RoomBean();
//			bean.setHotelid(1);
//			bean.setName("aaa");
//			bean.setPrice(100);
//			bean.setPreprice(1111);
//			bean.setPeoplenum(2);
//			bean.setBedtype("adddd");
//			bean.setNumber(3);
//			bean.setArea(1);
//			bean.setStatus(true);
//			bean=dao.insert(bean);
//			System.out.println(bean);
//			dao.update(9, 1, "hehehe", 9999, 93333, 2, "雙人房",5, 1, true);
//			List<RoomBean> bean = dao.select_By_HotelId(2,true);
//			System.out.println("bean="+bean);
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	public RoomBean insert(RoomBean bean) {
		Session session = this.sessionFactory.getCurrentSession();
			session.save(bean);
			return bean;
	}
	public RoomBean update(int roomid,int hotelid,String roomname,int price,int weekdayrate,int peoplenum,String bedtype,int number,int area,boolean status){
		Session session = this.sessionFactory.getCurrentSession();
		RoomBean result = session.get(RoomBean.class,roomid);
		if(result!=null){
			result.setRoomid(roomid);
			result.setHotelid(hotelid);
			result.setRoomname(roomname);
			result.setPrice(price);
			result.setWeekdayrate(weekdayrate);
			result.setPeoplenum(peoplenum);
			result.setBedtype(bedtype);
			result.setNumber(number);
			result.setArea(area);
			result.setStatus(status);
			return result;
		}
		return null;
	}
	public RoomBean delete_updata(int roomid,boolean status){
		Session session = this.sessionFactory.getCurrentSession();
		RoomBean result = session.get(RoomBean.class,roomid);
		if(result!=null){
			result.setRoomid(roomid);
			result.setStatus(status);
			return result;
		}
		return null;
	}
	public List<List> select_By_HotelId(String checkin1 ,String checkout1,int hotelid,int peoplenum,long room_numbers,int roomid ) throws Exception {
		Day day = new Day();
		Date checkin = day.getCheckin(checkin1);
		Date checkout2 = day.getCheckin(checkout1);		
			if(peoplenum<=4){
				peoplenum =1;
				String a = "select new list(r.roomid,r.roomname,r.price,r.peoplenum,MIN(yr.room_numbers),r.bedtype) from RoomBean as r join r.hb as h join r.YRFR as yr where yr.yearday BETWEEN :checkin and :checkout2 and (select MIN(yr.room_numbers) from Year_roomsBean as yr join yr.roombean as r join r.hb where yr.yearday between :checkin and :checkout2 and r.roomid=:roomid group by r.roomid)>0 and h.hotelid=:hotelid and r.peoplenum >=:peoplenum and r.roomid=:roomid group by r.roomid,r.roomname,r.price,r.peoplenum,r.bedtype having (select count(*) from Year_roomsBean as yr where yr.yearday BETWEEN :checkin and :checkout2 and (select MIN(yr.room_numbers) from Year_roomsBean as yr join yr.roombean as r join r.hb where yr.yearday between :checkin and :checkout2 and r.roomid=:roomid group by r.roomid)>0)=(select count(*) from Year_roomsBean as yr where yr.yearday BETWEEN :checkin and :checkout2 and (select MIN(yr.room_numbers) from Year_roomsBean as yr join yr.roombean as r join r.hb where yr.yearday between :checkin and :checkout2 and r.roomid=:roomid group by r.roomid)>=0) and (select SUM(yr.room_numbers) from Year_roomsBean as yr  join yr.roombean as r where yr.yearday between :checkin and :checkout2 and r.hotelid=:hotelid)>=:room_numbers  order by r.peoplenum ";
				Query query = this.sessionFactory.getCurrentSession().createQuery(a);
				query.setParameter("checkin", checkin);
				query.setParameter("checkout2", checkout2);
				query.setParameter("hotelid", hotelid);
				query.setParameter("peoplenum", peoplenum);
				query.setParameter("room_numbers", room_numbers);
				query.setParameter("roomid",roomid);
				List<List> data1 = (List<List>)query.list();
				 System.out.println("List<List>"+data1);
				 System.out.println("被呼叫A");
					return data1;
			}else{
				String b = "select new list(r.roomid,r.roomname,r.price,r.peoplenum,MIN(yr.room_numbers),r.bedtype) from RoomBean as r join r.hb as h join r.YRFR as yr where yr.yearday BETWEEN :checkin and :checkout2 and (select MIN(yr.room_numbers) from Year_roomsBean as yr join yr.roombean as r join r.hb where yr.yearday between :checkin and :checkout2 and r.roomid=:roomid group by r.roomid)>0 and h.hotelid=:hotelid  and r.roomid=:roomid group by r.roomid,r.roomname,r.price,r.peoplenum,r.bedtype having (select count(*) from Year_roomsBean as yr where yr.yearday BETWEEN :checkin and :checkout2 and (select MIN(yr.room_numbers) from Year_roomsBean as yr join yr.roombean as r join r.hb where yr.yearday between :checkin and :checkout2 and r.roomid=:roomid group by r.roomid)>0)=(select count(*) from Year_roomsBean as yr where yr.yearday BETWEEN :checkin and :checkout2 and (select MIN(yr.room_numbers) from Year_roomsBean as yr join yr.roombean as r join r.hb where yr.yearday between :checkin and :checkout2 and r.roomid=:roomid group by r.roomid)>=0) and (select SUM(yr.room_numbers) from Year_roomsBean as yr  join yr.roombean as r where yr.yearday between :checkin and :checkout2 and r.hotelid=:hotelid)>=:room_numbers order by r.peoplenum DESC";
				Query query = this.sessionFactory.getCurrentSession().createQuery(b);
				query.setParameter("checkin", checkin);
				query.setParameter("checkout2", checkout2);
				query.setParameter("hotelid", hotelid);
				query.setParameter("room_numbers", room_numbers);
				query.setParameter("roomid",roomid);
				List<List> data2 = query.list();
				 System.out.println("被呼叫B");
				 return data2;
			}
	}
	public RoomBean searchOneRoom(int roomid){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from RoomBean where roomid =:roomid");
		query.setParameter("roomid", roomid);
		RoomBean bean=(RoomBean)query.list();
		return bean;
	}
	
}

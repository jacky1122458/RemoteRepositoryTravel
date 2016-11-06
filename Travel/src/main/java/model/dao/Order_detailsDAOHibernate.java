package model.dao;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Hotel_orderBean;
import model.Order_detailsBean;
import model.RoomBean;

public class Order_detailsDAOHibernate {
	private SessionFactory sessionFactory;
	public Order_detailsDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		getsession.getCurrentSession().beginTransaction();
		Session session = getsession.getCurrentSession();
		try {
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
				java.util.Date day3 = DateFormat.getDateInstance().parse("2016/10/11");
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
			int a=0;
			try {
				a = dao.insert(bean1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Day days = new Day();
			int howManyDay=days.howManyDays("2016/10/10","2016/10/11");
			
			Order_detailsDAOHibernate dao1 = (Order_detailsDAOHibernate)context.getBean("order_detailsDAO");
			int[] roomid ={1,2};
			Order_detailsBean bean3 = new Order_detailsBean();
			Order_detailsBean bean4 = new Order_detailsBean();
			Order_detailsBean bean5 = new Order_detailsBean();
			Order_detailsBean [] bean2 = {bean3,bean4,bean5};
			int[] peoplenum = {2,3};
			int[] number = {1,2};
			for(int i=0;i<roomid.length;i++){
				List<Integer> price =(List<Integer>)dao1.selectPrice(roomid[i]);
				int[] priceForOrder = {price.get(0)*howManyDay};
				bean2[i].setOrderid(a);
				bean2[i].setRoomid(roomid[i]);
				bean2[i].setName("王先生");
				bean2[i].setPrice(priceForOrder[0]);
				bean2[i].setPeoplenum(peoplenum[i]);
				bean2[i].setNumber(number[i]);	 
				bean2[i].setCellphone("0933818538");
				bean2[i].setSpec("要早餐");
				bean2[i].setStatus(true);
				dao1.insert(bean2[i]);
			}
//			List<Order_detailsBean> result = dao1.select(51);
//			System.out.println(result);

			
//			dao1.update(3,"abc","0911223344");
//			dao1.cancel_order(33, false);
			session.getTransaction().commit();
			
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	
	public Order_detailsBean insert(Order_detailsBean bean2){
		Session session = this.sessionFactory.getCurrentSession();
		 session.save(bean2);
		return bean2;
	}
	public List<Order_detailsBean> select(){
		Query query =this.sessionFactory.getCurrentSession().createQuery("from Order_detailsBean");
		return (List<Order_detailsBean>)query.list();
	}
	public List<List> select(int orderid){
		Query query =this.sessionFactory.getCurrentSession().createQuery("select new list(OB.orderid,h.hotelname,r.roomname,OB.name,OB.price,OB.peoplenum,OB.number,OB.cellphone,OB.spec,OB.Status,OB.roomid) from Order_detailsBean as OB join OB.roombean as r join r.hb as h where orderid=:orderid");
		query.setParameter("orderid",orderid);
		return (List<List>)query.list();
	}
	//10/25修改更新方法
	public int update(int orderid,String checkinday,String checkoutday){
		Order_detailsDAOHibernate dao = new Order_detailsDAOHibernate(sessionFactory);
		Hotel_orderBeanDAOHibernate dao1 = new Hotel_orderBeanDAOHibernate(sessionFactory);
		List<Integer> roomid = dao1.selectRoomid(orderid);
		List<List> price = dao.selectRoomPrice(orderid, checkinday, checkoutday);
		System.out.println("price aaaa"+price);
		int aa =0 ;
		String update1 = "update Order_detailsBean set price=:price where orderid=:orderid and roomid=:roomid";
		for(int i=0;i<roomid.size();i++){
				Query query = sessionFactory.getCurrentSession().createQuery(update1);
				query.setParameter("orderid", orderid);
				query.setParameter("price", price.get(i).get(0));
				query.setParameter("roomid",roomid.get(i));
				aa =query.executeUpdate();
			}
		
			return aa;
		}	
	public int cancel_order(int orderid,boolean status){
		String cancel = "update Order_detailsBean set status =:status where orderid=:orderid";
		Query query = sessionFactory.getCurrentSession().createQuery(cancel);
		query.setParameter("status", status);
		query.setParameter("orderid", orderid);
		int cancel_numbers = query.executeUpdate();
		return cancel_numbers;
	}
	public List<Integer> selectPrice(int roomid){
			String selectPrice = "select price from RoomBean where roomid =:roomid";
			Query query = sessionFactory.getCurrentSession().createQuery(selectPrice);
			query.setParameter("roomid", roomid);
		return (List<Integer>)query.list();
	}
	//10/25新增
	public List<List> selectRoomPrice(int orderid,String checkinday,String checkoutday){
		Day day =new Day();
		int days =day.howManyDays(checkinday, checkoutday);
		Hotel_orderBeanDAOHibernate dao = new Hotel_orderBeanDAOHibernate(sessionFactory);
		List<Integer> roomid = dao.selectRoomid(orderid);
		int count1 = 0;
		int i = 0;
		System.out.println(roomid);
		Query query =null;
		List<List> list = new ArrayList<>();
		for( i=0;i<roomid.size();i++){
			query = this.sessionFactory.getCurrentSession().createQuery("select (r.price*"+days+") from Order_detailsBean as od join od.roombean as r where od.orderid=:orderid and od.roomid=:roomid");
			query.setParameter("orderid", orderid);
			query.setParameter("roomid",roomid.get(i));
			count1++;
			list.add(query.list());
		}
		
			return list;
	}
	//10/25新增
	public List<Integer> selectRoomNumbers(int orderid,int roomid){
		Query query = this.sessionFactory.getCurrentSession().createQuery("select number from Order_detailsBean where orderid = :orderid and roomid =:roomid");
		query.setParameter("orderid",orderid);
		query.setParameter("roomid",roomid);
		System.out.println("numbers"+query.list());
		return (List<Integer>)query.list();
		
	}
}

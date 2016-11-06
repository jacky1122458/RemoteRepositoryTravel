package model.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import model.RoomBean;

import model.Year_roomsBean;


public class testInsertdate {
	private SessionFactory sessionFactory;
	public testInsertdate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public static void main(String[] args) throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		try {
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			
			RoomBean room = (RoomBean)session.get(RoomBean.class, 1);
			testInsertdate tid = (testInsertdate)context.getBean("testInsertdate");
			
			int n =tid.insert(room,2016,10,30,session);
			
			System.out.println(n);
			
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
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

}

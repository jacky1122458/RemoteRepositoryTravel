package cht.model.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

import cht.model.misc.HibernateUtil;
import model.RoomBean;
import model.Year_roomsBean;

public class testInsertDate {

	public static void main(String[] args) throws ParseException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			RoomBean room = (RoomBean)session.get(RoomBean.class, 3);
			testInsertDate tid = new testInsertDate();
			
			int n =tid.insert(room,2016,10,30,session);
			
			System.out.println(n);
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
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

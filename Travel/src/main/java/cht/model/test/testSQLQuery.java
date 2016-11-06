package cht.model.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.type.StandardBasicTypes;

import cht.model.Hotel;
import cht.model.misc.HibernateUtil;

public class testSQLQuery {

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			//1
//			String sql1 = "SELECT h.*,r.* ,row_number() over(partition by h.hotelid order by peoplenum,price)ran FROM hotel h JOIN room r ON h.hotelid = r.hotelid WHERE h.status=1 and peoplenum >= ?  and number>=? and hotelname LIKE ? ";
//			SQLQuery query1 = HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql1);
//			query1.addEntity("h",Hotel.class);
//			//query.addEntity("r",Room.class);
//			query1.addJoin("r","h.rooms");
//			query1.setInteger(0, 1);
//			query1.setInteger(1, 1);
//			query1.setString(2, "%愛%");
//			List list = query1.list();
//			
//			for(Iterator iterator = list.iterator();iterator.hasNext();){
//				Object[] objects = (Object[]) iterator.next();
//				Hotel hotel = (Hotel) objects[0];
//				Room room = (Room) objects[1];
//				System.out.println("Hotel : "+hotel);
//				System.out.println("Room : "+room);
//				System.out.println("================");
//			}
			//2
//			SQLQuery query2 = HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql1);
//			query2.addScalar("roomid",StandardBasicTypes.INTEGER);
//			query2.addScalar("roomname",StandardBasicTypes.STRING);
//			query2.addScalar("price",StandardBasicTypes.INTEGER);
//			query2.addScalar("weekdayrate",StandardBasicTypes.INTEGER);
//			query2.addEntity("h",Hotel.class);
//			query2.addJoin("r", "h.rooms");
//			query2.setInteger(0,1);
//			query2.setInteger(1,1);
//			query2.setString(2,"%愛%");
//			List list2 = query2.list();
//			for(Iterator iterator = list2.iterator();iterator.hasNext();){
//				Object[] objects = (Object[])iterator.next();
//				//Hotel hotel = (Hotel) objects[0];
//				//System.out.println("Hotel : "+hotel);
//				System.out.println("r.roomid : "+objects[0]);
//				System.out.println("r.name : "+objects[1]);
//				System.out.println("r.price : "+objects[2]);
//				System.out.println("r.weekdayrate : "+objects[3]);
//				System.out.println("================");
//			}
			
			//3
			String sql2 = "SELECT h.*,r.roomid,roomname,r.price,r.weekdayrate ,row_number() over(partition by h.hotelid order by peoplenum,price)ran FROM hotel h JOIN room r ON h.hotelid = r.hotelid WHERE h.status=1 and peoplenum >= ?  and number>=? and hotelname LIKE ? ";
			SQLQuery query3 = HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql2);
			query3.addScalar("roomid",StandardBasicTypes.INTEGER);
			query3.addScalar("roomname",StandardBasicTypes.STRING);
			query3.addScalar("price",StandardBasicTypes.INTEGER);
			query3.addScalar("weekdayrate",StandardBasicTypes.INTEGER);
			query3.addEntity(Hotel.class);
			//query3.addJoin("r", "h.rooms");  //加載物件需select全部的資料
			query3.setInteger(0,1);
			query3.setInteger(1,1);
			query3.setString(2,"%愛%");
			List list3 = query3.list();
			for(Iterator iterator = list3.iterator();iterator.hasNext();){
				Object[] objects = (Object[])iterator.next();
				System.out.println("r.roomid : "+objects[0]);
				System.out.println("r.name : "+objects[1]);
				System.out.println("r.price : "+objects[2]);
				System.out.println("r.weekdayrate : "+objects[3]);
				System.out.println("Hotel : "+objects[4]);
				System.out.println("================");
			}
			
			//4 test
//			SQLQuery query4 = HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql2);
//			query4.addScalar("roomid",StandardBasicTypes.INTEGER);
//			query4.addScalar("roomname",StandardBasicTypes.STRING);
//			query4.addScalar("price",StandardBasicTypes.INTEGER);
//			query4.addScalar("weekdayrate",StandardBasicTypes.INTEGER);
//			query4.addEntity("h",Hotel.class);
//			query4.setResultTransformer(Transformers.aliasToBean(ReturnRoom.class));
//			
//			query4.setInteger(0,1);
//			query4.setInteger(1,1);
//			query4.setString(2,"%愛%");
//			List list4 = query4.list();
//			System.out.println(list4);
//			System.out.println("================");
//			
//			for(Iterator iterator = list4.iterator();iterator.hasNext();){
//				ReturnRoom room = (ReturnRoom)iterator.next();
//				System.out.println(room);
//				System.out.println("================");
//			}
//			
			
			//5
//			String sql3 = "SELECT r.roomid,roomname,r.price,r.weekdayrate ,row_number() over(partition by h.hotelid order by peoplenum,price)ran FROM hotel h JOIN room r ON h.hotelid = r.hotelid WHERE h.status=1 and peoplenum >= ?  and number>=? and hotelname LIKE ? ";
//			SQLQuery query5 = HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql3);
//			query5.addScalar("roomid",StandardBasicTypes.INTEGER);
//			query5.addScalar("roomname",StandardBasicTypes.STRING);
//			query5.addScalar("price",StandardBasicTypes.INTEGER);
//			query5.addScalar("weekdayrate",StandardBasicTypes.INTEGER);
//			query5.setResultTransformer(Transformers.aliasToBean(ReturnRoom.class));
//			
//			query5.setInteger(0,1);
//			query5.setInteger(1,1);
//			query5.setString(2,"%愛%");
//			List list5 = query5.list();
//			System.out.println(list5);
//			System.out.println("================");
//			
//			for(Iterator iterator = list5.iterator();iterator.hasNext();){
//				ReturnRoom room = (ReturnRoom)iterator.next();
//				System.out.println(room);
//				System.out.println("================");
//			}
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}

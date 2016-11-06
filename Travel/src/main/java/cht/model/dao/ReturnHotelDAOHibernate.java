package cht.model.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cht.model.ReturnHotel;
import cht.model.misc.HibernateUtil;
import cht.model.misc.SQLStr;

public class ReturnHotelDAOHibernate {
	
	private SessionFactory sessionFactory;
	public ReturnHotelDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	//旅館住址
	public List<ReturnHotel> selectByAddress(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out){
		SQLQuery query = 
				this.getSession().createSQLQuery(SQLStr.ADDRESS);
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%");
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址  &價錢
	public List<ReturnHotel> selectByAddressPrice(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int pricetype){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixPrice(SQLStr.ADDRESS, pricetype));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%");
		return (List<ReturnHotel>)query.list();
	}
	
	//旅館住址 &類型
	public List<ReturnHotel> selectByAddress(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid){
		SQLQuery query = 
				this.getSession().createSQLQuery(SQLStr.ADDRESS_TYPE);
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址 &類型 &價錢
	public List<ReturnHotel> selectByAddress(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid, int pricetype){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixPrice(SQLStr.ADDRESS_TYPE, pricetype));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址&服務&房間設施
	public List<ReturnHotel> selectByAddress(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, String[] service, String[] facilities){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mix(SQLStr.ADDRESS,service,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%");
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址&服務&房間設施&價錢
	public List<ReturnHotel> selectByAddress(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, String[] service, String[] facilities,int price){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mix(SQLStr.ADDRESS,price,service,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%");
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址&類型&服務&房間設施
	public List<ReturnHotel> selectByAddress(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid, String[] service, String[] facilities){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mix(SQLStr.ADDRESS_TYPE,service,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址&旅館類型&服務&房間設施&價錢
	public List<ReturnHotel> selectByAddress(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid, String[] service, String[] facilities,int price){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mix(SQLStr.ADDRESS_TYPE,price,service,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址&服務
	public List<ReturnHotel> selectByAddreService(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, String[] service){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixService(SQLStr.ADDRESS,service));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%");
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址&服務&價錢
	public List<ReturnHotel> selectByAddreService(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, String[] service,int pricetype){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixService(SQLStr.ADDRESS,pricetype,service));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%");
		return (List<ReturnHotel>)query.list();
	}
	
	//旅館住址 &類型&服務
	public List<ReturnHotel> selectByAddreService(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid, String[] service){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixService(SQLStr.ADDRESS_TYPE,service));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址 &類型&服務&價錢
	public List<ReturnHotel> selectByAddreService(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid, String[] service,int pricetype){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixService(SQLStr.ADDRESS_TYPE,pricetype,service));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址&房間設施
	public List<ReturnHotel> selectByAddressFacilities(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, String[] facilities){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixFacilities(SQLStr.ADDRESS,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%");
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址&房間設施&價錢
	public List<ReturnHotel> selectByAddressFacilities(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, String[] facilities,int pricetype){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixFacilities(SQLStr.ADDRESS,pricetype,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%");
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址 &類型&房間設施
	public List<ReturnHotel> selectByAddressFacilities(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid, String[] facilities){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixFacilities(SQLStr.ADDRESS_TYPE,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("address","%"+address+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	//旅館住址 &類型&房間設施&價錢
	public List<ReturnHotel> selectByAddressFacilities(String address, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid, String[] facilities,int pricetype){
	SQLQuery query = 
			this.getSession().createSQLQuery(new SQLStr().mixFacilities(SQLStr.ADDRESS_TYPE,pricetype,facilities));
	setResult(query,peoplenum,roomnum,check_in,check_out);
	query.setString("address","%"+address+"%")
			.setInteger("typeid", typeid);
	return (List<ReturnHotel>)query.list();
	}
	
	//旅館名稱
	public List<ReturnHotel> selectByName(String name, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out){
		SQLQuery query = 
				this.getSession().createSQLQuery(SQLStr.NAME);
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("name","%"+name+"%");
		return (List<ReturnHotel>)query.list();
	}
	
	//旅館名稱&旅館類型
	public List<ReturnHotel> selectByName(String name, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid){
		SQLQuery query = 
				this.getSession().createSQLQuery(SQLStr.NAME_TYPE);
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("name","%"+name+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	
	//旅館名稱&服務&房間設施
	public List<ReturnHotel> selectByName(String name, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, String[] service, String[] facilities){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mix(SQLStr.NAME,service,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("name","%"+name+"%");
		return (List<ReturnHotel>)query.list();
	}
	//旅館名稱&類型&服務&房間設施
	public List<ReturnHotel> selectByName(String name, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid, String[] service, String[] facilities){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mix(SQLStr.NAME_TYPE,service,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("name","%"+name+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	
	//旅館名稱 &服務
	public List<ReturnHotel> selectByNameService(String name, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out,String[] service){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixService(SQLStr.NAME,service));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("name","%"+name+"%");
		return (List<ReturnHotel>)query.list();
	}
	//旅館名稱&旅館類型
	public List<ReturnHotel> selectByNameService(String name, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid,String[] service){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixService(SQLStr.NAME_TYPE,service));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("name","%"+name+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	
	//旅館名稱&房間設施
	public List<ReturnHotel> selectByNameFacilities(String name, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, String[] facilities){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixFacilities(SQLStr.NAME,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("name","%"+name+"%");
		return (List<ReturnHotel>)query.list();
	}
	//旅館名稱 &類型&房間設施
	public List<ReturnHotel> selectByNameFacilities(String name, int peoplenum, int roomnum, java.util.Date check_in, java.util.Date check_out, int typeid, String[] facilities){
		SQLQuery query = 
				this.getSession().createSQLQuery(new SQLStr().mixFacilities(SQLStr.NAME_TYPE,facilities));
		setResult(query,peoplenum,roomnum,check_in,check_out);
		query.setString("name","%"+name+"%")
			.setInteger("typeid", typeid);
		return (List<ReturnHotel>)query.list();
	}
	
	private SQLQuery setResult(SQLQuery query,int peoplenum, int roomnum, java.util.Date chick_in, java.util.Date chick_out){
		if(query !=null){
			query.addScalar("hotelid",StandardBasicTypes.INTEGER)
			.addScalar("hotelname",StandardBasicTypes.STRING)
			.addScalar("class_level",StandardBasicTypes.INTEGER)
			.addScalar("address",StandardBasicTypes.STRING)
			.addScalar("lat",StandardBasicTypes.DOUBLE)
			.addScalar("lng",StandardBasicTypes.DOUBLE)
			.addScalar("tol_avg",StandardBasicTypes.DOUBLE)
			.addScalar("total_comment",StandardBasicTypes.INTEGER)
			.addScalar("roomid",StandardBasicTypes.INTEGER)
			.addScalar("roomname",StandardBasicTypes.STRING)
			.addScalar("price",StandardBasicTypes.INTEGER)
			.addScalar("weekdayrate",StandardBasicTypes.INTEGER)
			.addScalar("peoplenum",StandardBasicTypes.INTEGER)
			.addScalar("bedtype",StandardBasicTypes.STRING)
			.setResultTransformer(Transformers.aliasToBean(ReturnHotel.class));
			
			query.setInteger("peoplenum",peoplenum)
			.setDate("chick_in",chick_in)
			.setDate("chick_out",chick_out)
			.setInteger("roomnum",roomnum)
			.setDate("dayin",chick_in)
			.setDate("dayout",chick_out);
		}
		return query;
	}
	
	public static void main(String[] args) throws ParseException{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		try {
			getsession.getCurrentSession().beginTransaction();
			
			ReturnHotelDAOHibernate dao = new ReturnHotelDAOHibernate(HibernateUtil.getSessionFactory());
			String[] service={"2","3"};
			String[] facilities={"2","3"};
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date chickin = (java.util.Date) sdf.parse("2016-10-01");
			java.util.Date chickout = (java.util.Date) sdf.parse("2016-10-03");
			List<ReturnHotel> results = dao.selectByAddress("台北",2,2,chickin,chickout);							//address
//			List<ReturnHotel> results = dao.selectByAddress("台北",2,2,"2016-10-1","2016-10-3",service,facilities); 		//address & service & facilities
//			List<ReturnHotel> results = dao.selectByAddress("台北",2,2,"2016-10-1","2016-10-3",1); 						//address & type
//			List<ReturnHotel> results = dao.selectByAddress("台北",2,2,"2016-10-1","2016-10-3",1,service,facilities); 	//address & type & service & facilities
//			List<ReturnHotel> results = dao.selectByAddreService("台北",2,2,"2016-10-1","2016-10-3",service);				//address & service
//			List<ReturnHotel> results = dao.selectByAddreService("台北",2,2,"2016-10-1","2016-10-3",1,service); 			//address & type & service
//			List<ReturnHotel> results = dao.selectByAddressFacilities("台北",2,2,"2016-10-1","2016-10-3",facilities);		//address & facilities
//			List<ReturnHotel> results = dao.selectByAddressFacilities("台北",2,2,"2016-10-1","2016-10-3",1,facilities); 	//address & type & facilities
//			
//			List<ReturnHotel> results = dao.selectByName("愛",2,2,"2016-10-1","2016-10-3");								//name
//			List<ReturnHotel> results = dao.selectByName("飛機",2,2,"2016-10-1","2016-10-3",service,facilities);			//name & service & facilities
//			List<ReturnHotel> results = dao.selectByName("愛",2,2,"2016-10-1","2016-10-3",3);							//name & type
//			List<ReturnHotel> results = dao.selectByName("飛機",2,2,"2016-10-1","2016-10-3",2,service,facilities);		//name & service & facilities
//			List<ReturnHotel> results = dao.selectByNameService("愛",2,2,"2016-10-1","2016-10-3",service);				//name & service
//			List<ReturnHotel> results = dao.selectByNameService("愛",2,2,"2016-10-1","2016-10-3",3,service);				//name & type & service
//			List<ReturnHotel> results = dao.selectByNameFacilities("飛機",2,2,"2016-10-1","2016-10-3",facilities);		//address & facilities
//			List<ReturnHotel> results = dao.selectByNameFacilities("飛機",2,2,"2016-10-1","2016-10-3",1,facilities); 		//address & type & facilities
			
			for(ReturnHotel bean :results){
				System.out.println(bean);
			}
			
			getsession.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
}

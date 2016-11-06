package cht.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cht.model.Card;
import cht.model.Hotel;
import cht.model.HotelPhoto;
import cht.model.HotelReview;
import cht.model.Service;
import cht.model.misc.HQLStr;
import cht.model.misc.HibernateUtil;
import model.RoomBean;

public class HotelDAOHibernate {
	//private static final String Hqlstr = "select h.hotelid as hid,h.name,r.hotelid as hid,r.name,r.peoplenum as people,r.price from Hotel h join h.rooms r WHERE h.status=1 and peoplenum >=2 and number>=1 order by r.hotelid,r.peoplenum,r.price";
	
	private SessionFactory sessionFactory =null;
	public HotelDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	//id
	public Hotel selectById(int hotelid){
		return (Hotel) this.getSession().get(Hotel.class,hotelid);
	}
	
	//name
	public List<Hotel> selectByName(String hotelname){
		Query query = this.getSession().createQuery("from Hotel where hotelname like ? ");
		query.setString(0, "%"+hotelname+"%");
		System.out.println(query.list());
		return (List<Hotel>) query.list();
	}
	//address
	public List<Hotel> selectByAddress(String address){
		Query query = this.getSession().createQuery("from Hotel where address like ? ");
		query.setString(0, "%"+address+"%");
		return (List<Hotel>) query.list();
	}
	//all
	public List<Hotel> select(){
		Query query = this.getSession().createQuery("from Hotel");
		return (List<Hotel>) query.list();
	}
	//新增
	public Hotel insert(Hotel bean){
		//Hotel result = (Hotel) this.getSession().get(Hotel.class,bean.getHotelid());
		List<Hotel> result= this.selectByName(bean.getHotelname());
		if(result.size()==0){
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
	//修改
	public Hotel update(Hotel bean){
		
		Hotel result = (Hotel) 
				this.getSession().get(Hotel.class, bean.getHotelid());
		if(result!=null) {
			this.getSession().update(bean);
		}
		return result;
	}
	
	//刪除
	public boolean delete (int Hotelid){
		Hotel bean = (Hotel) 
				this.getSession().get(Hotel.class, Hotelid);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
	public Set<RoomBean> getHotelrooms(int hotelid){
		return (Set<RoomBean>) selectById(hotelid).getRooms();
	}
	
	public Set<HotelPhoto> getHotelphoto(int hotelid){
		return (Set<HotelPhoto>) selectById(hotelid).getPhotos();
	}
	
	public Set<Service> getHotelservice(int hotelid){
		return (Set<Service>) selectById(hotelid).getServices();
	}
	
	public Set<Card> getHotelcard(int hotelid){
		return (Set<Card>) selectById(hotelid).getCards();
	}
	
	public Set<HotelReview> getHotelreviews(int hotelid){
		return (Set<HotelReview>) selectById(hotelid).getReviews();
	}
	//AddressType
	public List<Hotel> selectByAddressType(String address, int typeid){
		Query query = this.getSession().createQuery("From Hotel where typeid = :typeid and address like :address ");
		query.setString("address", "%"+address+"%");
		query.setInteger("typeid", typeid);
		return (List<Hotel>) query.list();
	}
	
	//AddressService
	public List<Hotel> selectByAddressService(String address, String[] service){
		Query query = this.getSession().createQuery(new HQLStr().mixAddressService(service));
		query.setString("address", "%"+address+"%");
		List<Object[]> beans = query.list();
		List<Hotel> result =null;
		if(!beans.isEmpty()){
			result = new ArrayList<Hotel>();
			
			for(Object[] obj : beans){
				Hotel bean = this.changeHotel(obj);
				result.add(bean);
			}
		}
		return result;
	}
	//AddressTypeService
	public List<Hotel> selectByAddressTypeService(String address, String[] service, int typeid){
		Query query = this.getSession().createQuery(new HQLStr().mixAddressTypeService(service));
		query.setString("address", "%"+address+"%");
		query.setInteger("typeid", typeid);
		List<Object[]> beans = query.list();
		List<Hotel> result =null;
		if(!beans.isEmpty()){
			result = new ArrayList<Hotel>();
			
			for(Object[] obj : beans){
				Hotel bean = this.changeHotel(obj);
				result.add(bean);
			}
		}
		return result;
	}
	
	//NameType
	public List<Hotel> selectByNameType(String name, int typeid) {
		Query query = this.getSession().createQuery("From Hotel where typeid = :typeid and hotelname like :hotelname ");
		query.setString("hotelname", "%" + name + "%");
		query.setInteger("typeid", typeid);
		return (List<Hotel>) query.list();
	}
	//NameService
	public List<Hotel> selectByNameService(String name, String[] service) {
		Query query = this.getSession().createQuery(new HQLStr().mixNameService(service));
		query.setString("hotelname", "%" + name + "%");
		List<Object[]> beans = query.list();
		List<Hotel> result =null;
		if(!beans.isEmpty()){
			result = new ArrayList<Hotel>();
			
			for(Object[] obj : beans){
				Hotel bean = this.changeHotel(obj);
				result.add(bean);
			}
		}
		return result;
	}
	//NameTypeService
	public List<Hotel> selectByNameTypeService(String name, String[] service, int typeid) {
		Query query = this.getSession().createQuery(new HQLStr().mixNameTypeService(service));
		query.setString("hotelname", "%" + name + "%");
		query.setInteger("typeid", typeid);
		List<Object[]> beans = query.list();
		List<Hotel> result =null;
		if(!beans.isEmpty()){
			result = new ArrayList<Hotel>();
			
			for(Object[] obj : beans){
				Hotel bean = this.changeHotel(obj);
				result.add(bean);
			}
		}
		return result;
	}
	
	//getRoomsStatus
	public List<RoomBean> getRoomsStatus(int hotelid, java.util.Date checkin, java.util.Date checkout){
		Query query = 
				this.getSession().createQuery("select r, MIN(yr.room_numbers) From RoomBean r join r.YRFR yr where r.status = 1 and yr.room_numbers > 0 and r.hotelid = :hotelid and yr.yearday BETWEEN :checkin and :checkout group by r.roomid, r.hotelid, r.roomname, r.price, r.weekdayrate, r.peoplenum, r.bedtype, r.number, r.area, r.status having count(*)=DATEDIFF(day , :checkin , :checkout )+1)");
		query.setInteger("hotelid", hotelid);
		query.setDate("checkin", checkin);
		query.setDate("checkout", checkout);
		List<Object[]> lists = (List<Object[]>)query.list();
		List<RoomBean> result = null;
		if(lists!=null){
			result = new ArrayList<RoomBean>();
			for(Object[] obj : lists){
				RoomBean bean = (RoomBean)obj[0];
				this.getSession().evict(bean);
				bean.setNumber((Integer)obj[1]);
				result.add(bean);
			}
		}
		System.out.println(result);
		return result;
	}
	
	public Hotel changeHotel(Object[] obj){
			Hotel bean = new Hotel();
			
			bean.setHotelid((int)(obj[0]));
			bean.setHotelname((String)(obj[1]));
			bean.setTypeid((int)(obj[2]));
			bean.setPhone((String)(obj[3]));
			bean.setClass_level((Integer)(obj[4]));
			bean.setCheck_in((String)(obj[5]));
			bean.setCheck_out((String)(obj[6]));
			bean.setPrice_bed((Integer)(obj[7]));
			bean.setYears((Integer)(obj[8]));
			bean.setAddress((String)(obj[9]));
			bean.setLanguage((String)(obj[10]));
			bean.setDescription((String)(obj[11]));
			bean.setNote((String)(obj[12]));
			bean.setLat((Double)(obj[13]));
			bean.setLng((Double)(obj[14]));
			bean.setTol_avg((Double)(obj[15]));
			bean.setTotal_comment((Integer)(obj[16]));
			bean.setStatus((Boolean)(obj[17]));
			
			return bean;
	}
	
	//getAvg
	public Map<String, Object> getReviewAvg(int hotelid){
		Map<String, Object> fraction =null;
		
		Set<HotelReview> reviews = this.getHotelreviews(hotelid);
		
		if(reviews.size()!=0){
			Double cleanliness = (double) 0;
			Double comfort = (double) 0;
			Double location = (double) 0; 
			Double facilities = (double) 0; 
			Double staff = (double) 0;
			Double cp = (double) 0;
			Double total = (double) 0;
			
			for(HotelReview review : reviews){
				cleanliness=cleanliness+new Double(review.getCleanliness());
				comfort=comfort+new Double(review.getComfort());
				location=location+new Double(review.getLocation());
				facilities=facilities+new Double(review.getFacilities());
				staff=staff+new Double(review.getStaff());
				cp=cp+new Double(review.getCp());
				total=total+new Double(review.getTotal());
			}
			
			cleanliness=(cleanliness/reviews.size());
			comfort=(comfort/reviews.size());
			location=(location/reviews.size());
			facilities=(facilities/reviews.size());
			staff=(staff/reviews.size());
			cp=(cp/reviews.size());
			total=(total/reviews.size());
			
			fraction = new HashMap<String, Object>();
			fraction.put("total_comment", reviews.size());
			fraction.put("cleanliness", cleanliness);
			fraction.put("comfort", comfort);
			fraction.put("location", location);
			fraction.put("facilities", facilities);
			fraction.put("staff", staff);
			fraction.put("cp", cp);
			fraction.put("total", total);
			
			return fraction;
		}
		return fraction;
		
	}
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			HotelDAOHibernate dao = new HotelDAOHibernate(HibernateUtil.getSessionFactory());
			

			
//			System.out.println(dao.selectById(1));			//id
//			System.out.println(dao.selectByName("高雄"));		//name
//			System.out.println(dao.selectByAddress("台北"));	//address
//			System.out.println(dao.select());				//all
//			System.out.println(dao.getHotelphoto(2));		//Hotelphoto
			
			
//			//新增
//			Hotel insert = new Hotel();
//			//insert.setHotelid(9);
//			insert.setHotelname("海之居");
//			insert.setPhone("xxx");
//			insert.setAddress("xxx");
//			insert.setLat(Double.valueOf("111"));
//			insert.setLng(Double.valueOf("111"));
//			insert.setStatus(true);
//			insert.setTypeid(5);
//			System.out.println(dao.insert(insert));
//			
//			//update
//			Hotel update = insert;
//			update.setHotelname("火焰居");
//			System.out.println(dao.update(update));
//			
//			System.out.println(dao.delete(insert.getHotelid()));	//delete
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}

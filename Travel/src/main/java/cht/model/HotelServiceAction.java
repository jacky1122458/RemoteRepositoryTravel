package cht.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cht.model.dao.HotelDAOHibernate;
import cht.model.dao.ReturnHotelDAOHibernate;
import model.RoomBean;
import model.RoomService;
import model.Year_roomsBean;
import model.dao.Year_roomsDAOHibernate;

public class HotelServiceAction {
	private HotelDAOHibernate hotelDAO;
	private ReturnHotelDAOHibernate returnHotelDAO;
	public HotelServiceAction(ReturnHotelDAOHibernate returnHotelDAO, HotelDAOHibernate hotelDAO){
		this.returnHotelDAO = returnHotelDAO;
		this.hotelDAO = hotelDAO;
	}
	public List<ReturnHotel> selectHotel(String str, java.util.Date checkin, 
			java.util.Date checkout, int roomnum, int peoplenum){
		return returnHotelDAO.selectByAddress(str, peoplenum, roomnum, checkin, checkout);
	}
	
	//typeid
	public List<ReturnHotel> selectHotelType(String str, java.util.Date checkin, 
			java.util.Date checkout, int roomnum, int peoplenum, int typeid){
		return returnHotelDAO.selectByAddress(str, peoplenum, roomnum, checkin, checkout, typeid);
	}
	
	//service
	public List<ReturnHotel> selectHotel(String str, java.util.Date checkin, 
			java.util.Date checkout, int roomnum, int peoplenum,String[] service){
		return returnHotelDAO.selectByAddreService(str, peoplenum, roomnum, checkin, checkout, service);
	}
	
	//price
	public List<ReturnHotel> selectHotel(String str, java.util.Date checkin, 
			java.util.Date checkout, int roomnum, int peoplenum, int pricetype){
		return returnHotelDAO.selectByAddressPrice(str, peoplenum, roomnum, checkin, checkout,pricetype);
	}
	
	//price & service
	public List<ReturnHotel> selectHotel(String str, java.util.Date checkin, 
			java.util.Date checkout, int roomnum, int peoplenum, String[] service, int pricetype){
		return returnHotelDAO.selectByAddreService(str, peoplenum, roomnum, checkin, checkout, service, pricetype);
	}
	
	//typeid & service
	public List<ReturnHotel> selectHotel(String str, java.util.Date checkin, 
			java.util.Date checkout, int roomnum, int peoplenum, int typeid, String[] service){
		return returnHotelDAO.selectByAddreService(str, peoplenum, roomnum, checkin, checkout, typeid,service);
	}
	
	//price & typeid
	public List<ReturnHotel> selectHotel(String str, java.util.Date checkin, 
			java.util.Date checkout, int roomnum, int peoplenum, int typeid, int pricetype){
		return returnHotelDAO.selectByAddress(str, peoplenum, roomnum, checkin, checkout, typeid, pricetype);
	}
	
	//price & typeid &service
	public List<ReturnHotel> selectHotel(String str, java.util.Date checkin, 
			java.util.Date checkout, int roomnum, int peoplenum, int typeid, int pricetype, String[] service){
		return returnHotelDAO.selectByAddreService(str, peoplenum, roomnum, checkin, checkout, typeid, service, pricetype);
	}
	
	//hotel
	public Hotel getHotel(int hotelid){
		Hotel Bean = hotelDAO.selectById(hotelid);
		return Bean;
	}
	
	//Service
	public List<Service> getHotelService(int hotelid){
		Set<Service> beans = hotelDAO.getHotelservice(hotelid);
		List<Service> results = new ArrayList();
		for(Service bean :beans){
			results.add(bean);
		}
		return results;
	}
	
	//Photo
	public List<HotelPhoto> getHotelPhoto(int hotelid){
		List<HotelPhoto> results =null;
		if(hotelid!=0) {
			Set<HotelPhoto> beans = hotelDAO.getHotelphoto(hotelid);
			results = new ArrayList();
			for(HotelPhoto bean :beans){
				results.add(bean);
			}
		}
		return results;
	}
	
	//Card
	public List<Card> getHotelCard(int hotelid){
		Set<Card> beans = hotelDAO.getHotelcard(hotelid);
		List<Card> results = new ArrayList();
		for(Card bean :beans){
			results.add(bean);
		}
		return results;
	}
	
	public List<HotelReview> getHotelReview(int hotelid){
		Set<HotelReview> beans = hotelDAO.getHotelreviews(hotelid);
		List<HotelReview> results = new ArrayList();
		for(HotelReview bean :beans){
			results.add(bean);
		}
		return results;
	}
	//得到評價數
	
	public Map<String, Object> getReviewAvg(int hotelid){
		Map<String, Object> hotelavg =null;
		if(hotelid!=0){
		 hotelavg = hotelDAO.getReviewAvg(hotelid);
		}
		return hotelavg;
	}
	

	
	public List<Integer> getRoomid(int hotelid){
		Set<RoomBean> roombeans =hotelDAO.getHotelrooms(hotelid);
		List<Integer> result =new ArrayList();
		for(RoomBean bean : roombeans){
			int n =bean.getRoomid();
			result.add(n);
		}
		return result;
	}
	

//	private HotelDAOHibernate hotelDAO;
//	private Year_roomsDAOHibernate year_rooms;
//	public List<List> selectHotel(String str,  java.util.Date checkin, 
//			java.util.Date checkout ){
//		List<Hotel> hotels = hotelDAO.selectByAddress(str);
//		for(Hotel hotel : hotels){
//			Set<RoomBean> rooms = hotel.getRooms();
//			
//			RoomBean[] resultroom;
//			for(RoomBean room : rooms){
//				
//				Year_roomsBean year_room = year_rooms.selectByCheckDay(room.getRoomid(), checkin, checkout);
//				
//				RoomBean Bean = new RoomBean();
//				Bean.setRoomid(room.getRoomid());
//				Bean.setHotelid(room.getHotelid());
//				Bean.setRoomname(room.getRoomname());
//				Bean.setPrice(room.getPrice());
//				Bean.setWeekdayrate(room.getWeekdayrate());
//				Bean.setPeoplenum(room.getPeoplenum());
//				Bean.setBedtype(room.getBedtype());
//				Bean.setNumber(year_room.getRoom_numbers());
//				Bean.setArea(room.getArea());
//				Bean.setStatus(room.getStatus());
//			}
//			
//		}
//		Set<RoomBean> rooms;
//		
//		return null;
//	}
}

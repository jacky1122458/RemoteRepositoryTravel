package cht.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cht.model.dao.HotelDAOHibernate;
import model.RoomBean;

public class SearchHotelService {
	private HotelDAOHibernate hotelDAO;
	public SearchHotelService(HotelDAOHibernate hotelDAO){
		this.hotelDAO = hotelDAO;
	}
	
	public List<Map<String,Object>> searchHotelResult(String address, java.util.Date checkin, java.util.Date checkout, int roomnum, int peoplenum){
		List<Hotel> hotels = hotelDAO.selectByAddress(address);
		List<Map<String,Object>> result = null;
		if(hotels!= null){
			result =this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum);
		}
		return result;
	}
	//AddressType
	public List<Map<String, Object>> searchAddressType(String address, java.util.Date checkin,
			java.util.Date checkout, int roomnum, int peoplenum, int typeid) {
		List<Hotel> hotels = hotelDAO.selectByAddressType(address, typeid);
		List<Map<String, Object>> result = null;
		if (hotels != null) {
			result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum);
		}
		return result;
	}
	
	//AddressService
	public List<Map<String,Object>> searchAddressService(String address, java.util.Date checkin, java.util.Date checkout, int roomnum, int peoplenum, String[] service){
		List<Hotel> hotels = hotelDAO.selectByAddressService(address, service);
		List<Map<String,Object>> result = null;
		if(hotels!= null){
			result =this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum);
		}
		System.out.println("result+++"+result);
		return result;
	}
	//AddressTypeService
	public List<Map<String, Object>> searchAddressTypeService(String address, java.util.Date checkin, java.util.Date checkout, int roomnum, int peoplenum, String[] service, int typeid) {
		List<Hotel> hotels = hotelDAO.selectByAddressTypeService(address, service, typeid);
		List<Map<String, Object>> result = null;
		if (hotels != null) {
			result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum);
		}
		return result;
	}
	//Name
	public List<Map<String,Object>> searchName(String name, java.util.Date checkin, java.util.Date checkout, int roomnum, int peoplenum){
		List<Hotel> hotels = hotelDAO.selectByName(name);
		List<Map<String,Object>> result = null;
		if(hotels!= null){
			result =this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum);
		}
		return result;
	}
	//NameType
	public List<Map<String, Object>> searchNameType(String name, java.util.Date checkin, java.util.Date checkout,
			int roomnum, int peoplenum, int typeid) {
		List<Hotel> hotels = hotelDAO.selectByNameType(name, typeid);
		List<Map<String, Object>> result = null;
		if (hotels != null) {
			result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum);
		}
		return result;
	}
	//NameService
	public List<Map<String, Object>> searchNameService(String name, java.util.Date checkin, java.util.Date checkout, int roomnum, int peoplenum, String[] service) {
		List<Hotel> hotels = hotelDAO.selectByNameService(name, service);
		List<Map<String, Object>> result = null;
		if (hotels != null) {
			result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum);
		}
		return result;
	}
	
	//NameTypeService
	public List<Map<String, Object>> searchNameTypeService(String name, java.util.Date checkin, java.util.Date checkout,
			int roomnum, int peoplenum, String[] service, int typeid) {
		List<Hotel> hotels = hotelDAO.selectByNameTypeService(name, service, typeid);
		List<Map<String, Object>> result = null;
		if (hotels != null) {
			result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum);
		}
		return result;
	}
	
	//AddressPrice
		public List<Map<String, Object>> searchAddressPrice(String address, java.util.Date checkin, java.util.Date checkout,
				int roomnum, int peoplenum, int priceleval) {
			List<Hotel> hotels = hotelDAO.selectByAddress(address);
			List<Map<String, Object>> result = null;
			int [] rage = this.getrage(priceleval);
			if (hotels != null) {
				result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum, rage[0], rage[1]);
			}
			return result;
		}
		
		//AddressTypePrice
		public List<Map<String, Object>> searchAddressTypePrice(String address, java.util.Date checkin, java.util.Date checkout,
				int roomnum, int peoplenum, int typeid, int priceleval) {
			List<Hotel> hotels = hotelDAO.selectByAddressType(address, typeid);
			List<Map<String, Object>> result = null;
			int[] rage = this.getrage(priceleval);
			if (hotels != null) {
				result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum, rage[0], rage[1]);
			}
			return result;
		}
		
		//AddressServicePrice
		public List<Map<String, Object>> searchAddressServicePrice(String address, java.util.Date checkin,
				java.util.Date checkout, int roomnum, int peoplenum, String[] service, int priceleval) {
			List<Hotel> hotels = hotelDAO.selectByAddressService(address, service);
			List<Map<String, Object>> result = null;
			int[] rage = this.getrage(priceleval);
			if (hotels != null) {
				result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum, rage[0], rage[1]);
			}
			return result;
		}
		
		//AddressTypeServicePrice
		public List<Map<String, Object>> searchAddressTypeServicePrice(String address, java.util.Date checkin,
				java.util.Date checkout, int roomnum, int peoplenum, String[] service, int typeid , int priceleval) {
			List<Hotel> hotels = hotelDAO.selectByAddressTypeService(address, service, typeid);
			List<Map<String, Object>> result = null;
			int[] rage = this.getrage(priceleval);
			if (hotels != null) {
				result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum, rage[0], rage[1]);
			}
			return result;
		}
		
		//NamePrice
		public List<Map<String, Object>> searchNamePrice(String address, java.util.Date checkin, java.util.Date checkout,
				int roomnum, int peoplenum, int priceleval) {
			List<Hotel> hotels = hotelDAO.selectByName(address);
			List<Map<String, Object>> result = null;
			int[] rage = this.getrage(priceleval);
			if (hotels != null) {
				result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum, rage[0], rage[1]);
			}
			return result;
		}
		
		//NameTypePrice
		public List<Map<String, Object>> searchNameTypePrice(String address, java.util.Date checkin,
				java.util.Date checkout, int roomnum, int peoplenum, int typeid, int priceleval) {
			List<Hotel> hotels = hotelDAO.selectByNameType(address, typeid);
			List<Map<String, Object>> result = null;
			int[] rage = this.getrage(priceleval);
			if (hotels != null) {
				result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum, rage[0], rage[1]);
			}
			return result;
		}
		
		//NameServicePrice
		public List<Map<String, Object>> searchNameServicePrice(String name, java.util.Date checkin, java.util.Date checkout,
				int roomnum, int peoplenum, String[] service, int priceleval) {
			List<Hotel> hotels = hotelDAO.selectByNameService(name, service);
			List<Map<String, Object>> result = null;
			int[] rage = this.getrage(priceleval);
			if (hotels != null) {
				result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum, rage[0], rage[1]);
			}
			return result;
		}
		
		//NameTypeServicePrice
		public List<Map<String, Object>> searchNameTypeServicePrice(String name, java.util.Date checkin, java.util.Date checkout,
				int roomnum, int peoplenum, String[] service, int typeid, int priceleval) {
			List<Hotel> hotels = hotelDAO.selectByNameTypeService(name, service, typeid);
			List<Map<String, Object>> result = null;
			int[] rage = this.getrage(priceleval);
			if (hotels != null) {
				result = this.chooseRoomComb(hotels, checkin, checkout, roomnum, peoplenum, rage[0], rage[1]);
			}
			return result;
		}
	
	
	public int[] getrage(int priceleval){
		int[] pricerage = new int[2];
		switch(priceleval){
		case 1 :
			pricerage[0]= 0;
			pricerage[1]= 2500;
			break;
		case 2 :
			pricerage[0]= 2500;
			pricerage[1]= 4500;
			break;
		case 3 :
			pricerage[0]= 4500;
			pricerage[1]= 6500;
			break;
		case 4 :
			pricerage[0]= 6500;
			pricerage[1]= 1000000;
			break;
		case 5 :
			pricerage[0]= 0;
			pricerage[1]= 8600;
			break;
		case 6 :
			pricerage[0]= 8600;
			pricerage[1]= 17000;
			break;
		case 7 :
			pricerage[0]= 17000;
			pricerage[1]= 25000;
			break;
		case 8 :
			pricerage[0]= 25000;
			pricerage[1]= 1000000;
			break;
		}
		return pricerage;
	}
	//+房價
	public List<Map<String,Object>> chooseRoomComb(List<Hotel> hotels, java.util.Date checkin, java.util.Date checkout, int roomnum, int peoplenum, int lowprice, int hightprice){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		if(hotels!= null){
			for(Hotel bean : hotels){
				List<Map<String,Object>> roomComb = this.returnRoomComb(bean, checkin, checkout);
				if(roomComb!=null){
					for(Map<String,Object> map : roomComb){
						if(peoplenum>((roomnum*2)-1)){
							if((Integer)map.get("peoplenum")==peoplenum && (Integer)map.get("roomnumber")==roomnum){
								if((Integer)map.get("price")>=lowprice && (Integer)map.get("price")<hightprice){
									
									Map<String,Object> mapresult =this.forRoomComb(bean, map);
									
									result.add(mapresult);
									break; }
							}
						}else{
							if((Integer)map.get("peoplenum")>=peoplenum && (Integer)map.get("roomnumber")==roomnum){
								if((Integer)map.get("price")>=lowprice && (Integer)map.get("price")<hightprice){
									
									Map<String,Object> mapresult =this.forRoomComb(bean, map);
									
									result.add(mapresult);
									break; }
							}
						}
					}	//Map迴圈
				}
			}	//Hotelbean迴圈
		}
		return result;
	}
	
	public List<Map<String,Object>> chooseRoomComb(List<Hotel> hotels, java.util.Date checkin, java.util.Date checkout, int roomnum, int peoplenum){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		if(hotels!= null){
			for(Hotel bean : hotels){
				List<Map<String,Object>> roomComb = this.returnRoomComb(bean, checkin, checkout);
				if(roomComb!=null){
					for(Map<String,Object> map : roomComb){
						if(peoplenum>((roomnum*2)-1)){
							if((Integer)map.get("peoplenum")==peoplenum && (Integer)map.get("roomnumber")==roomnum){
								Map<String,Object> mapresult =this.forRoomComb(bean, map);
								result.add(mapresult);
								//System.out.println("result"+result);
								break; }	//peoplenum判斷
						}else{
							if((Integer)map.get("peoplenum")>=peoplenum && (Integer)map.get("roomnumber")==roomnum){
								Map<String,Object> mapresult =this.forRoomComb(bean, map);
								result.add(mapresult);
								//System.out.println("result2"+result);
								break; }	//peoplenum判斷
						}
					}
				}
			}	//Hotelbean迴圈
		}
		return result;
	}
	
	public Map<String, Object> forRoomComb(Hotel bean ,Map<String,Object> map){
		Map<String,Object> mapresult = new HashMap<String,Object>();
		
		List<RoomBean> list = (List<RoomBean>)map.get("roomcomb");
		
		List<RoomBean> roomlist = new ArrayList<RoomBean>();	//接房間bean
		for(RoomBean roombean : list){	//去除0間房型
			if(roombean.getNumber()>0)
			{
				roomlist.add(roombean);
			}
		}
		
		mapresult.put("Hotelbean",bean);
		mapresult.put("roomlist",roomlist);
		mapresult.put("roomnumber", (Integer)map.get("roomnumber"));
		mapresult.put("peoplenum", (Integer)map.get("peoplenum"));
		mapresult.put("price", (Integer)map.get("price"));
		mapresult.put("weekdayrate", (Integer)map.get("weekdayrate"));
		
		return mapresult;
	}
	
	
	public List<Map<String,Object>> returnRoomComb(Hotel Hotelbean, java.util.Date checkin, java.util.Date checkout){
		List<RoomBean> beans = hotelDAO.getRoomsStatus(Hotelbean.getHotelid(), checkin, checkout);
		List<Map<String,Object>> roomcomb = null;
		
		if(beans!=null){	//取得房間組合
			roomcomb = this.getRoomComb(beans);
			if(roomcomb!=null){	//房間排序			
				this.sortRoom(roomcomb);
			}
		}
		return roomcomb;
	}
	
	
	public void sortRoom(List<Map<String,Object>> roomcomb){
		
		//屬性排序
		String byRoomnumber = "roomnumber";
		String byPeoplenum = "peoplenum";
		String byPrice = "price";

		// 建匿名 Comparator class
		Comparator<Map<String, Object>> comparator = new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				// 調用Integer的compareTo方法，排出來是遞增(ASC)
				// 遞減(DESC)把object1.2的順序互換
				int result = 0;
				result = ((Integer) o1.get(byPeoplenum)).compareTo((Integer) o2.get(byPeoplenum));
				if (result == 0) {
					result = ((Integer) o1.get(byRoomnumber)).compareTo((Integer) o2.get(byRoomnumber));
					if (result == 0) {
						result = ((Integer) o1.get(byPrice)).compareTo((Integer) o2.get(byPrice));
					}
				}
				return result;

			}

		};

		Collections.sort(roomcomb, comparator);
		
	}
	
	
	public List<Map<String,Object>> getRoomComb(List<RoomBean> beans){
		
		List<RoomBean> roomlist1 = null;
		List<List<RoomBean>> roomlist2 = new ArrayList<List<RoomBean>>();
		List<List<RoomBean>> roomlist3 = new ArrayList<List<RoomBean>>();
		int roomnumber= 0;int peoplenum= 0;int price= 0;int weekdayrate= 0;	//Map依據
		
		Map<String,Object> Rooms = null;
		List<Map<String,Object>> roomlist4 = new ArrayList<Map<String,Object>>();
		
		int count =0;
		for(RoomBean room : beans){
			count++;
			
			for(int i=0; i<=room.getNumber(); i++){
				RoomBean  bean = new RoomBean();
				bean.setRoomid(room.getRoomid());
				bean.setHotelid(room.getHotelid());
				bean.setRoomname(room.getRoomname());
				bean.setPrice(room.getPrice());
				bean.setWeekdayrate(room.getWeekdayrate());
				bean.setPeoplenum(room.getPeoplenum());
				bean.setBedtype(room.getBedtype());
				bean.setArea(room.getArea());
				bean.setStatus(room.getStatus());
				bean.setNumber(i);
				
				if(count==1){
					roomlist1 = new ArrayList<RoomBean>();
					roomlist1.add(bean);
					roomlist2.add(roomlist1);
				}
				
				if(count>=2){
					for(int x=0; x<=roomlist2.size()-1;x++){
						roomlist1 = new ArrayList<RoomBean>();
						roomnumber= 0;peoplenum= 0;price= 0;weekdayrate= 0;	//歸0
						for(RoomBean rb : roomlist2.get(x)){	//取出roomlist2裡List的bean
							roomlist1.add(rb);
							
							if(count==beans.size()){	//判斷是否最後一輪
								Rooms = new HashMap<String,Object>();
								roomnumber = roomnumber +rb.getNumber();
								peoplenum = peoplenum + rb.getNumber() * rb.getPeoplenum();
								price = price + rb.getNumber() * rb.getPrice();
								weekdayrate = weekdayrate + rb.getNumber() * rb.getWeekdayrate();
							}
						}if(count==beans.size()){
							roomnumber = roomnumber +bean.getNumber();
							peoplenum = peoplenum + bean.getNumber() * bean.getPeoplenum();
							price = price + bean.getNumber() * bean.getPrice();
							weekdayrate = weekdayrate + bean.getNumber() * bean.getWeekdayrate();
							
							Rooms.put("peoplenum", peoplenum);
							Rooms.put("roomnumber", roomnumber);
							Rooms.put("price", price);
							Rooms.put("weekdayrate", weekdayrate);
						}
						roomlist1.add(bean);	//加上新的bean
						if(count==beans.size()){
							Rooms.put("roomcomb",roomlist1);
							roomlist4.add(Rooms);
						}else{
							roomlist3.add(roomlist1);
						}
					}	
				}
				
			}	//roomRage
			
			
			if(roomlist3.size()!=0){	//list3替換去list2
				roomlist2 = new ArrayList<List<RoomBean>>();
				for(int y=0; y<=roomlist3.size()-1;y++){
					roomlist2.add(roomlist3.get(y));
				}
				roomlist3 = new ArrayList<List<RoomBean>>();
			}
			
		}	//beans迴圈
		
		
		if(roomlist4.size()==0){	//beans裡可能只有一種房型
			for(List<RoomBean> list : roomlist2){
				roomnumber= 0;peoplenum= 0;price= 0;weekdayrate= 0;	//歸0
				for(RoomBean bean: list){
					roomlist1 = new ArrayList<RoomBean>();
					roomnumber = roomnumber +bean.getNumber();
					peoplenum = peoplenum + bean.getNumber() * bean.getPeoplenum();
					price = price + bean.getNumber() * bean.getPrice();
					weekdayrate = weekdayrate + bean.getNumber() * bean.getWeekdayrate();
					roomlist1.add(bean);
					
					Rooms = new HashMap<String,Object>();
					Rooms.put("peoplenum", peoplenum);
					Rooms.put("roomnumber", roomnumber);
					Rooms.put("price", price);
					Rooms.put("weekdayrate", weekdayrate);
				}
				Rooms.put("roomcomb",roomlist1);
				roomlist4.add(Rooms);
			}
		}
		
		roomlist1 = null;
		roomlist2 = null;
		roomlist3 = null;
		
		return roomlist4;
	}
	
}

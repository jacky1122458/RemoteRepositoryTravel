package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cht.model.Card;
import cht.model.Collect;
import cht.model.Hotel;
import cht.model.HotelPhoto;
import cht.model.HotelReview;
import cht.model.Service;
import cht.model.dao.CollectDAOHibernate;
import cht.model.dao.HotelDAOHibernate;
import cht.model.dao.ReturnHotelDAOHibernate;
import cht.model.id.CollectId;
import model.dao.RoomDAOHibernate;

public class RoomService {
	private RoomDAOHibernate roomdao;
	public RoomService(RoomDAOHibernate roomdao){
		this.roomdao = roomdao;
	}
	//select
	public List<List> selectRooms(int hotelid, int peoplenum, int room_numbers, String checkin, String checkout,List<Integer> roomid){
		List<List> result = null;	
		if(hotelid !=0){
			result = new ArrayList<List>();
			for(int i=0;i<roomid.size();i++){
					try {
						List<List> temp = null;
						temp = roomdao.select_By_HotelId(checkin, checkout, hotelid, peoplenum, room_numbers, roomid.get(i));
						System.out.println(temp);
						
						if(!temp.isEmpty()) {
							result.add(temp.get(0));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				
			}
		}
		System.out.println(result);
		return result;
	}
	//insert
	public RoomBean insert(RoomBean bean) {
		RoomBean result = null;
		if(bean!=null) {
			result = roomdao.insert(bean);
		}
		return result;
	}
	//update
	public RoomBean update(RoomBean bean) {
		RoomBean result = null;
		if(bean!=null) {
			result = roomdao.update(bean.getRoomid(), bean.getHotelid(),bean.getRoomname(), bean.getPrice(), bean.getWeekdayrate(),bean.getPeoplenum(),bean.getBedtype(),bean.getNumber(),bean.getArea(),bean.getStatus());
			System.out.println(bean.getRoomid());
		}
		return result;
	}
	
}

package cht.model.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cht.model.Hotel;
import cht.model.dao.HotelDAOHibernate;
import model.RoomBean;
import model.Year_roomsBean;
import model.dao.Year_roomsDAOHibernate;

public class testHotelService {
	private HotelDAOHibernate hotelDAO;
	private Year_roomsDAOHibernate year_roomsDAO;

	public testHotelService(HotelDAOHibernate hotelDAO, Year_roomsDAOHibernate year_roomsDAO) {
		this.hotelDAO = hotelDAO;
		this.year_roomsDAO = year_roomsDAO;
	}

	public void getReulst(String address, java.util.Date checkin, java.util.Date checkout) {
		List<Hotel> hotels = hotelDAO.selectByAddress(address);
		List<RoomBean> roomlist = null;
		if (hotels != null) {
			for (Hotel hotel : hotels) {
				Set<RoomBean> rooms = hotel.getRooms();
				roomlist = new ArrayList();
				for (RoomBean room : rooms) {
					Year_roomsBean year_rooms = year_roomsDAO.get(room.getRoomid(), checkin, checkout);
					year_roomsDAO.getSession().evict(room);
					room.setNumber(year_rooms.getRoom_numbers());
					roomlist.add(room);
				}
			}
		}
		Map map = new HashMap();

		List a = null;
		for (RoomBean room : roomlist) {
			for (int i = 0; i <= room.getNumber(); i++) {
				a = new ArrayList();
				room.setNumber(i);
				a.add(room);
			}
		}

	}
}
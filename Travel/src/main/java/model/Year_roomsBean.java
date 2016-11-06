package model;

import java.util.Date;

import cht.model.misc.HibernateUtil;

public class Year_roomsBean {
	
	private int number;
	private int roomid;
	private java.util.Date yearday;
	private int room_numbers;
	
	
	@Override
	public String toString() {
		return "Year_roomsBean [number=" + number + ", roomid=" + roomid + ", yearday=" + yearday + ", room_numbers="
				+ room_numbers + "]";
	}
	
	//多對一
	private RoomBean roombean;
	public RoomBean getRoombean() {
		return roombean;
	}
	public void setRoombean(RoomBean roombean) {
		this.roombean = roombean;
	}
	
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public java.util.Date getYearday() {
		return yearday;
	}
	public void setYearday(java.util.Date yearday) {
		this.yearday = yearday;
	}
	public int getRoom_numbers() {
		return room_numbers;
	}
	public void setRoom_numbers(int room_numbers) {
		this.room_numbers = room_numbers;
	}
	
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			Year_roomsBean year_roomsBean = 
					(Year_roomsBean)HibernateUtil.getSessionFactory().getCurrentSession().get(Year_roomsBean.class,1);
			System.out.println(year_roomsBean);
			
//			System.out.println("Year_roomsBean'"+year_roomsBean.getRoombean());	//room
			
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

	
}

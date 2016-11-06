package model;


import java.util.Set;

import cht.model.Hotel;
import cht.model.misc.HibernateUtil;

public class RoomBean {
	private Integer roomid;
	private Integer hotelid;
	private String roomname;
	private Integer price;
	private Integer weekdayrate;
	private Integer peoplenum;
	private String bedtype;
	private Integer number;
	private Integer area;
	private Boolean status;
	
	
	@Override
	public String toString() {
		return "RoomBean [roomid=" + roomid + ", hotelid=" + hotelid + ", roomname=" + roomname + ", price=" + price
				+ ", weekdayrate=" + weekdayrate + ", peoplenum=" + peoplenum + ", bedtype=" + bedtype + ", number="
				+ number + ", area=" + area + ", status=" + status + "]";
	}
	
	
	//多對一
	private Hotel hb;
	public Hotel getHb() {
		return hb;
	}
	public void setHb(Hotel hb) {
		this.hb = hb;
	}
	//一對多
	private Set<Year_roomsBean> YRFR;
	public Set<Year_roomsBean> getYRFR() {
		return YRFR;
	}
	public void setYRFR(Set<Year_roomsBean> yRFR) {
		YRFR = yRFR;
	}
	
	//一對多
	private Set<Order_detailsBean> detailsbean;
	public Set<Order_detailsBean> getDetailsbean() {
		return detailsbean;
	}
	public void setDetailsbean(Set<Order_detailsBean> detailsbean) {
		this.detailsbean = detailsbean;
	}
	
	
	public Integer getRoomid() {
		return roomid;
	}


	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}


	public Integer getHotelid() {
		return hotelid;
	}


	public void setHotelid(Integer hotelid) {
		this.hotelid = hotelid;
	}


	public String getRoomname() {
		return roomname;
	}


	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getWeekdayrate() {
		return weekdayrate;
	}


	public void setWeekdayrate(Integer weekdayrate) {
		this.weekdayrate = weekdayrate;
	}


	public Integer getPeoplenum() {
		return peoplenum;
	}


	public void setPeoplenum(Integer peoplenum) {
		this.peoplenum = peoplenum;
	}


	public String getBedtype() {
		return bedtype;
	}


	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public Integer getArea() {
		return area;
	}


	public void setArea(Integer area) {
		this.area = area;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			RoomBean roomBean = 
					(RoomBean)HibernateUtil.getSessionFactory().getCurrentSession().get(RoomBean.class,1);
			System.out.println(roomBean);
			
//			System.out.println(roomBean.getHb());	//Hotels
//			System.out.println(roomBean.getYRFR());	//YEAR_ROOMS
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
	
}

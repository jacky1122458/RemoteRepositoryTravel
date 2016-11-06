package cht.model;

public class ReturnHotel {
	private int 	hotelid;
	private String 	hotelname;
	private Integer class_level;
	private String 	address;
	private double 	lat;
	private double 	lng;
	private Double tol_avg;
	private Integer total_comment;
	private int 	roomid;
	private String 	roomname;
	private int 	price;
	private int 	weekdayrate;
	private int 	peoplenum;
	private String 	bedtype;
	
	@Override
	public String toString() {
		return "ReturnHotel [hotelid=" + hotelid + ", hotelname=" + hotelname + ", class_level=" + class_level
				+ ", address=" + address + ", lat=" + lat + ", lng=" + lng + ", tol_avg=" + tol_avg + ", total_comment="
				+ total_comment + ", roomid=" + roomid + ", roomname=" + roomname + ", price=" + price
				+ ", weekdayrate=" + weekdayrate + ", peoplenum=" + peoplenum + ", bedtype=" + bedtype + "]";
	}

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public Integer getClass_level() {
		return class_level;
	}

	public void setClass_level(Integer class_level) {
		this.class_level = class_level;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public Double getTol_avg() {
		return tol_avg;
	}

	public void setTol_avg(Double tol_avg) {
		this.tol_avg = tol_avg;
	}

	public Integer getTotal_comment() {
		return total_comment;
	}

	public void setTotal_comment(Integer total_comment) {
		this.total_comment = total_comment;
	}

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWeekdayrate() {
		return weekdayrate;
	}

	public void setWeekdayrate(int weekdayrate) {
		this.weekdayrate = weekdayrate;
	}

	public int getPeoplenum() {
		return peoplenum;
	}

	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}

	public String getBedtype() {
		return bedtype;
	}

	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}
}

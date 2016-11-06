package cht.model.test;

public class ReturnRoom {
	private Integer roomid;
	private String roomname;
	private Integer price;
	private Integer weekdayrate;
	@Override
	public String toString() {
		return "ReturnRoom [roomid=" + roomid + ", roomname=" + roomname + ", price=" + price + ", weekdayrate="
				+ weekdayrate + "]";
	}
	public Integer getRoomid() {
		return roomid;
	}
	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
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
	
	
}

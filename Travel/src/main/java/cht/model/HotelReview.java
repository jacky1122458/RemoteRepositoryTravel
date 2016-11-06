package cht.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import model.Hotel_orderBean;
import model.MemberBean;
import model.Order_detailsBean;
@Entity
public class HotelReview {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderid;
	private int memberid;
	private int hotelid;
	private java.util.Date date;
	private int cleanliness;
	private int comfort;
	private int location; 
	private int facilities; 
	private int staff;
	private int cp;
	private int total;
	private String advantage;
	private String defect;
	private boolean display;
	
	
	@Override
	public String toString() {
		return "HotelReview [orderid=" + orderid + ", memberid=" + memberid + ", hotelid=" + hotelid + ", date=" + date
				+ ", cleanliness=" + cleanliness + ", comfort=" + comfort + ", location=" + location + ", facilities="
				+ facilities + ", staff=" + staff + ", cp=" + cp + ", total=" + total + ", advantage=" + advantage
				+ ", defect=" + defect + ", display=" + display + "]";
	}
	
	//Hotel
	@ManyToOne
	@JoinColumn(name="HOTELID", referencedColumnName="HOTELID", 
				insertable=false, updatable=false)
	private Hotel hotel;
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	//Member
	@OneToOne
	@JoinColumn(name="MEMBERID",referencedColumnName="MEMBERID",
				insertable=false,updatable=false)
	private MemberBean member;
	public MemberBean getMember() {
		return member;
	}
	public void setMember(MemberBean member) {
		this.member = member;
	}
	
//	//OrderBean
//	@OneToOne
//	@JoinColumn(name="ORDERID",referencedColumnName="ORDERID",
//				insertable=false,updatable=false)
//	private Hotel_orderBean orderBean;
//	public Hotel_orderBean getOrderBean() {
//		return orderBean;
//	}
//	public void setOrderBean(Hotel_orderBean orderBean) {
//		this.orderBean = orderBean;
//	}
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public int getCleanliness() {
		return cleanliness;
	}
	public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
	}
	public int getComfort() {
		return comfort;
	}
	public void setComfort(int comfort) {
		this.comfort = comfort;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getFacilities() {
		return facilities;
	}
	public void setFacilities(int facilities) {
		this.facilities = facilities;
	}
	public int getStaff() {
		return staff;
	}
	public void setStaff(int staff) {
		this.staff = staff;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getAdvantage() {
		return advantage;
	}
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	public String getDefect() {
		return defect;
	}
	public void setDefect(String defect) {
		this.defect = defect;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	
	
}

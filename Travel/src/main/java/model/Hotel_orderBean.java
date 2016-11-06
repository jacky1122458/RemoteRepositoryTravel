package model;

import java.util.Set;

import cht.model.HotelReview;

public class Hotel_orderBean {

	private int orderid;
	private int memberid;
	private int price_total;
	private java.util.Date orderdate;
	private java.util.Date checkin;
	private java.util.Date checkout;
	
	
	private Set<Order_detailsBean> od;
	public Set<Order_detailsBean> getOd() {
		return od;
	}
	public void setOd(Set<Order_detailsBean> od) {
		this.od = od;
	}
	
	private MemberBean member;
	public MemberBean getMember() {
		return member;
	}
	public void setMember(MemberBean member) {
		this.member = member;
	}
	
	//一對一
	private HotelReview hotelreview;
	public HotelReview getHotelreview() {
		return hotelreview;
	}
	public void setHotelreview(HotelReview hotelreview) {
		this.hotelreview = hotelreview;
	}
	
	@Override
	public String toString() {
		return "Hotel_orderBean [orderid=" + orderid + ", memberid=" + memberid + ", price_total=" + price_total
				+ ", orderdate=" + orderdate + ", checkin=" + checkin + ", checkout=" + checkout + ", evaluatstatus="
				+ /*evaluatstatus +*/ "]";
	}
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
	public int getPrice_total() {
		return price_total;
	}
	public void setPrice_total(int price_total) {
		this.price_total = price_total;
	}
	public java.util.Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(java.util.Date orderdate) {
		this.orderdate = orderdate;
	}
	public java.util.Date getCheckin() {
		return checkin;
	}
	public void setCheckin(java.util.Date checkin) {
		this.checkin = checkin;
	}
	public java.util.Date getCheckout() {
		return checkout;
	}
	public void setCheckout(java.util.Date checkout) {
		this.checkout = checkout;
	}
	
//	private boolean evaluatstatus;
//	public boolean isEvaluatstatus() {
//		return evaluatstatus;
//	}
//	public void setEvaluatstatus(boolean evaluatstatus) {
//		this.evaluatstatus = evaluatstatus;
//	}
}

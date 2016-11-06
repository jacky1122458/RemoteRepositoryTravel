package jj.model;

import model.MemberBean;

public class Tour_orderBean {
	
	
	private int order_id;
	private int member_id;
	private int tour_id;
	private int number_people;
	private int price;
	private String ordername;
	private String phone;
	private java.util.Date order_date;
	private java.util.Date departure_date ;
	private boolean order_status;
	
	
	private MemberBean memberBean;
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	
	private TourBean tourBean;
	public TourBean getTourBean() {
		return tourBean;
	}
	public void setTourBean(TourBean tourBean) {
		this.tourBean = tourBean;
	}
	
	
	private Tour_evaluateBean tour_evaluate;
	public Tour_evaluateBean getTour_evaluate() {
		return tour_evaluate;
	}
	public void setTour_evaluate(Tour_evaluateBean tour_evaluate) {
		this.tour_evaluate = tour_evaluate;
	}
	
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getTour_id() {
		return tour_id;
	}
	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}
	public int getNumber_people() {
		return number_people;
	}
	public void setNumber_people(int number_people) {
		this.number_people = number_people;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public java.util.Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(java.util.Date order_date) {
		this.order_date = order_date;
	}
	public java.util.Date getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(java.util.Date departure_date) {
		this.departure_date = departure_date;
	}
	public boolean isOrder_status() {
		return order_status;
	}
	public void setOrder_status(boolean order_status) {
		this.order_status = order_status;
	}
	
	@Override
	public String toString() {
		return "Tour_orderBean [order_id=" + order_id + ", member_id=" + member_id + ", tour_id=" + tour_id
				+ ", number_people=" + number_people + ", price=" + price + ", ordername=" + ordername + ", phone="
				+ phone + ", order_date=" + order_date + ", departure_date=" + departure_date + ", order_status="
				+ order_status + "]";
	}
	
	

	
	
	
	
}

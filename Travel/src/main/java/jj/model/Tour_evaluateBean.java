package jj.model;

import model.MemberBean;

public class Tour_evaluateBean {
	private int    order_id;
	private int    tour_id;
	private int   member_id ;
	private String evaluate;
	private int   rating;
	private boolean evaluate_status;
	
	private Tour_orderBean tour_order;
	public Tour_orderBean getTour_order() {
		return tour_order;
	}
	public void setTour_order(Tour_orderBean tour_order) {
		this.tour_order = tour_order;
	}
	
	
	private TourBean tourid;
	public TourBean getTourid() {
		return tourid;
	}
	public void setTourid(TourBean tourid) {
		this.tourid = tourid;
	}
	
	
	private MemberBean memberid;
	public MemberBean getMemberid() {
		return memberid;
	}
	public void setMemberid(MemberBean memberid) {
		this.memberid = memberid;
	}

	public int getTour_id() {
		return tour_id;
	}
	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public boolean isEvaluate_status() {
		return evaluate_status;
	}
	public void setEvaluate_status(boolean evaluate_status) {
		this.evaluate_status = evaluate_status;
	}
	@Override
	public String toString() {
		return "Tour_evaluateBean [order_id=" + order_id + ", tour_id=" + tour_id + ", member_id=" + member_id
				+ ", evaluate=" + evaluate + ", rating=" + rating + ", evaluate_status="
				+ evaluate_status + "]";
	}
	
	
	
	
	
}

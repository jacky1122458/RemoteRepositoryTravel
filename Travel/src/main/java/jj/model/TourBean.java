package jj.model;

import java.util.Set;

public class TourBean {
	private int tour_id;		
	private String tour_name;			
	private int tour_restrict;		
	private int tour_price;			
	private String meeting_time;		
	private String cost_gloze;		
	private int age_limit;			
	private String meals;				
	private String remark;				
	private String meeting_place;		
	private java.lang.Double lat;					
	private java.lang.Double lng;					
	private boolean tour_status;			 
	private String explanation;		 
	private java.util.Date departure_date;
	
	
	private Set<Tour_orderBean> tourid;
	private Set<Tour_evaluateBean> tourid1;
	private Set<Travel_attractionsBean> tourid2;
	
	
	public Set<Travel_attractionsBean> getTourid2() {
		return tourid2;
	}
	public void setTourid2(Set<Travel_attractionsBean> tourid2) {
		this.tourid2 = tourid2;
	}
	public Set<Tour_evaluateBean> getTourid1() {
		return tourid1;
	}
	public void setTourid1(Set<Tour_evaluateBean> tourid1) {
		this.tourid1 = tourid1;
	}
	public Set<Tour_orderBean> getTourid() {
		return tourid;
	}
	public void setTourid(Set<Tour_orderBean> tourid) {
		this.tourid = tourid;
	}
	@Override
	public String toString() {
		return "TourBean [tour_id=" + tour_id + ", tour_name=" + tour_name + ", tour_restrict=" + tour_restrict
				+ ", tour_price=" + tour_price + ", meeting_time=" + meeting_time + ", cost_gloze=" + cost_gloze
				+ ", age_limit=" + age_limit + ", meals=" + meals + ", remark=" + remark + ", meeting_place="
				+ meeting_place + ", lat=" + lat + ", lng=" + lng + ", tour_status=" + tour_status + ", explanation="
				+ explanation + ", departure_date=" + departure_date + "]";
	}
	public int getTour_id() {
		return tour_id;
	}
	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}
	public String getTour_name() {
		return tour_name;
	}
	public void setTour_name(String tour_name) {
		this.tour_name = tour_name;
	}
	public int getTour_restrict() {
		return tour_restrict;
	}
	public void setTour_restrict(int tour_restrict) {
		this.tour_restrict = tour_restrict;
	}
	public int getTour_price() {
		return tour_price;
	}
	public void setTour_price(int tour_price) {
		this.tour_price = tour_price;
	}
	public String getMeeting_time() {
		return meeting_time;
	}
	public void setMeeting_time(String meeting_time) {
		this.meeting_time = meeting_time;
	}
	public String getCost_gloze() {
		return cost_gloze;
	}
	public void setCost_gloze(String cost_gloze) {
		this.cost_gloze = cost_gloze;
	}
	public int getAge_limit() {
		return age_limit;
	}
	public void setAge_limit(int age_limit) {
		this.age_limit = age_limit;
	}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMeeting_place() {
		return meeting_place;
	}
	public void setMeeting_place(String meeting_place) {
		this.meeting_place = meeting_place;
	}
	public java.lang.Double getLat() {
		return lat;
	}
	public void setLat(java.lang.Double lat) {
		this.lat = lat;
	}
	public java.lang.Double getLng() {
		return lng;
	}
	public void setLng(java.lang.Double lng) {
		this.lng = lng;
	}
	public boolean isTour_status() {
		return tour_status;
	}
	public void setTour_status(boolean tour_status) {
		this.tour_status = tour_status;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public java.util.Date getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(java.util.Date departure_date) {
		this.departure_date = departure_date;
	}
	
	
	
	
	
}
